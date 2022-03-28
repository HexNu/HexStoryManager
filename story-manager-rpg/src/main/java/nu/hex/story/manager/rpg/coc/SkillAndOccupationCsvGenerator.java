package nu.hex.story.manager.rpg.coc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.command.rpg.coc.GetAllCoCOccupationsCommand;
import nu.hex.story.manager.service.command.rpg.coc.GetAllCoCSkillsCommand;
import nu.hex.story.manager.service.support.EmHandlerProvider;

/**
 * Created 2016-okt-30
 *
 * @author hl
 */
public class SkillAndOccupationCsvGenerator {

    private static final CommandExecutor EXECUTOR = new CommandExecutor(new EmHandlerProvider());
    private String headerLine = "Skill";
    private final List<String> lines = new ArrayList<>();
    private final Path path;

    public SkillAndOccupationCsvGenerator(String path) {
        this.path = new File(path).toPath();
    }

    public void generate() throws IOException {
        EXECUTOR.execute(new GetAllCoCOccupationsCommand()).forEach((occupation) -> {
            headerLine += "\t" + occupation.getName();
        });
        lines.add(headerLine);
        EXECUTOR.execute(new GetAllCoCSkillsCommand()).forEach((skill) -> {
            lines.add(skill.getName());
        });
        lines.add("# of other skills");
        Files.write(path, lines);
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/hl/Dokument/HexNu/Call of Cthulhu/DOCS/SkillsAndOccupations.csv";
        new SkillAndOccupationCsvGenerator(path).generate();
    }
}
