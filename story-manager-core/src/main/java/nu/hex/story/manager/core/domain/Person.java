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
    
    String getName();

    Sex getSex();

    void setSex(Sex sex);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    void setDateOfBirth(String dateOfBirth);

    Person getMother();

    void setMother(Person mother);

    Person getFather();

    void setFather(Person father);

    List<Person> getChildren();

    void setChildren(List<Person> children);

    void addChild(Person child);

    List<Person> getSiblings();

    Integer getAgeForDate(LocalDate date);

    public enum Sex {
        FEMALE, MALE, OTHER;

        public String getLabel() {
            return name().substring(0, 1) + name().toLowerCase().substring(1);
        }
    }
}
