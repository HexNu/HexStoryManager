package nu.hex.story.manager.core.service.command.story;

import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class GetStoryCommand extends AbstractServiceCommand<Story> {

    private final Long id;

    public GetStoryCommand(Long id) {
        this.id = id;
    }

    
    @Override
    public Story execute() {
        return getDaoFactory().getStoryDao().findByPrimaryKey(id);
    }
}
