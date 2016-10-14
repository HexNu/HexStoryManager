package nu.hex.story.manager.core.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetAtlasByTitleCommand extends AbstractServiceCommand<Atlas> {

    private final String title;

    public GetAtlasByTitleCommand(String title) {
        this.title = title;
    }

    @Override
    public Atlas execute() {
        return getDaoFactory().getAtlasDao().findByTitle(title);
    }

}
