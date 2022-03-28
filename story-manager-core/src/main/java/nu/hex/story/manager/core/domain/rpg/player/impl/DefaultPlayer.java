package nu.hex.story.manager.core.domain.rpg.player.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import nu.hex.story.manager.core.domain.rpg.player.Player;
import nu.hex.story.manager.core.domain.rpg.character.Character;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "Player")
public class DefaultPlayer implements Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = AbstractPlayingCharacter.class)
    private Set<Character> characters;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public List<Character> getCharacters() {
        return new ArrayList<>(characters);
    }

    @Override
    public void addCharacter(Character character) {
        characters.add(character);
    }
}
