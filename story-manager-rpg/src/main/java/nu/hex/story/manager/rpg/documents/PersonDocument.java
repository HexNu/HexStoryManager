package nu.hex.story.manager.rpg.documents;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PersonDocument implements Person {

    private String familyName;
    private String givenName;
    private Sex sex;
    private String characterRace;
    private String characterClass;
    private String dateOfBirth; // TODO: Change to a date
    private String placeOfBirth;
    private String dateOfDeath; // TODO: Change to a date
    private String placeOfDeath;
    private String causeOfDeath;
    private Person mother;
    private Person father;
    private final Set<Person> children = new HashSet<>();
    private String residence;
    private PortraitDocument portrait;
    private Integer height;
    private Integer weight;
    private String eyes;
    private String skin;
    private String hair;
    private String description;
    private String history;
    private String notes;

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getBirthDate() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @Override
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDeathDate() {
        return dateOfDeath;
    }

    @Override
    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    @Override
    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    @Override
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    @Override
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    @Override
    public Person getMother() {
        return mother;
    }

    @Override
    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setMother(String givenName, String familyName) {
        mother = new PersonDocument();
        mother.setGivenName(givenName);
        mother.setFamilyName(familyName);
    }

    @Override
    public Person getFather() {
        return father;
    }

    @Override
    public void setFather(Person father) {
        this.father = father;
    }

    public void setFather(String givenName, String familyName) {
        father = new PersonDocument();
        father.setGivenName(givenName);
        father.setFamilyName(familyName);
    }

    @Override
    public String getResidence() {
        return residence;
    }

    @Override
    public void setResidence(String residence) {
        this.residence = residence;
    }

    public PortraitDocument getPortrait() {
        return portrait;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @Override
    public List<Person> getChildren() {
        return new ArrayList(children);
    }

    @Override
    public void setChildren(List<Person> children) {
        this.children.clear();
        children.stream().forEach((child) -> {
            addChild(child);
        });
    }

    public void setChildren(Integer numberOfChildren) {
        for (int i = 1; i <= numberOfChildren; i++) {
            PersonDocument child = new PersonDocument();
            child.setFamilyName(this.getFamilyName());
            child.setGivenName("child " + i);
            addChild(child);
        }
    }

    @Override
    public void addChild(Person child) {
        if (getSex().equals(Sex.FEMALE)) {
            child.setMother(this);
        } else {
            child.setFather(this);
        }
        this.children.add(child);
    }
    
    public void addChild(String givenName, String familyName) {
        PersonDocument child = new PersonDocument();
        child.setGivenName(givenName);
        child.setFamilyName(familyName);
        addChild(child);
    }

    @Override
    public List<Person> getSiblings() {
        List<Person> siblings = new ArrayList<>();
        getMother().getChildren().stream().filter((sibling) -> (!sibling.equals(this) && !siblings.contains(sibling))).forEach((sibling) -> {
            siblings.add(sibling);
        });
        getFather().getChildren().stream().filter((sibling) -> (!sibling.equals(this) && !siblings.contains(sibling))).forEach((sibling) -> {
            siblings.add(sibling);
        });
        return siblings;
    }

    @Override
    public Integer getAgeForDate(LocalDate date) {
        return null; // TODO
    }

    @Override
    public List<PersonalEvent> getEvents() {
        return null;
    }

    @Override
    public void addEvent(PersonalEvent event) {
    }

    @Override
    public List<Portrait> getPortraits() {
        return Arrays.asList(portrait);
    }

    @Override
    public void addPortrait(Portrait portrait) {
        this.portrait = (PortraitDocument) portrait;
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
        return givenName + " " + familyName;
    }

    @Override
    public int compareTo(Person o) {
        int result = 0;
        if (o instanceof PersonDocument) {
            PersonDocument other = (PersonDocument) o;
            result = this.getFamilyName().compareTo(other.getFamilyName());
            if (result == 0) {
                result = this.getGivenName().compareTo(other.getGivenName());
            }
            if (result == 0) {
                result = this.getBirthDate().compareTo(other.getBirthDate());
            }
            if (result == 0) {
                result = this.getMother().compareTo(other.getMother());
            }
            if (result == 0) {
                result = this.getFather().compareTo(other.getFather());
            }
        }
        return result;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        // TODO
    }

    @Override
    public void setDateOfDeath(LocalDate dateOfDeath) {
        // TODO
    }

    @Override
    public LocalDate getDateOfBirth() {
        return null; // TODO
    }

    @Override
    public LocalDate getDateOfDeath() {
        return null; // TODO
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

    public String getHistory() {
        return history;
    }

    public void appendHistory(String history) {
        if (this.history == null) {
            this.history = history;
        } else {
            this.history += history;
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
