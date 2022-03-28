package nu.hex.story.manager.api.conf;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author jep
 */
public class StoryManagerApp extends ResourceConfig {

    public StoryManagerApp() {
        packages("nu.hex.story.manager.api");
        register(JacksonFeature.class);
    }

}
