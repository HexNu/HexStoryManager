package nu.hex.story.manager.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created 2016-okt-13
 *
 * @author hl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetImageDTO {

    private Long id;
    private String name;
    private byte[] data;
    private String mediaType;
    private Integer width;
    private Integer height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
