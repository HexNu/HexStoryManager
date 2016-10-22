package nu.hex.story.manager.core.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.domain.story.impl.DefaultPlot;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class PlotDao extends GenericDao<Plot, Long> {

    public PlotDao(EntityManager entityManager) {
        super(DefaultPlot.class, entityManager);
    }

    public Plot persist(Plot plot) {
        if (plot.getId() == null) {
            return save(plot);
        } else {
            return update(plot);
        }
    }

}
