package nu.hex.story.manager.core.domain.atlas;

import java.util.List;
import nu.hex.story.manager.core.domain.DomainObject;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public interface Atlas extends DomainObject<Long> {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getAuthor();

    void setAuthor(String author);

    List<AtlasMap> getMaps();
    
    void setMaps(List<AtlasMap> maps);

    void addMap(AtlasMap map);

}
