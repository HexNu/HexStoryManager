package nu.hex.story.manager.rpg.documents;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;
import nu.hex.story.manager.util.RomanNumerals;

/**
 * Created 2016-nov-09
 *
 * @author hl
 */
public class BookDocument implements Document {

    private Long id;
    private String title;
    private final List<BookDocument> volumes = new ArrayList<>();
    private final List<Person> authors = new ArrayList<>();
    private String placeOfPublication;
    private Integer yearOfPublication;
    private String publisher;
    private String language;
    private String subject;
    private String description;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void appendTitle(String title) {
        if (this.title == null) {
            this.title = title;
        } else {
            this.title += "\n" + title;
        }
    }

    public List<BookDocument> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<BookDocument> volumes) {
        this.volumes.clear();
        this.volumes.addAll(volumes);
    }

    public void setVolumes(Integer numberOfVolumes) {
        for (int i = 1; i <= numberOfVolumes; i++) {
            BookDocument volume = new BookDocument();
            volume.appendTitle("Volume " + new RomanNumerals(i).getRoman());
            addVolume(volume);
        }
    }

    public void addVolume(BookDocument volume) {
        this.volumes.add(volume);
    }

    public Integer getNumberOfVolumes() {
        return volumes.size();
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthor(List<Person> authors) {
        this.authors.clear();
        this.authors.addAll(authors);
    }

    public void addAuthor(Person author) {
        this.authors.add(author);
    }

    public void addAuthor(String givenName, String familyName) {
        Person author = new DefaultPerson();
        if (givenName != null) {
            author.setGivenName(givenName);
        }
        if (familyName != null) {
            author.setFamilyName(familyName);
        }
        addAuthor(author);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void appendSubject(String subject) {
        if (this.subject == null) {
            this.subject = subject;
        } else {
            this.subject += "\n" + subject;
        }
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void appendDescription(String description) {
        if (this.description == null) {
            this.description = description;
        } else {
            this.description += description;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void appendNotes(String notes) {
        if (this.notes == null) {
            this.notes = notes;
        } else {
            this.notes += notes;
        }
    }
}
