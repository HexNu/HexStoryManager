package nu.hex.story.manager.core.domain.atlas.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.image.impl.DefaultImage;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
@Entity
@Table(name = "Map")
@NamedQueries({
    @NamedQuery(name = "DefaultMap.findByTitle", query = "SELECT m FROM DefaultMap m WHERE m.title = :title")
})

public class DefaultMap implements AtlasMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = DefaultAtlas.class)
    private Atlas atlas;
    @Column
    private String title;
    @Column(length = 1024 * 20)
    private String description;
    @Column
    private String author;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultImage.class)
    @JoinColumn(name = "image_id")
    private Image image;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Atlas getAtlas() {
        return atlas;
    }

    @Override
    public void setAtlas(Atlas atlas) {
        this.atlas = atlas;
    }

    @Override
    public String getName() {
        return getTitle();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }
}
