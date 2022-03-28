package nu.hex.story.manager.dto.out;

import java.util.List;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetAtlasDTO {

    private Long id;
    private String title;
    private String description;
    private List<GetMapDTO> maps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GetMapDTO> getMaps() {
        return maps;
    }

    public void setMaps(List<GetMapDTO> maps) {
        this.maps = maps;
    }

}
