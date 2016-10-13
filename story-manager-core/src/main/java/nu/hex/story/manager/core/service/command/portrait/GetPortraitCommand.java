package nu.hex.story.manager.core.service.command.portrait;

import nu.hex.story.manager.core.domain.person.Portrait;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
public class GetPortraitCommand extends AbstractServiceCommand<Portrait> {

    private final Long id;

    public GetPortraitCommand(Long id) {
        this.id = id;
    }

    @Override
    public Portrait execute() {
        return getDaoFactory().getPortraitDao().findByPrimaryKey(id);
    }
}
