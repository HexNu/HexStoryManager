package nu.hex.story.manager.rpg.documents.io;

/**
 * Created 2016-nov-10
 *
 * @author hl
 * @param <T>
 * @param <U>
 */
public abstract class AbstractWriter<T, U> implements DocumentWriter<T, U> {

    protected final T doc;

    public AbstractWriter(T doc) {
        this.doc = doc;
    }
}
