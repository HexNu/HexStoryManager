package nu.hex.story.manager.core.service.support;

/**
 *
 * @author hl
 */
public class EmHandlerProvider {

    private EmHandler emHandler;

    public EmHandler getEmHandler() {
        if ((emHandler == null)) {
            emHandler = new ThreadSafeEmHandler();
        }
        return emHandler;
    }
}
