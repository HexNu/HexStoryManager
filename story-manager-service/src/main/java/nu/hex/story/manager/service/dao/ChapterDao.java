package nu.hex.story.manager.service.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.story.Chapter;
import nu.hex.story.manager.core.domain.story.impl.DefaultChapter;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class ChapterDao extends GenericDao<Chapter, Long> {

    public ChapterDao(EntityManager entityManager) {
        super(DefaultChapter.class, entityManager);
    }

    public Chapter persist(Chapter story) {
        if (story.getId() == null) {
            return save(story);
        } else {
            return update(story);
        }
    }
}
