package nu.hex.story.manager.rpg.documents;

import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.domain.image.Image;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class MapDocument implements AtlasMap {

    private Long id;
    private String title;
    private String description;
    private String author;
    private Image image = new ImageDocument();

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
    public Atlas getAtlas() {
        return null;
    }

    @Override
    public void setAtlas(Atlas atlas) {
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
