package nu.hex.story.manager.service.exception;

/**
 *
 * @author jep
 */
public class NotFoundException extends ServiceException {

    public NotFoundException(String message) {
        super(message, null);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
