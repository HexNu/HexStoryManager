package nu.hex.story.manager.core.service.command.atlas;

import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class CreateAtlasCommand extends AbstractServiceCommand<Atlas> {

    private final Atlas atlas;

    public CreateAtlasCommand(Atlas atlas) {
        this.atlas = atlas;
    }

    @Override
    public Atlas execute() {
        return getDaoFactory().getAtlasDao().save(atlas);
    }
}
