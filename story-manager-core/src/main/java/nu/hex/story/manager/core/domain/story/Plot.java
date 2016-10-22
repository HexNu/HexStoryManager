package nu.hex.story.manager.core.domain.story;

import java.util.List;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public interface Plot extends DomainEntity<Long> {

    Story getStory();

    void setStory(Story story);

    List<PlotItem> getPlotItems();

    void addPlotItem(PlotItem item);
}
