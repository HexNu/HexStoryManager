package nu.hex.story.manager.rpg.documents.gui.properties;

import java.util.Properties;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class TextEditorProperties extends Properties {

    private static final String LAST_OPENED_FILE = "text-editor.last-opened-file";
    private static final String DEFAULT_PATH = "/";

    public TextEditorProperties() {
        super();
        if (getProperty(LAST_OPENED_FILE) == null) {
            put(LAST_OPENED_FILE, System.getProperty("user.home", DEFAULT_PATH));
        }
    }

    public String getLastOpenedFile() {
        return getProperty(LAST_OPENED_FILE, System.getProperty("user.home"));
    }

    public void setLastOpenedFile(String path) {
        put(LAST_OPENED_FILE, path);
    }
}
