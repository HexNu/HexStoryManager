package nu.hex.story.manager.core.domain;

import java.time.LocalDate;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public interface PersonalEvent extends DomainObject<Long>, Comparable<PersonalEvent> {

    Person getOwner();

    void setOwner(Person owner);

    LocalDate getDate();

    void setDate(LocalDate date);

    void setDate(String date);

    String getDescription();

    void setDescription(String description);

}
