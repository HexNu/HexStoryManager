package nu.hex.story.manager.core.document;

import se.digitman.lightxml.XmlDocument;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public interface EntityDocument {

    String write();
    
    String writeHTML();
    
    XmlDocument writeHSMF();
}
