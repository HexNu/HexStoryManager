package nu.hex.story.manager.core.domain.person.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.image.impl.DefaultImage;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.Portrait;
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultImage.class)
    @JoinColumn(name = "image_id")
    private Image image;
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

    public LocalDate getPortraitDate() {
        return portraitDate;
    }

    public void setPortraitDate(LocalDate portraitDate) {
        this.portraitDate = portraitDate;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
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
