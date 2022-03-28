package nu.hex.story.manager.service.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.impl.DefaultIllustration;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
public class IllustrationDao extends GenericDao<Illustration, Long> {
    
    public IllustrationDao(EntityManager entityManager) {
        super(DefaultIllustration.class, entityManager);
    }
    
}
