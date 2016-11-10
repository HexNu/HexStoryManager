package nu.hex.story.manager.core.domain.rpg.character;

import nu.hex.story.manager.core.domain.DomainEntity;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCAbilityScore;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public interface Skill extends DomainEntity<Long> {

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Integer getBaseChance();

    void setBaseChance(Integer baseChance);

    CoCAbilityScore.Ability getAbilityBase();

    void setAbilityBase(CoCAbilityScore.Ability abilityBase);

    Integer getAbilityMultiplier();

    void setAbilityMultiplier(Integer abilityMultiplier);

}
