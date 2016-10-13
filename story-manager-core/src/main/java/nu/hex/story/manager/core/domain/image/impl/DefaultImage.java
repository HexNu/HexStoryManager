package nu.hex.story.manager.core.domain.image.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.image.Image;

/**
 * Created 2016-okt-13
 *
 * @author hl
 */
@Entity
@Table(name = "Image")
public class DefaultImage implements Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Lob
    @Column(length = 1024 * 1024 * 62)
    private byte[] image;
    @Column
    private String mediaType;
    @Column
    private Integer width;
    @Column
    private Integer height;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public java.awt.Image getImage() {
        if (image != null) {
            InputStream inputStream = new ByteArrayInputStream(image);
            try {
                return ImageIO.read(inputStream);
            } catch (IOException ex) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public byte[] getImageAsByteArray() {
        return image != null ? image : new byte[0];
    }

    @Override
    public void setImageFromByteArray(byte[] image) {
        this.image = image.length > 0 ? image : null;
    }

    @Override
    public void setImageFromInputStream(InputStream stream) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int position;
            byte[] data = new byte[16384];
            while ((position = stream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, position);
            }
            buffer.flush();
            this.image = buffer.toByteArray();
        } catch (IOException e) {
        }
    }

    @Override
    public String getMediaType() {
        return mediaType;
    }

    @Override
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public void setHeight(Integer height) {
        this.height = height;
    }
}
