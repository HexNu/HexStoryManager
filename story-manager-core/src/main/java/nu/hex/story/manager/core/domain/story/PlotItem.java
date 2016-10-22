package nu.hex.story.manager.core.domain.story;

import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public interface PlotItem extends DomainEntity<Long>, Comparable<PlotItem> {

    Plot getPlot();

    void setPlot(Plot plot);

    Integer getIndex();

    void setIndex(Integer index);

    String getLabel();

    void setLabel(String label);

    String getText();

    void setText(String text);
    
    Illustration getIllustration();
    
    void setIllustration(Illustration illustration);
}
