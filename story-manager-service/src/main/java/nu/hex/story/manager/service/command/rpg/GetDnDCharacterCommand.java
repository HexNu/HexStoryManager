package nu.hex.story.manager.service.command.rpg;

import nu.hex.story.manager.core.domain.rpg.dnd.character.DnDPlayingCharacter;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class GetDnDCharacterCommand extends AbstractServiceCommand<DnDPlayingCharacter> {

    private final Long id;

    public GetDnDCharacterCommand(Long id) {
        this.id = id;
    }

    @Override
    public DnDPlayingCharacter execute() {
        return getDaoFactory().getPlayingCharacterDao().getDnDCharacter(id);
    }

}
