package nu.hex.story.manager.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.domain.atlas.impl.DefaultAtlas;
import nu.hex.story.manager.core.domain.atlas.impl.DefaultMap;

/**
 *
 * @author hl
 */
public class MapDao extends GenericDao<AtlasMap, Long> {

    public MapDao(EntityManager entityManager) {
        super(DefaultMap.class, entityManager);
    }

    @Override
    public AtlasMap save(AtlasMap entity) {
        if (entity.getId() != null) {
            super.update(entity);
            return entity;
        }
        return super.save(entity);
    }

    public AtlasMap findByTitle(String title) {
        try {
            return (DefaultMap) getManager().createNamedQuery("DefaultMap.findByTitle").setParameter("title", title).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
