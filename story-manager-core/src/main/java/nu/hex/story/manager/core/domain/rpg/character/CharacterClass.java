package nu.hex.story.manager.core.domain.rpg.character;

import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public interface CharacterClass extends DomainEntity<Long> {

    void setName(String name);
}
