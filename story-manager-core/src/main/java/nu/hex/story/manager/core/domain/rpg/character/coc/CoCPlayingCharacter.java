package nu.hex.story.manager.core.domain.rpg.character.coc;

import java.util.List;
import nu.hex.story.manager.core.domain.rpg.character.dnd.impl.*;
import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import nu.hex.story.manager.core.domain.rpg.character.Stats;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@DiscriminatorValue(value = "COC")
public class CoCPlayingCharacter extends AbstractPlayingCharacter {

    @OneToOne(cascade = CascadeType.ALL, targetEntity = DnDStats.class)
    private Stats stats;
    @Column
    private String occcupation;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CoCEducation.class)
    private List<CoCEducation> collegesAndDegrees;
    @Column
    private Integer experiencePoints;
    @OneToMany
    @Column
    private Integer height;
    @Column
    private Integer weight;
    @Column
    private String eyes;
    @Column
    private String skin;
    @Column
    private String hair;

    @Override
    public Stats getStats() {
        return stats;
    }

    @Override
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }
}
