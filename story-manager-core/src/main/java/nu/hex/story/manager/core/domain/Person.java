package nu.hex.story.manager.core.domain;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hl
 */
public interface Person extends DomainObject<Long> {

    String getFamilyName();

    void setFamilyName(String familyName);

    String getGivenName();

    void setGivenName(String givenName);

    Sex getSex();

    void setSex(Sex sex);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    void setDateOfBirth(String dateOfBirth);

    String getPlaceOfBirth();

    void setPlaceOfBirth(String placeOfBirth);

    LocalDate getDateOfDeath();

    void setDateOfDeath(LocalDate dateOfDeath);

    void setDateOfDeath(String dateOfDeath);

    String getPlaceOfDeath();

    void setPlaceOfDeath(String placeOfDeath);
    
    String getCauseOfDeath();
    
    void setCauseOfDeath(String causeOfDeath);

    Person getMother();

    void setMother(Person mother);

    Person getFather();

    void setFather(Person father);

    List<Person> getChildren();

    void setChildren(List<Person> children);

    void addChild(Person child);

    List<Person> getSiblings();

    Integer getAgeForDate(LocalDate date);
    
    String getResidence();
    
    void setResidence(String residence);
    
    List<PersonalEvent> getEvents();
    
    void addEvent(PersonalEvent event);
    
    List<Portrait> getPortraits();
    
    void addPortrait(Portrait portrait);

    public enum Sex {
        FEMALE, MALE, OTHER;

        public String getLabel() {
            return name().substring(0, 1) + name().toLowerCase().substring(1);
        }
        
        public static Sex getByString(String string) {
            try {
                return Sex.valueOf(string.toUpperCase());
            } catch (IllegalArgumentException e) {
                return Sex.FEMALE;
            }
        }
    }
}
