package nu.hex.story.manager.service.dao;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;

/**
 *
 * @author hl
 */
public class PersonDao extends GenericDao<Person, Long> {

    public PersonDao(EntityManager entityManager) {
        super(DefaultPerson.class, entityManager);
    }

    @Override
    public Person save(Person entity) {
        if (entity.getId() != null) {
            super.update(entity);
            return entity;
        }
        Optional<Person> optionalPerson = findPerson(entity.getGivenName(), entity.getFamilyName(), entity.getDateOfBirth());
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setChildren(entity.getChildren());
            existingPerson.setMother(entity.getMother());
            existingPerson.setFather(entity.getFather());
            existingPerson.setSex(entity.getSex());
            existingPerson.setDateOfBirth(entity.getDateOfBirth());
            existingPerson.setPlaceOfBirth(entity.getPlaceOfBirth());
            existingPerson.setDateOfDeath(entity.getDateOfDeath());
            existingPerson.setPlaceOfDeath(entity.getPlaceOfDeath());
            existingPerson.setCauseOfDeath(entity.getCauseOfDeath());
            existingPerson.setResidence(entity.getResidence());
            for (PersonalEvent e : entity.getEvents()) {
                existingPerson.addEvent(e);
            }
            return existingPerson;
        }
        return super.save(entity);
    }

    public Optional<Person> findPerson(String givenName, String familyName, LocalDate dateOfBirth) {
        try {
            Person person = (Person) getManager().createNamedQuery("Person.findPerson")
                    .setParameter("givenName", givenName)
                    .setParameter("familyName", familyName)
                    .setParameter("dateOfBirth", dateOfBirth).getSingleResult();
            return Optional.of(person);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public List<Person> getChildren(Person person) {
        if (person.getSex().equals(Person.Sex.FEMALE)) {
            return getManager().createNamedQuery("Person.getChildrenOfMother")
                    .setParameter("mother", person).getResultList();
        } else if (person.getSex().equals(Person.Sex.MALE)) {
            return getManager().createNamedQuery("Person.getChildrenOfFather")
                    .setParameter("father", person).getResultList();
        }
        return Collections.EMPTY_LIST;
    }

}
