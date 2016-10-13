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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.story.Chapter;
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
    private String author;
    @OneToMany(targetEntity = DefaultChapter.class, mappedBy = "story", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<Chapter> chapters = new HashSet<>();

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
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
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
