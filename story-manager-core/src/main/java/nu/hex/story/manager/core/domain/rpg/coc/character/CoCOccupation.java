package nu.hex.story.manager.core.domain.rpg.coc.character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.CharacterClass;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
@Entity
@Table(name = "CoCOccupation")
public class CoCOccupation implements CharacterClass, Comparable<CoCOccupation> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer startYear;
    @Column
    private Integer endYear;
    @Column(length = 16 * 1024)
    private String description;
    @Column
    private Boolean lovecraftian;
    @Column
    private String source;
    @ManyToMany(targetEntity = CoCSkill.class)
    private final Set<CoCSkill> skills = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isLovecraftian() {
        return lovecraftian;
    }

    public void setLovecraftian(Boolean lovecraftian) {
        this.lovecraftian = lovecraftian;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<CoCSkill> getSkills() {
        return new ArrayList<>(skills);
    }

    public void setSkills(List<CoCSkill> skills) {
        this.skills.addAll(skills);
    }

    public void addSkill(CoCSkill skill) {
        this.skills.add(skill);
    }

    @Override
    public int compareTo(CoCOccupation o) {
        return this.getName().compareTo(o.getName());
    }
}
