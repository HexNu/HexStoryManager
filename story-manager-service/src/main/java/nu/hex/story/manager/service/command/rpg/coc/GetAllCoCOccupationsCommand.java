package nu.hex.story.manager.service.command.rpg.coc;

import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCOccupation;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class GetAllCoCOccupationsCommand extends AbstractServiceCommand<List<CoCOccupation>>{

    @Override
    public List<CoCOccupation> execute() {
        return getDaoFactory().getCoCOccupationDao().findAll();
    }
}
