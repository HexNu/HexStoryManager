package nu.hex.story.manager.rpg.documents.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class FileWriter {

    private final List<String> content;
    private final File file;

    public FileWriter(String content, String path) {
        this(Arrays.asList(content), path);
    }

    public FileWriter(List<String> content, String path) {
        this.content = content;
        this.file = new File(path);
    }

    public void write() throws IOException {
        file.getParentFile().mkdirs();
        Files.write(file.toPath(), content);
    }
}
