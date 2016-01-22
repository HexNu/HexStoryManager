package nu.hex.story.manager.core.domain;

import java.io.Serializable;

/**
 *
 * @author hl
 * @param <T>
 */
public interface DomainObject<T> extends Serializable {

    T getId();

    void setId(T id);
}
