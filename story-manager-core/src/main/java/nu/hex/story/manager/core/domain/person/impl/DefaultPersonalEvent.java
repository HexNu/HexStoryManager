package nu.hex.story.manager.core.domain.person.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nu.hex.story.manager.core.domain.event.Event;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;
import org.hibernate.annotations.Type;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
@Entity
@Table(name = "PersonalEvent")
public class DefaultPersonalEvent implements PersonalEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String label;
    @ManyToOne(targetEntity = DefaultPerson.class)
    private Person owner;
    @Temporal(TemporalType.DATE)
    @Type(type = "nu.hex.story.manager.core.jpa.LocalDateUserType")
    private LocalDate eventDate;
    @Column(length = 1024 * 128)
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getName() {
        return eventDate.format(DateTimeFormatter.ISO_DATE);
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public LocalDate getDate() {
        return eventDate;
    }

    @Override
    public void setDate(LocalDate date) {
        this.eventDate = date;
    }

    @Override
    public void setDate(String date) {
        this.eventDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Event o) {
        return this.getDate().compareTo(o.getDate());
    }
}
