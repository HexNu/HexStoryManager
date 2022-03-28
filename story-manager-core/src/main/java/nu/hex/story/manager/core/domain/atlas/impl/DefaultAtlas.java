package nu.hex.story.manager.core.domain.atlas.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
@Entity
@Table(name = "Atlas")
@NamedQueries({
    @NamedQuery(name = "DefaultAtlas.findByTitle", query = "SELECT a FROM DefaultAtlas a WHERE a.title = :title")
})
public class DefaultAtlas implements Atlas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column(length = 1024 * 20)
    private String description;
    @Column
    private String author;
    @OneToMany(mappedBy = "atlas", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = DefaultMap.class)
    private List<AtlasMap> maps = new ArrayList<>();

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
    public List<AtlasMap> getMaps() {
        return maps;
    }

    @Override
    public void setMaps(List<AtlasMap> maps) {
        this.maps.addAll(maps);
    }

    @Override
    public void addMap(AtlasMap map) {
        this.maps.add(map);
    }

}
