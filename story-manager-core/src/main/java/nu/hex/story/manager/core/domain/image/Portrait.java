package nu.hex.story.manager.core.domain.image;

import java.time.LocalDate;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public interface Portrait extends DomainEntity<Long>, Comparable<Portrait> {

    String getLabel();

    void setLabel(String label);

    Image getImage();

    void setImage(Image image);

    Person getOwner();

    void setOwner(Person owner);

    LocalDate getDate();

    void setDate(LocalDate date);

    void setDate(String date);

    String getDescription();

    void setDescription(String description);

    String getShortDescription();

    void setShortDescription(String shortDescription);

}
