package nu.hex.story.manager.core.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class CreateMapCommand extends AbstractServiceCommand<AtlasMap> {

    private final AtlasMap atlasMap;

    public CreateMapCommand(AtlasMap atlasMap) {
        this.atlasMap = atlasMap;
    }

    @Override
    public AtlasMap execute() {
        return getDaoFactory().getMapDao().save(atlasMap);
    }
}
