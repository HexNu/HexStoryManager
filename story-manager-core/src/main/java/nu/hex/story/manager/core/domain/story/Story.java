package nu.hex.story.manager.core.domain.story;

import nu.hex.story.manager.core.domain.image.Cover;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
public interface Story extends DomainEntity<Long> {

    String getTitle();

    void setTitle(String title);

    String getSubTitle();

    void setSubTitle(String subTitle);

    String getAuthor();

    void setAuthor(String author);
    
    Cover getCover();
    
    void setCover(Cover cover);

    Plot getPlot();

    void setPlot(Plot plot);

    List<Person> getPersons();

    void addPerson(Person person);

    List<Chapter> getChapters();

    void addChapter(Chapter chapter);
}
