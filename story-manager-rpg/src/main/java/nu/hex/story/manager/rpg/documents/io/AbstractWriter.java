package nu.hex.story.manager.rpg.documents.io;

/**
 * Created 2016-nov-10
 *
 * @author hl
 * @param <T>
 */
public abstract class AbstractWriter<T> implements DocumentWriter<T> {

    protected final T doc;

    public AbstractWriter(T doc) {
        this.doc = doc;
    }
}
