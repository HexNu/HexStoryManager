package nu.hex.story.manager.core.domain.atlas;

import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public interface AtlasMap extends DomainEntity<Long> {

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
