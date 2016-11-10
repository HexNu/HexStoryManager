package nu.hex.story.manager.core.domain.atlas;

import java.util.List;
import nu.hex.story.manager.core.domain.DomainEntity;
import nu.hex.story.manager.core.domain.image.Illustration;

/**
 * Created 2016-nov-09
 *
 * @author hl
 */
public interface Location extends DomainEntity<Long> {

    void setName(String name);

    Double getLongitude();

    void setLongitude(Double longitude);

    Double getLatitude();

    void setLatitude(Double longitude);

    String getDescription();

    void setDescription(String description);

    List<Illustration> getIllustrations();

    void setIllustrations(List<Illustration> illustrations);

    void addIllustration(Illustration illustration);
}
