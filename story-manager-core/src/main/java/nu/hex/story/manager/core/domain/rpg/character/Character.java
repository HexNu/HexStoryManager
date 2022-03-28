package nu.hex.story.manager.core.domain.rpg.character;

import nu.hex.story.manager.core.domain.person.Person;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public interface Character extends Person {

    Person getPerson();

    void setPerson(Person person);

    Stats getStats();

    void setStats(Stats stats);

}
