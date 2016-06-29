package nu.hex.story.manager.core.domain;

import java.awt.Image;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public interface Portrait extends DomainObject<Long>, Comparable<Portrait> {

    String getLabel();

    void setLabel(String label);

    Image getImage();

    byte[] getImageAsByteArray();
    
    void setImageFromByteArray(byte[] image);
    
    void setImageFromInputStream(InputStream stream);
    
    String getMediaType();
    
    void setMediaType(String mediaType);

    Person getOwner();

    void setOwner(Person owner);

    LocalDate getDate();

    void setDate(LocalDate date);

    void setDate(String date);

    String getDescription();

    void setDescription(String description);

}
