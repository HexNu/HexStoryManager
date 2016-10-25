package nu.hex.story.manager.service.command.story;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.service.command.AbstractServiceCommand;
import nu.hex.story.manager.util.EntityTextParser;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class SaveStoryCommand extends AbstractServiceCommand<Story> {

    private final Story story;

    public SaveStoryCommand(Story story) {
        this.story = story;
    }

    @Override
    public Story execute() {
        checkIllustrations();
        checkPortraits();
        return getDaoFactory().getStoryDao().persist(story);
    }

    private void checkIllustrations() {
        List<Long> existingIds = new ArrayList<>();
        story.getChapters().stream().forEach((chapter) -> {
            chapter.getIllustrations().forEach((ill) -> {
                existingIds.add(ill.getId());
            });
        });
        story.getChapters().stream().forEach((chapter) -> {
            List<Long> includedIds = new EntityTextParser(chapter.getText(), "\\[I:(.*?)\\]").getIdList();
            includedIds.stream().filter((l)
                    -> (!existingIds.contains(l))).map((l) -> getDaoFactory().getIllustrationDao().findByPrimaryKey(l)).forEach((ill)
                    -> {
                chapter.addIllustration(ill);
            });
        });
    }

    private void checkPortraits() {
        List<Long> existingIds = new ArrayList<>();
        story.getChapters().stream().forEach((chapter) -> {
            chapter.getPortraits().forEach((ill) -> {
                existingIds.add(ill.getId());
            });
        });
        story.getChapters().stream().forEach((chapter) -> {
            List<Long> includedIds = new EntityTextParser(chapter.getText(), "\\[P:(.*?)\\]").getIdList();
            includedIds.stream().filter((l)
                    -> (!existingIds.contains(l))).map((l) -> getDaoFactory().getPortraitDao().findByPrimaryKey(l)).forEach((ill)
                    -> {
                chapter.addPortrait(ill);
            });
        });
    }

}
