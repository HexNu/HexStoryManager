package nu.hex.story.manager.core.dao;

import java.time.LocalDate;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.domain.impl.DefaultPerson;

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
        Optional<Person> optionalPerson = findPerson(entity.getGivenName(), entity.getFamilyName(), entity.getDateOfBirth());
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setChildren(entity.getChildren());
            existingPerson.setMother(entity.getMother());
            existingPerson.setSex(entity.getSex());
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

}
