package nu.hex.story.manager.service.command.rpg;

import nu.hex.story.manager.core.domain.rpg.coc.character.CoCPlayingCharacter;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class GetCoCCharacterCommand extends AbstractServiceCommand<CoCPlayingCharacter> {

    private final Long id;

    public GetCoCCharacterCommand(Long id) {
        this.id = id;
    }

    @Override
    public CoCPlayingCharacter execute() {
        return getDaoFactory().getPlayingCharacterDao().getCoCCharacter(id);
    }

}
