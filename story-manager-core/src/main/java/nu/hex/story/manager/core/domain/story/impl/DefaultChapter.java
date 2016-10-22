package nu.hex.story.manager.core.domain.story.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.image.impl.DefaultIllustration;
import nu.hex.story.manager.core.domain.image.impl.DefaultPortrait;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;
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
    @OneToMany(targetEntity = DefaultIllustration.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<Illustration> illustrations = new HashSet<>();
    @OneToMany(targetEntity = DefaultPortrait.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<Portrait> portraits = new HashSet<>();
    @OneToMany(targetEntity = DefaultPerson.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<Person> persons = new HashSet<>();

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
    public List<Illustration> getIllustrations() {
        return new ArrayList<>(illustrations);
    }

    @Override
    public void addIllustration(Illustration illustration) {
        illustrations.add(illustration);
    }

    @Override
    public List<Portrait> getPortraits() {
        return new ArrayList<>(portraits);
    }

    @Override
    public void addPortrait(Portrait portrait) {
        portraits.add(portrait);
    }

    @Override
    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public int compareTo(Chapter o) {
        if (this.getNumber() != null && o.getNumber() != null) {
            return this.getNumber().compareTo(o.getNumber());
        }
        return this.getId().compareTo(o.getId());
    }
}
