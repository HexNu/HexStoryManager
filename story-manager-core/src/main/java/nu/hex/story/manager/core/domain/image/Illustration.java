package nu.hex.story.manager.core.domain.image;

import java.time.LocalDate;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public interface Illustration extends DomainEntity<Long> {

    String getShortDescription();

    void setShortDescription(String shortDescription);

    String getDescription();

    void setDescription(String description);

    String getLabel();

    void setLabel(String label);

    LocalDate getDate();

    void setDate(LocalDate date);

    Image getImage();

    void setImage(Image image);
}
