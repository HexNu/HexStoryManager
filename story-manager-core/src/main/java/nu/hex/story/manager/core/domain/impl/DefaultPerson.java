package nu.hex.story.manager.core.domain.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.util.DateUtils;
import org.hibernate.annotations.Type;

/**
 *
 * @author hl
 */
@Entity
@Table(name = "Person", uniqueConstraints = @UniqueConstraint(columnNames = {"givenName", "familyName", "dateOfBirth"}))
@NamedQueries({
    @NamedQuery(name = "Person.findPerson",
            query = "SELECT p FROM DefaultPerson p WHERE p.givenName = :givenName AND p.familyName = :familyName AND p.dateOfBirth = :dateOfBirth")
})
public class DefaultPerson implements Person, Comparable<Person> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String familyName;
    @Column
    private String givenName;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Temporal(TemporalType.DATE)
    @Type(type = "nu.hex.story.manager.core.jpa.LocalDateUserType")
    private LocalDate dateOfBirth;
    @ManyToOne(targetEntity = DefaultPerson.class)
    private Person mother;
    @ManyToOne(targetEntity = DefaultPerson.class)
    private Person father;
    @OneToMany(targetEntity = DefaultPerson.class, mappedBy = "mother", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Person> children = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
    public String getName() {
        return givenName + " " + familyName;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateUtils.STANDARD_FORMATTER);
    }

    @Override
    public Person getMother() {
        return mother;
    }

    @Override
    public void setMother(Person mother) {
        this.mother = mother;
    }

    @Override
    public Person getFather() {
        return father;
    }

    @Override
    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public List<Person> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public void setChildren(List<Person> children) {
        this.children.clear();
        this.children.addAll(children);
    }

    @Override
    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public List<Person> getSiblings() {
        List<Person> siblings = new ArrayList<>();
        for (Person p : getMother().getChildren()) {
            if (!p.equals(this)) {
                siblings.add(p);
            }
        }
        return siblings;
    }

    @Override
    public Integer getAgeForDate(LocalDate date) {
        return new DateUtils(dateOfBirth).getAgeAtDate(date);
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

}
