package nu.hex.story.manager.service.command.person;

import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public class GetPersonCommand extends AbstractServiceCommand<Person> {

    private final Long id;

    public GetPersonCommand(Long id) {
        this.id = id;
    }

    @Override
    public Person execute() {
        return getDaoFactory().getPersonDao().findByPrimaryKey(id);
    }
}
