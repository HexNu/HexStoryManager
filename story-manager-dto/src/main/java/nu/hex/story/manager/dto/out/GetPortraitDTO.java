package nu.hex.story.manager.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

/**
 * Created 2016-jun-28
 *
 * @author hl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPortraitDTO {

    @NotNull
    private Long id;
    private String date;
    private String label;
    private String shortDescription;
    private String description;
    private GetImageDTO image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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
