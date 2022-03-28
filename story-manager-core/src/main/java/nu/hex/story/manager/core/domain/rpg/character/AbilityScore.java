package nu.hex.story.manager.core.domain.rpg.character;

import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public interface AbilityScore extends DomainEntity<Long> {

    void setValue(Integer value);

    Integer getValue();
}
