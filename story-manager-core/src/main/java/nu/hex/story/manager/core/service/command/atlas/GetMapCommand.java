package nu.hex.story.manager.core.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetMapCommand extends AbstractServiceCommand<AtlasMap> {

    private final Long id;

    public GetMapCommand(Long id) {
        this.id = id;
    }

    @Override
    public AtlasMap execute() {
        return getDaoFactory().getMapDao().findByPrimaryKey(id);
    }
}
