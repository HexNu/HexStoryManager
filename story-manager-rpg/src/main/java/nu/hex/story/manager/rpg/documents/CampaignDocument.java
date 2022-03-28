package nu.hex.story.manager.rpg.documents;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class CampaignDocument implements Document {

    private String title;
    private String description;
    private final List<BookDocument> books = new ArrayList<>();
    private final List<LocationDocument> locations = new ArrayList<>();
    private final List<PersonDocument> persons = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookDocument> getBooks() {
        return books;
    }

    public void setBooks(List<BookDocument> books) {
        this.books.clear();
        if (books != null) {
            this.books.addAll(books);
        }
    }

    public void addBook(BookDocument book) {
        books.add(book);
    }

    public List<LocationDocument> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDocument> locations) {
        this.locations.clear();
        if (locations != null) {
            this.locations.addAll(locations);
        }
    }

    public void addLocation(LocationDocument location) {
        locations.add(location);
    }

    public List<PersonDocument> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDocument> persons) {
        this.persons.clear();
        this.persons.addAll(persons);
    }

    public void addPerson(PersonDocument person) {
        this.persons.add(person);
    }

}
