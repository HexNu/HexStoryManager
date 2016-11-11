package nu.hex.story.manager.rpg.documents.io;

/**
 * Created 2016-nov-09
 *
 * @author hl
 * @param <T>
 * @param <R>
 */
public interface DocumentWriter<T, R> {

    R write();
}
