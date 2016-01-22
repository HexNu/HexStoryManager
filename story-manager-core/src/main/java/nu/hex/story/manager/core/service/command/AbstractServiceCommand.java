package nu.hex.story.manager.core.service.command;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import nu.hex.story.manager.core.dao.DaoFactory;
import nu.hex.story.manager.core.service.exception.ServiceException;
import nu.hex.story.manager.core.service.support.EmHandlerProvider;

/**
 *
 * @author thomas
 * @param <T>
 */
public abstract class AbstractServiceCommand<T> implements ServiceCommand<T> {

    private EmHandlerProvider provider;

    public AbstractServiceCommand() {
    }

    @Override
    public final void setEmHandlerProvider(EmHandlerProvider provider) {
        this.provider = provider;
    }

    public EmHandlerProvider getProvider() {
        return provider;
    }

    private EntityManager getManager() {
        return provider.getEmHandler().getManager();
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return getManager().getCriteriaBuilder();
    }

    protected DaoFactory getDaoFactory() {
        return new DaoFactory(getManager());
    }

    protected <S> S executeSubcommand(ServiceCommand<S> subcommand) {
        return subcommand.execute();
    }

    protected <S> TypedQuery<S> executeQuery(String query, Class<S> s) {
        TypedQuery<S> createQuery = getManager().createQuery(query, s);
        return createQuery;
    }

    @Override
    public Object getSynchronizationObject() {
        throw new ServiceException("Synkronisering ej tillåten för detta kommando", null);
    }
}
