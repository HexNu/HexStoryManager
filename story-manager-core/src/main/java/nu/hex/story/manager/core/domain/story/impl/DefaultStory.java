package nu.hex.story.manager.core.domain.story.impl;

import nu.hex.story.manager.core.domain.image.impl.DefaultCover;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;
import nu.hex.story.manager.core.domain.story.Chapter;
import nu.hex.story.manager.core.domain.image.Cover;
import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.domain.story.Story;

@Entity
@Table(name = "Story")
public class DefaultStory implements Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String subTitle;
    @Column
    private String author;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultPlot.class)
    private Plot plot;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = DefaultCover.class)
    private Cover cover;
    @OneToMany(targetEntity = DefaultChapter.class, mappedBy = "story", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<Chapter> chapters = new HashSet<>();
    @ManyToMany(targetEntity = DefaultPerson.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
        return getTitle();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Cover getCover() {
        return cover;
    }

    @Override
    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public Plot getPlot() {
        return plot;
    }

    @Override
    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> result = new ArrayList<>(persons);
        return result;
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public List<Chapter> getChapters() {
        return new ArrayList(chapters);
    }

    @Override
    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
