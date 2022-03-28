package nu.hex.story.manager.core.domain.rpg.player;

import java.util.List;
import nu.hex.story.manager.core.domain.DomainEntity;
import nu.hex.story.manager.core.domain.rpg.character.Character;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public interface Player extends DomainEntity<Long>{
    
    void setName(String name);
    
    String getEmail();
    
    void setEmail(String email);
    
    String getPhone();
    
    void setPhone(String phone);
    
    List<Character> getCharacters();
    
    void addCharacter(Character character);
}
