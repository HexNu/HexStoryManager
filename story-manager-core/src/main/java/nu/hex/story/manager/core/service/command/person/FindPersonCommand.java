package nu.hex.story.manager.core.service.command.person;

import java.time.LocalDate;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 *
 * @author hl
 */
public class FindPersonCommand extends AbstractServiceCommand<Person> {

    private final String givenName;
    private final String familyName;
    private final LocalDate dateOfBirth;

    public FindPersonCommand(String givenName, String familyName, LocalDate dateOfBirth) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Person execute() {
        return getDaoFactory().getPersonDao().findPerson(givenName, familyName, dateOfBirth).get();
    }

}
