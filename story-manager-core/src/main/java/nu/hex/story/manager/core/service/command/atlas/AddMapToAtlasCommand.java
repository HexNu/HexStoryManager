package nu.hex.story.manager.core.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class AddMapToAtlasCommand extends AbstractServiceCommand<Atlas> {

    private final Long atlasId;
    private final Long mapId;

    public AddMapToAtlasCommand(Long atlasId, Long mapId) {
        this.atlasId = atlasId;
        this.mapId = mapId;
    }

    @Override
    public Atlas execute() {
        AtlasMap map = getDaoFactory().getMapDao().findByPrimaryKey(mapId);
        Atlas atlas = getDaoFactory().getAtlasDao().findByPrimaryKey(atlasId);
        atlas.addMap(map);
        return atlas;
    }

}
