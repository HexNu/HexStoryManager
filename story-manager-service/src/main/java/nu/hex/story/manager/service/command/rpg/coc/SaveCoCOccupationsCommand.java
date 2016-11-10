package nu.hex.story.manager.service.command.rpg.coc;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCOccupation;
import nu.hex.story.manager.service.command.AbstractServiceCommand;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class SaveCoCOccupationsCommand extends AbstractServiceCommand<Void> {

    private final List<CoCOccupation> occupations;

    public SaveCoCOccupationsCommand(List<CoCOccupation> occupations) {
        this.occupations = occupations;
    }

    public SaveCoCOccupationsCommand(CoCOccupation occupation) {
        this.occupations = new ArrayList<>();
        this.occupations.add(occupation);
    }

    @Override
    public Void execute() {
        getDaoFactory().getCoCOccupationDao().saveOccupations(occupations);
        return null;
    }

}
