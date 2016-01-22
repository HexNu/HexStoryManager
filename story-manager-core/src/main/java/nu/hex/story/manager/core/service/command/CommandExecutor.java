package nu.hex.story.manager.core.service.command;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import nu.hex.story.manager.core.service.exception.ServiceException;
import nu.hex.story.manager.core.service.support.EmHandlerProvider;

/**
 *
 * @author thomas
 */
public class CommandExecutor {

    private EmHandlerProvider provider;

    public CommandExecutor() {
    }

    public CommandExecutor(EmHandlerProvider provider) {
        this.provider = provider;
    }

    private <T> T executeInternally(ServiceCommand<T> command) {
        try {
            command.setEmHandlerProvider(provider);
            return command.execute();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(null, ex);
        }
    }

    public <T> T execute(ServiceCommand<T> command) {
        try {
            return executeInternally(command);
        } finally {
            provider.getEmHandler().closeManager();
        }
    }

    public <T> T executeInTransaction(ServiceCommand<T> command) {
        EntityTransaction tx = provider.getEmHandler().getManager().getTransaction();
        try {
            tx.begin();
            T result = executeInternally(command);
            tx.commit();
            return result;
        } catch (RollbackException ex) {
            throw ex;
        } catch (RuntimeException ex) {
            tx.rollback();
            throw ex;
        } catch (Exception ex) {
            tx.rollback();
            throw new ServiceException("Transaktion misslyckades pga: " + ex.getLocalizedMessage(), ex);
        } finally {
            provider.getEmHandler().closeManager();
        }
    }
}
