package nu.hex.story.manager.service;

import java.io.IOException;
import nu.hex.story.manager.service.command.CommandExecutor;
import nu.hex.story.manager.service.command.story.GetStoryCommand;
import nu.hex.story.manager.service.support.EmHandlerProvider;

/**
 *
 * @author hl 2016-jun-27
 */
public class Main {

    private static final CommandExecutor EXECUTOR = new CommandExecutor(new EmHandlerProvider());

    public static void main(String[] args) throws IOException {
        EXECUTOR.execute(new GetStoryCommand(1l));
    }
}
