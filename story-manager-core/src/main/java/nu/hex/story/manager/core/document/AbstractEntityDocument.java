package nu.hex.story.manager.core.document;

/**
 * Created 2016-okt-18
 *
 * @author hl
 * @param <T>
 */
public abstract class AbstractEntityDocument<T> implements EntityDocument {

    private final T entity;

    public AbstractEntityDocument(T entity) {
        this.entity = entity;
    }

    protected T getEntity() {
        return entity;
    }
}
