package nu.hex.story.manager.core.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.image.impl.DefaultPortrait;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
public class PortraitDao extends GenericDao<Portrait, Long> {
    
    public PortraitDao(EntityManager entityManager) {
        super(DefaultPortrait.class, entityManager);
    }
    
}
