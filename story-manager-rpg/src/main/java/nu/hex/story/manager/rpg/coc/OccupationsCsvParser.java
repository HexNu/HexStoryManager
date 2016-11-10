package nu.hex.story.manager.rpg.coc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCOccupation;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.command.rpg.coc.SaveCoCOccupationsCommand;
import nu.hex.story.manager.service.support.EmHandlerProvider;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public class OccupationsCsvParser {

    private static final String DELIMITER = "\t";
    private final String path;
    private static final int NAME = 0,
            DESCRIPTION = 1,
            LOVECRAFTIAN = 2,
            START_YEAR = 3,
            END_YEAR = 4,
            SOURCE = 5;

    public OccupationsCsvParser(String path) {
        this.path = path;
    }

    public void parse() throws IOException {
        File file = new File(path);
        List<String> lines = Files.readAllLines(file.toPath());
        List<CoCOccupation> skills = new ArrayList<>();
        for (String line : lines) {
            if (!line.startsWith("Name\t")) {
                CoCOccupation occupation = new CoCOccupation();
                String[] parts = line.split(DELIMITER);
                occupation.setName(parts[NAME]);
                if (parts.length > DESCRIPTION) {
                    StringBuilder description = new StringBuilder();
                    if (parts[DESCRIPTION] != null && !parts[DESCRIPTION].isEmpty()) {
                        if (!description.toString().isEmpty()) {
                            description.append("\n");
                        }
                        for (String row : parts[DESCRIPTION].split("\\[nl\\]")) {
                            description.append(row);
                        }
                    }
                    occupation.setDescription(description.toString());
                    if (parts.length > LOVECRAFTIAN) {
                        occupation.setLovecraftian(parts[LOVECRAFTIAN].equals("*"));
                        if (parts.length > START_YEAR) {
                            System.out.println("[" + parts[START_YEAR] + "]");
                            if (parts[START_YEAR] != null && !parts[START_YEAR].isEmpty()) {
                                occupation.setStartYear(Integer.valueOf(parts[START_YEAR]));
                            }
                            if (parts.length > END_YEAR) {
                                if (parts[END_YEAR] != null && !parts[END_YEAR].isEmpty()) {
                                    occupation.setEndYear(Integer.valueOf(parts[END_YEAR]));
                                }
                                if (parts[SOURCE] != null && !parts[SOURCE].isEmpty()) {
                                    occupation.setSource(parts[SOURCE]);
                                }
                            }
                        }
                    }
                }
                skills.add(occupation);
            }
        }
        Collections.sort(skills);
        new CommandExecutor(new EmHandlerProvider()).executeInTransaction(new SaveCoCOccupationsCommand(skills));
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/hl/Dokument/HexNu/Call of Cthulhu/DOCS/Occupations.csv";
        new OccupationsCsvParser(path).parse();
    }
}
