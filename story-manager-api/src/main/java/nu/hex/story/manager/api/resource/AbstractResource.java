package nu.hex.story.manager.api.resource;

import nu.hex.story.manager.api.dto.DTOFactory;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.support.EmHandlerProvider;

/**
 *
 * @author jep
 */
public abstract class AbstractResource {

    private static final CommandExecutor EXECUTOR = new CommandExecutor(new EmHandlerProvider());
    private static final DTOFactory DTO_FACTORY = new DTOFactory();

    protected CommandExecutor commandExecutor() {
        return EXECUTOR;
    }

    protected DTOFactory DTOFactory() {
        return DTO_FACTORY;
    }
}
