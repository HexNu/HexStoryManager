package nu.hex.story.manager.core.service.command.person;

import java.util.List;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;


/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public class GetChildrenCommand extends AbstractServiceCommand<List<Person>> {

    private final Person parent;

    public GetChildrenCommand(Person parent) {
        this.parent = parent;
    }

    @Override
    public List<Person> execute() {
        return getDaoFactory().getPersonDao().getChildren(parent);
    }

}
