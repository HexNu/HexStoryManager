package nu.hex.story.manager.core.domain.impl;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.domain.Portrait;
import org.hibernate.annotations.Type;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
@Entity
@Table(name = "Portrait")
public class DefaultPortrait implements Portrait {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = DefaultPerson.class)
    private Person owner;
    @Temporal(TemporalType.DATE)
    @Type(type = "nu.hex.story.manager.core.jpa.LocalDateUserType")
    private LocalDate portraitDate;
    @Lob
    @Column(length = 1024 * 2024 * 32)
    private byte[] image;
    @Column
    private String mediaType;
    @Column
    private String label;
    @Column(length = 1024 * 128)
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return getLabel();
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Image getImage() {
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
    public Person getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public LocalDate getDate() {
        return portraitDate;
    }

    @Override
    public void setDate(LocalDate date) {
        this.portraitDate = date;
    }

    @Override
    public void setDate(String date) {
        this.portraitDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Portrait o) {
        int result = this.getDate().compareTo(o.getDate());
        if (result == 0) {
            result = this.getLabel().compareTo(o.getLabel());
        }
        return result;
    }
}
