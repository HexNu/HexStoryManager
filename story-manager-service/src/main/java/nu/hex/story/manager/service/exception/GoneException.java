package nu.hex.story.manager.service.exception;

/**
 *
 * @author jep
 */
public class GoneException extends ServiceException {

    public GoneException(String message) {
        super(message, null);
    }

    public GoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
