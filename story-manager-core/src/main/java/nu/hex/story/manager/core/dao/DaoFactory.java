package nu.hex.story.manager.core.dao;

import javax.persistence.EntityManager;

/**
 * Created 2014-nov-26
 *
 * @author jep
 */
public class DaoFactory {

    private final EntityManager em;

    public DaoFactory(EntityManager em) {
        this.em = em;
    }
//
//    public EventDao getEventDao() {
//        return new EventDao(em);
//    }
    
}
