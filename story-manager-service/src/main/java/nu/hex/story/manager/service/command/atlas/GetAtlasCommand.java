package nu.hex.story.manager.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetAtlasCommand extends AbstractServiceCommand<Atlas> {

    private final Long id;

    public GetAtlasCommand(Long id) {
        this.id = id;
    }

    @Override
    public Atlas execute() {
        return getDaoFactory().getAtlasDao().findByPrimaryKey(id);
    }

}
