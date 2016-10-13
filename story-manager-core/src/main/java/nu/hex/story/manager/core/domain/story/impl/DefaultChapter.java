package nu.hex.story.manager.core.domain.story.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.story.Chapter;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.core.util.RomanNumerals;

@Entity
@Table(name = "Chapter")
public class DefaultChapter implements Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String heading;
    @Column
    private Integer number;
    @Column(length = 1024 * 2)
    private String description;
    @Column(length = 1024 * 1024)
    private String text;
    @ManyToOne(targetEntity = DefaultStory.class)
    private Story story;

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
        return getHeading();
    }

    @Override
    public Story getStory() {
        return story;
    }

    @Override
    public void setStory(Story story) {
        this.story = story;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String getRomanNumeral() {
        return new RomanNumerals(number).getRoman();
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
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void appendText(String text) {
        this.text += text;
    }

    @Override
    public int compareTo(Chapter o) {
        if (this.getNumber() != null && o.getNumber() != null) {
            return this.getNumber().compareTo(o.getNumber());
        }
        return this.getId().compareTo(o.getId());
    }
}
