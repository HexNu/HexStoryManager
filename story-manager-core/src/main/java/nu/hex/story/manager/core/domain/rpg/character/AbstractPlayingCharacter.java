package nu.hex.story.manager.core.domain.rpg.character;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "PlayingCharacter")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractPlayingCharacter implements Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = DefaultPerson.class)
    private Person person;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Person getPerson() {
        if (person == null) {
            person = new DefaultPerson();
        }
        return person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getFamilyName() {
        return getPerson().getFamilyName();
    }

    @Override
    public void setFamilyName(String familyName) {
        getPerson().setFamilyName(familyName);
    }

    @Override
    public String getGivenName() {
        return getPerson().getGivenName();
    }

    @Override
    public void setGivenName(String givenName) {
        getPerson().setGivenName(givenName);
    }

    @Override
    public String getName() {
        return getPerson().getName();
    }

    @Override
    public Person.Sex getSex() {
        return getPerson().getSex();
    }

    @Override
    public void setSex(Person.Sex sex) {
        getPerson().setSex(sex);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return getPerson().getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        getPerson().setDateOfBirth(dateOfBirth);
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        getPerson().setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getPlaceOfBirth() {
        return getPerson().getPlaceOfBirth();
    }

    @Override
    public void setPlaceOfBirth(String placeOfBirth) {
        getPerson().setPlaceOfBirth(placeOfBirth);
    }

    @Override
    public LocalDate getDateOfDeath() {
        return getPerson().getDateOfDeath();
    }

    @Override
    public void setDateOfDeath(LocalDate dateOfDeath) {
        getPerson().setDateOfDeath(dateOfDeath);
    }

    @Override
    public void setDateOfDeath(String dateOfDeath) {
        getPerson().setDateOfDeath(dateOfDeath);
    }

    @Override
    public String getPlaceOfDeath() {
        return getPerson().getPlaceOfDeath();
    }

    @Override
    public void setPlaceOfDeath(String placeOfDeath) {
        getPerson().setPlaceOfDeath(placeOfDeath);
    }

    @Override
    public String getCauseOfDeath() {
        return getPerson().getCauseOfDeath();
    }

    @Override
    public void setCauseOfDeath(String causeOfDeath) {
        getPerson().setCauseOfDeath(causeOfDeath);
    }

    @Override
    public Person getMother() {
        return getPerson().getMother();
    }

    @Override
    public void setMother(Person mother) {
        getPerson().setMother(mother);
    }

    @Override
    public Person getFather() {
        return getPerson().getFather();
    }

    @Override
    public void setFather(Person father) {
        getPerson().setFather(father);
    }

    @Override
    public List<Person> getChildren() {
        return getPerson().getChildren();
    }

    @Override
    public void setChildren(List<Person> children) {
        getPerson().setChildren(children);
    }

    @Override
    public void addChild(Person child) {
        getPerson().addChild(child);
    }

    @Override
    public List<Person> getSiblings() {
        return getPerson().getSiblings();
    }

    @Override
    public Integer getAgeForDate(LocalDate date) {
        return getPerson().getAgeForDate(date);
    }

    @Override
    public String getResidence() {
        return getPerson().getResidence();
    }

    @Override
    public void setResidence(String residence) {
        getPerson().setResidence(residence);
    }

    @Override
    public List<PersonalEvent> getEvents() {
        return getPerson().getEvents();
    }

    @Override
    public void addEvent(PersonalEvent event) {
        getPerson().addEvent(event);
    }

    @Override
    public List<Portrait> getPortraits() {
        return getPerson().getPortraits();
    }

    @Override
    public void addPortrait(Portrait portrait) {
        getPerson().addPortrait(portrait);
    }

    @Override
    public int compareTo(Person o) {
        return getPerson().compareTo(o);
    }

    @Override
    public String toString() {
        return getPerson().toString();
    }

}
