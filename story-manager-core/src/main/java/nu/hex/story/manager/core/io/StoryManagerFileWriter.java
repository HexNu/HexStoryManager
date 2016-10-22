package nu.hex.story.manager.core.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nu.hex.story.manager.core.document.docs.StoryManagerDocument;
import nu.hex.story.manager.core.domain.story.Story;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.format.XmlPrettyPrinter;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class StoryManagerFileWriter implements FileWriter {

    private final Story story;
    private final String folderPath;

    public StoryManagerFileWriter(Story story, String folderPath) {
        this.story = story;
        this.folderPath = folderPath.endsWith("/")? folderPath : folderPath + "/";
    }

    @Override
    public void write() throws IOException {
        XmlDocument doc = new StoryManagerDocument(story).writeHSMF();
        XmlPrettyPrinter prettyPrinter = new XmlPrettyPrinter(doc);
        byte[] docAsBytes = prettyPrinter.toString().replaceAll("  ", "    ").getBytes(Charset.forName("UTF-8"));
        new File(folderPath).mkdirs();
        Path path = Paths.get(folderPath + story.getTitle() + ".xsmf");
        Files.write(path, docAsBytes);
    }
}
