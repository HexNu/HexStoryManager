package nu.hex.story.manager.service.dao;

import javax.persistence.EntityManager;
import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import nu.hex.story.manager.core.domain.rpg.character.Character;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCPlayingCharacter;
import nu.hex.story.manager.core.domain.rpg.dnd.character.DnDPlayingCharacter;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class PlayingCharacterDao extends GenericDao<Character, Long> {

    public PlayingCharacterDao(EntityManager entityManager) {
        super(AbstractPlayingCharacter.class, entityManager);
    }

    public CoCPlayingCharacter getCoCCharacter(Long id) {
        Character character = findByPrimaryKey(id);
        if (character instanceof CoCPlayingCharacter) {
            return (CoCPlayingCharacter) character;
        }
        return null;
    }

    public DnDPlayingCharacter getDnDCharacter(Long id) {
        Character character = findByPrimaryKey(id);
        if (character instanceof DnDPlayingCharacter) {
            return (DnDPlayingCharacter) character;
        }
        return null;
    }

    public Character persist(Character character) {
        if (character.getId() == null) {
            return save(character);
        } else {
            return update(character);
        }
    }
}
