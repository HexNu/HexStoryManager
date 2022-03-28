package nu.hex.story.manager.service.command.rpg;

import nu.hex.story.manager.service.command.AbstractServiceCommand;
import nu.hex.story.manager.core.domain.rpg.character.Character;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class SaveCharacterCommand extends AbstractServiceCommand<Long> {

    private final Character character;

    public SaveCharacterCommand(Character character) {
        this.character = character;
    }

    @Override
    public Long execute() {
        return getDaoFactory().getPlayingCharacterDao().persist(character).getId();
    }
}
