package nu.hex.story.manager.rpg.coc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCAbilityScore;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkill;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.command.rpg.coc.SaveCoCSkillsCommand;
import nu.hex.story.manager.service.support.EmHandlerProvider;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public class SkillsCsvParser {

    private static final String DELIMITER = "\t";
    private final String path;
    private static final int LABEL = 0,
            MULTIPLE = 1,
            BASE_VALUE = 2,
            ABILITY_BASE = 3,
            ABILITY_MULTIPLIER = 4,
            SOURCE = 5,
            DESCRIPTION = 6;

    public SkillsCsvParser(String path) {
        this.path = path;
    }

    public void parse() throws IOException {
        File file = new File(path);
        List<String> lines = Files.readAllLines(file.toPath());
        List<CoCSkill> skills = new ArrayList<>();
        for (String line : lines) {
            if (!line.startsWith("Name\t")) {
                CoCSkill skill = new CoCSkill();
                String[] parts = line.split(DELIMITER);
                skill.setName(parts[LABEL]);
                if (parts.length > MULTIPLE) {
                    skill.setMultipliable(parts[MULTIPLE].equals("*"));
                    if (parts[BASE_VALUE] != null && !parts[BASE_VALUE].isEmpty()) {
                        skill.setBaseChance(Integer.valueOf(parts[BASE_VALUE]));
                    }
                    if (parts.length > ABILITY_MULTIPLIER) {
                        if (parts[ABILITY_BASE] != null && !parts[ABILITY_BASE].isEmpty()) {
                            skill.setAbilityBase(CoCAbilityScore.Ability.valueOf(parts[ABILITY_BASE]));
                        }
                        if (parts[ABILITY_MULTIPLIER] != null && !parts[ABILITY_MULTIPLIER].isEmpty()) {
                            skill.setAbilityMultiplier(Integer.valueOf(parts[ABILITY_MULTIPLIER]));
                        }
                        if (parts.length > SOURCE) {
                            skill.setSource(parts[SOURCE]);
                        }
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
                            skill.setDescription(description.toString());
                        }
                    }
                }
                skills.add(skill);
//                new CommandExecutor(new EmHandlerProvider()).executeInTransaction(new SaveCoCSkillsCommand(skill));
            }
        }
        Collections.sort(skills);
        new CommandExecutor(new EmHandlerProvider()).executeInTransaction(new SaveCoCSkillsCommand(skills));
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/hl/Dokument/HexNu/Call of Cthulhu/DOCS/Skills.csv";
        new SkillsCsvParser(path).parse();
    }
}
