package nu.hex.story.manager.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.impl.DefaultAtlas;

/**
 *
 * @author hl
 */
public class AtlasDao extends GenericDao<Atlas, Long> {

    public AtlasDao(EntityManager entityManager) {
        super(DefaultAtlas.class, entityManager);
    }

    @Override
    public Atlas save(Atlas entity) {
        if (entity.getId() != null) {
            super.update(entity);
            return entity;
        }
        return super.save(entity);
    }

    public Atlas findByTitle(String title) {
        try {
            return (DefaultAtlas) getManager().createNamedQuery("DefaultAtlas.findByTitle").setParameter("title", title).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
