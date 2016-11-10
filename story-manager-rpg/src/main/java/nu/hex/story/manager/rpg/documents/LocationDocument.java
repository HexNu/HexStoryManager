package nu.hex.story.manager.rpg.documents;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.atlas.Location;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.person.Person;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class LocationDocument implements Document, Location {

    private Long id;
    private String name;
    private String description;
    private String history;
    private String notes;
    private Double longitude;
    private Double latitude;
    private AtlasMap map = new MapDocument();
    private final List<Illustration> illustrations = new ArrayList<>();
    private final List<Person> persons = new ArrayList<>();
    private String language;
    private String country;
    private String currency;

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
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public AtlasMap getMap() {
        return map;
    }

    public void setMap(AtlasMap map) {
        this.map = map;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public List<Illustration> getIllustrations() {
        return illustrations;
    }

    @Override
    public void setIllustrations(List<Illustration> illustrations) {
        this.illustrations.clear();
        this.illustrations.addAll(illustrations);
    }

    @Override
    public void addIllustration(Illustration illustration) {
        this.illustrations.add(illustration);
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
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
