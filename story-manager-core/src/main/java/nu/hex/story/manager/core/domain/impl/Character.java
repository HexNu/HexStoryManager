package nu.hex.story.manager.core.domain.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.util.DateUtils;
import org.hibernate.annotations.Type;

/**
 *
 * @author hl
 */
@Entity
@Table(name = "Character")
public class Character implements Person {

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
    @ManyToOne(targetEntity = Character.class)
    private Person mother;
    @ManyToOne(targetEntity = Character.class)
    private Person father;
    @ManyToMany(targetEntity = Character.class, mappedBy = "mother")
    private Set<Person> children = new TreeSet<>();

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
        return getMother().getChildren();
    }

    @Override
    public Integer getAgeForDate(LocalDate date) {
        return new DateUtils(dateOfBirth).getAgeAtDate(date);
    }

}
