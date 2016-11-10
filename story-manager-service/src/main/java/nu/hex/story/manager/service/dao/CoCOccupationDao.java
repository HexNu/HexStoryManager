package nu.hex.story.manager.service.dao;

import java.util.List;
import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCOccupation;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class CoCOccupationDao extends GenericDao<CoCOccupation, Long> {

    public CoCOccupationDao(EntityManager entityManager) {
        super(CoCOccupation.class, entityManager);
    }

    public void saveOccupations(List<CoCOccupation> occupations) {
        occupations.stream().forEach(this::persist);
    }

    public void persist(CoCOccupation occupation) {
        if (occupation.getId() == null) {
            save(occupation);
        } else {
            update(occupation);
        }
    }
}
