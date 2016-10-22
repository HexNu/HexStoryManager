package nu.hex.story.manager.core.service.command.story;

import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class SavePlotCommand extends AbstractServiceCommand<Plot> {

    private final Plot plot;

    public SavePlotCommand(Plot plot) {
        this.plot = plot;
    }

    @Override
    public Plot execute() {
        return getDaoFactory().getPlotDao().persist(plot);
    }
}
