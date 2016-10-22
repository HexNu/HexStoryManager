package nu.hex.story.manager.core.domain.story;

import java.util.List;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
public interface Chapter extends DomainEntity<Long>, Comparable<Chapter> {

    Story getStory();

    void setStory(Story story);

    String getHeading();

    void setHeading(String heading);

    Integer getNumber();

    void setNumber(Integer number);

    String getRomanNumeral();

    String getDescription();

    void setDescription(String description);

    String getText();

    void setText(String text);

    void appendText(String text);

    List<Illustration> getIllustrations();

    void addIllustration(Illustration illustration);

    List<Portrait> getPortraits();

    void addPortrait(Portrait portrait);
    
    List<Person> getPersons();
    
    void addPerson(Person person);
}
