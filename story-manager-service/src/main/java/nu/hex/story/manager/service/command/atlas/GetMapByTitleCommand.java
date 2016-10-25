package nu.hex.story.manager.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetMapByTitleCommand extends AbstractServiceCommand<AtlasMap> {

    private final String title;

    public GetMapByTitleCommand(String title) {
        this.title = title;
    }

    @Override
    public AtlasMap execute() {
        return getDaoFactory().getMapDao().findByTitle(title);
    }

}
