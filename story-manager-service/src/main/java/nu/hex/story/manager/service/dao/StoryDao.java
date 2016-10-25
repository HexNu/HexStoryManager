package nu.hex.story.manager.service.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.core.domain.story.impl.DefaultStory;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class StoryDao extends GenericDao<Story, Long> {

    public StoryDao(EntityManager entityManager) {
        super(DefaultStory.class, entityManager);
    }

    public Story persist(Story story) {
        if (story.getId() == null) {
            return save(story);
        } else {
            return update(story);
        }
    }

}
