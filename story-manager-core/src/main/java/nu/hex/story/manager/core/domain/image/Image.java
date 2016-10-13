package nu.hex.story.manager.core.domain.image;

import java.io.InputStream;
import nu.hex.story.manager.core.domain.DomainObject;

/**
 * Created 2016-okt-13
 *
 * @author hl
 */
public interface Image extends DomainObject<Long> {

    void setName(String name);

    java.awt.Image getImage();

    byte[] getImageAsByteArray();

    void setImageFromByteArray(byte[] image);

    void setImageFromInputStream(InputStream stream);

    String getMediaType();

    void setMediaType(String mediaType);

    Integer getWidth();

    void setWidth(Integer width);

    Integer getHeight();

    void setHeight(Integer height);

}
