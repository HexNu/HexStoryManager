package nu.hex.story.manager.service.command.rpg.coc;

import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkill;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class GetAllCoCSkillsCommand extends AbstractServiceCommand<List<CoCSkill>>{

    @Override
    public List<CoCSkill> execute() {
        return getDaoFactory().getCoCSkillDao().findAll();
    }
}
