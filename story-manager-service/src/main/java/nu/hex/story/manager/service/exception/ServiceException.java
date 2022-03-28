package nu.hex.story.manager.service.exception;

/**
 * Created 2009-dec-16
 *
 * @author thomas
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
