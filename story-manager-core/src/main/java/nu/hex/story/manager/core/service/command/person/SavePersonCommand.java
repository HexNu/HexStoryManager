package nu.hex.story.manager.core.service.command.person;

import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 *
 * @author hl
 */
public class SavePersonCommand extends AbstractServiceCommand<Person> {

    private final Person entity;

    public SavePersonCommand(Person entity) {
        this.entity = entity;
    }

    @Override
    public Person execute() {
        return getDaoFactory().getPersonDao().save(entity);
    }

}
