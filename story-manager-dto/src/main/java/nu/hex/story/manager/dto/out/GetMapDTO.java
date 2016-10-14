package nu.hex.story.manager.dto.out;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetMapDTO {

    private Long id;
    private String title;
    private String description;
    private GetImageDTO image;

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

    public GetImageDTO getImage() {
        return image;
    }

    public void setImage(GetImageDTO image) {
        this.image = image;
    }
}
