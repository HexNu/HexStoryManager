package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import nu.hex.story.manager.rpg.documents.PortraitDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PortraitXmlReader extends AbstractXmlReader<PortraitDocument> {

    public PortraitXmlReader(XmlNode node) {
        super(node);
    }

    public PortraitXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public PortraitDocument read() {
        PortraitDocument result = new PortraitDocument();
        if (node.hasAttribute("label")) {
            result.setLabel(node.getAttribute("label"));
        }
        if (node.hasAttribute("short-description")) {
            result.setShortDescription(node.getAttribute("short-description"));
        }
        if (node.hasAttribute("description")) {
            result.setDescription(node.getAttribute("description"));
        }
        if (node.hasAttribute("date")) {
            result.setDate(node.getAttribute("date"));
        }
        if (node.hasChildNamed("image")) {
            result.setImage(new ImageXmlReader(node.getChild("image")).read());
        }
        return result;
    }

}
