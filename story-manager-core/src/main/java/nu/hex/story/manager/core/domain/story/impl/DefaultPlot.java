package nu.hex.story.manager.core.domain.story.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.domain.story.PlotItem;
import nu.hex.story.manager.core.domain.story.Story;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
@Entity
@Table(name = "Plot")
public class DefaultPlot implements Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultStory.class)
    @JoinColumn(name = "story_id")
    private Story story;
    @OneToMany(targetEntity = DefaultPlotItem.class, mappedBy = "plot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<PlotItem> plotItems = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return "Story Plot for \"" + getStory().getTitle() + "\"";
    }

    @Override
    public Story getStory() {
        return story;
    }

    @Override
    public void setStory(Story story) {
        this.story = story;
    }

    @Override
    public List<PlotItem> getPlotItems() {
        List<PlotItem> result = new ArrayList<>(plotItems);
        Collections.sort(result);
        return result;
    }

    @Override
    public void addPlotItem(PlotItem item) {
        plotItems.add(item);
    }
}
