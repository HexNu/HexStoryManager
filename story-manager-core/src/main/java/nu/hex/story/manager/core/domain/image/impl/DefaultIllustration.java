package nu.hex.story.manager.core.domain.image.impl;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Image;
import org.hibernate.annotations.Type;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
@Entity
@Table(name = "Illustration")
public class DefaultIllustration implements Illustration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultImage.class)
    @JoinColumn(name = "image_id")
    private Image image;
    @Temporal(TemporalType.DATE)
    @Type(type = "nu.hex.story.manager.core.jpa.LocalDateUserType")
    private LocalDate imageDate;
    @Column
    private String label;
    @Column(length = 1024 * 2)
    private String shortDescription;
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
        return "Fig. " + id;
    }

    @Override
    public String getShortDescription() {
        return shortDescription.replaceAll("[\\s]{2,}", " ");
    }

    @Override
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription.replaceAll("[\\s]{2,}", " ");
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
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public LocalDate getDate() {
        return imageDate;
    }

    @Override
    public void setDate(LocalDate date) {
        this.imageDate = date;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }
}
