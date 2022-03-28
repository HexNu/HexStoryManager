package nu.hex.story.manager.core.domain.person;

import nu.hex.story.manager.core.domain.event.Event;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public interface PersonalEvent extends Event {

    Person getOwner();

    void setOwner(Person owner);
}