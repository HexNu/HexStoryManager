package nu.hex.story.manager.core.domain;

/**
 *
 * @author hl
 * @param <T>
 */
public interface DomainObject<T> {

    T getId();

    void setId(T id);
}
