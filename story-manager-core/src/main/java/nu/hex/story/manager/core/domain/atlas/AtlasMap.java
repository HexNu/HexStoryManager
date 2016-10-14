package nu.hex.story.manager.core.domain.atlas;

import nu.hex.story.manager.core.domain.DomainObject;
import nu.hex.story.manager.core.domain.image.Image;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public interface AtlasMap extends DomainObject<Long> {

    Atlas getAtlas();

    void setAtlas(Atlas atlas);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getAuthor();

    void setAuthor(String author);

    Image getImage();

    void setImage(Image image);

}
