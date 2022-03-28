package nu.hex.story.manager.service.dao;

import java.util.List;
import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkill;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class CoCSkillDao extends GenericDao<CoCSkill, Long> {

    public CoCSkillDao(EntityManager entityManager) {
        super(CoCSkill.class, entityManager);
    }

    public void saveSkills(List<CoCSkill> skills) {
        skills.stream().forEach(this::persist);
    }

    public void persist(CoCSkill skill) {
        if (skill.getId() == null) {
            save(skill);
        } else {
            update(skill);
        }
    }
}
