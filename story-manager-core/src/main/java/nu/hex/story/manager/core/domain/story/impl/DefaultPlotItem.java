package nu.hex.story.manager.core.domain.story.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.impl.DefaultIllustration;
import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.domain.story.PlotItem;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
@Entity
@Table(name = "PlotItem")
public class DefaultPlotItem implements PlotItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String label;
    @Column
    private Integer plotIndex;
    @Column(length = 1024 * 1024)
    private String text;
    @ManyToOne(targetEntity = DefaultPlot.class)
    private Plot plot;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultIllustration.class)
    @JoinColumn(name = "image_id")
    private Illustration illustration;

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
        return getLabel();
    }

    @Override
    public Plot getPlot() {
        return plot;
    }

    @Override
    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    @Override
    public Integer getIndex() {
        return plotIndex;
    }

    @Override
    public void setIndex(Integer index) {
        this.plotIndex = index;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Illustration getIllustration() {
        return illustration;
    }

    @Override
    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
    }

    @Override
    public int compareTo(PlotItem o) {
        return this.getIndex().compareTo(o.getIndex());
    }
}
