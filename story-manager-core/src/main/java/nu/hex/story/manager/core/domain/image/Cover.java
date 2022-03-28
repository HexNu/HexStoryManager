package nu.hex.story.manager.core.domain.image;

import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public interface Cover extends DomainEntity<Long> {

    Image getImage();
    
    void setImage(Image image);

    String getTitle();
    
    void setTitle(String title);
    
    String getAuthor();
    
    void setAuthor(String author);
}
