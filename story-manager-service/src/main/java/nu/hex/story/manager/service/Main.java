package nu.hex.story.manager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import nu.hex.story.manager.core.domain.story.Chapter;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.command.story.GetStoryCommand;
import nu.hex.story.manager.service.support.EmHandlerProvider;
import nu.hex.story.manager.core.text.HTMLTextParser;
import nu.hex.story.manager.core.text.TextParser;

/**
 *
 * @author hl 2016-jun-27
 */
public class Main {

    private static final CommandExecutor EXECUTOR = new CommandExecutor(new EmHandlerProvider());

//    private static void getSiblings() {
//        Person person = EXECUTOR.execute(new GetPersonCommand(2l));
//        System.out.println("Siblings for " + person.getName() + " " + person.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
//        person.getSiblings().stream().forEach((sibling) -> {
//            System.out.println(sibling.getName() + " " + sibling.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
//        });
//    }
//

    public static void main(String[] args) throws IOException {
        Story story = EXECUTOR.execute(new GetStoryCommand(1l));
        Chapter chapter = story.getChapters().get(0);
        TextParser parser = new HTMLTextParser(chapter.getText());
        parser.setIllustrations(chapter.getIllustrations());
        parser.setPortraits(chapter.getPortraits());
        parser.setPersons(chapter.getPersons());
        String parse = parser.parse();
        String path = "/home/hl/Skrivbord/" + story.getTitle() + ".html";
        Files.write(Paths.get(path), parse.getBytes());
    }
}
