package nu.hex.story.manager.service.support;

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
