package nu.hex.story.manager.service.command.rpg.coc;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkill;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class SaveCoCSkillsCommand extends AbstractServiceCommand<Void> {

    private final List<CoCSkill> skills;

    public SaveCoCSkillsCommand(List<CoCSkill> skills) {
        this.skills = skills;
    }

    public SaveCoCSkillsCommand(CoCSkill skill) {
        this.skills = new ArrayList<CoCSkill>();
        this.skills.add(skill);
    }

    @Override
    public Void execute() {
        getDaoFactory().getCoCSkillDao().saveSkills(skills);
        return null;
    }

}
