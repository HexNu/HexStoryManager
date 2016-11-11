package nu.hex.story.manager.rpg.documents.io.write;

import java.time.format.DateTimeFormatter;
import nu.hex.story.manager.rpg.documents.PortraitDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PortraitXmlWriter extends AbstractWriter<PortraitDocument, XmlNode> {

    public PortraitXmlWriter(PortraitDocument doc) {
        super(doc);
    }

    @Override
    public XmlNode write() {
        XmlNode portrait = NodeFactory.createNode("portrait");
        if (doc.getId()!= null) {
            portrait.addAttribute("id", doc.getId().toString());
        }
        if (doc.getLabel()!= null) {
            portrait.addAttribute("label", doc.getLabel());
        }
        if (doc.getDescription() != null) {
            portrait.addAttribute("description", doc.getDescription());
        }
        if (doc.getDate()!= null) {
            portrait.addAttribute("date", doc.getDate().format(DateTimeFormatter.ISO_DATE));
        }
        if (doc.getShortDescription()!= null) {
            portrait.addChild(NodeFactory.createNode("short-description", doc.getShortDescription()));
        }
        if (doc.getDescription()!= null) {
            portrait.addChild(NodeFactory.createNode("description", doc.getDescription()));
        }
        if (doc.getImage()!= null) {
            portrait.addChild(new ImageXmlWriter(doc.getImage()).write());
        }
        return portrait;
    }

}
