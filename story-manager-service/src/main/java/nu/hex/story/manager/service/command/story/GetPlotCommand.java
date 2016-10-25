package nu.hex.story.manager.service.command.story;

import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class GetPlotCommand extends AbstractServiceCommand<Plot> {

    private final Long id;

    public GetPlotCommand(Long id) {
        this.id = id;
    }

    
    @Override
    public Plot execute() {
        return getDaoFactory().getPlotDao().findByPrimaryKey(id);
    }
}
