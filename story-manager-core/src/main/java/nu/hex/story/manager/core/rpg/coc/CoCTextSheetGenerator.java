package nu.hex.story.manager.core.rpg.coc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.rpg.Die;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkillScore;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public class CoCTextSheetGenerator {

    private static final String PATH = "sources/rpg/coc/CoCTextSheet";
    private final String resultPath;

    public CoCTextSheetGenerator(String resultPath) {
        this.resultPath = resultPath;
    }

    public void generate() throws IOException {
        File file = new File(resultPath);
        file.getParentFile().mkdirs();
        String[] lines = getResourceAsString().split("\n");
        List<String> rows = new ArrayList<>();
        int rowIndex = 0;
        for (String line : lines) {
            String row = line + ": ";
            if (line.equalsIgnoreCase("edu")) {
                row += (Die.D6.get(3) + 3);
            } else if (line.equalsIgnoreCase("int") || line.equalsIgnoreCase("siz")) {
                row += (Die.D6.get(2) + 6);
            } else if (rowIndex > 7) {
                row += Die.D6.get(3);
            }
            rows.add(row);
            rowIndex++;
        }
        rows.add("Skills:");
        for (CoCSkillScore.Skill skill : CoCSkillScore.Skill.values()) {
            rows.add(skill.toString() + ": ");
        }
        Files.write(file.toPath(), rows);
    }

    public static void main(String[] args) throws IOException {
        new CoCTextSheetGenerator("/home/hl/Dokument/HexNu/StoryManager/sample-files/coc.txt").generate();
    }

    private InputStream getResourceAsStream() {
        return getClass().getClassLoader().getResourceAsStream(PATH);
    }

    public String getResourceAsString() {
        return convertStreamToString(getResourceAsStream());
    }

    private String convertStreamToString(InputStream inputStream) {
        try {
            if (inputStream != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                } finally {
                    inputStream.close();
                }
                return stringBuilder.toString();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return "";
    }

}
