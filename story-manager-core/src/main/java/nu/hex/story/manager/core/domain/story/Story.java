package nu.hex.story.manager.core.domain.story;

import java.util.List;
import nu.hex.story.manager.core.domain.DomainObject;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
public interface Story extends DomainObject<Long> {

    String getTitle();

    void setTitle(String title);

    String getAuthor();

    void setAuthor(String author);

    List<Chapter> getChapters();

    void addChapter(Chapter chapter);
}
