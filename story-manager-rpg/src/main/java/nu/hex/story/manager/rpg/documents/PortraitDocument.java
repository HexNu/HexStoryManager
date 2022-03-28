package nu.hex.story.manager.rpg.documents;

import java.time.LocalDate;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PortraitDocument implements Portrait {

    private String label;
    private String shortDescription;
    private String description;
    private Image image;
    private String date;
    private Person owner;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
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
    public void setDate(LocalDate date) {
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public String getName() {
        return getLabel();
    }

    @Override
    public int compareTo(Portrait o) {
        int result = this.getLabel().compareTo(o.getLabel());
        if (result == 0) {
            result = this.getShortDescription().compareTo(o.getShortDescription());
        }
        if (result == 0) {
            result = this.getDescription().compareTo(o.getDescription());
        }
        return result;
    }
}
