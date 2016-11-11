package nu.hex.story.manager.rpg.documents.io.write;

import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class MapXmlWriter extends AbstractWriter<AtlasMap, XmlNode>{

    public MapXmlWriter(AtlasMap doc) {
        super(doc);
    }

    @Override
    public XmlNode write() {
        XmlNode map = NodeFactory.createNode("map");
        if (doc.getId()!= null) {
            map.addAttribute("id", doc.getId().toString());
        }
        if (doc.getTitle() != null) {
            map.addAttribute("title", doc.getTitle());
        }
        if (doc.getDescription() != null) {
            map.addAttribute("description", doc.getDescription());
        }
        if (doc.getAuthor()!= null) {
            map.addAttribute("author", doc.getAuthor());
        }
        if (doc.getImage()!= null) {
            map.addChild(new ImageXmlWriter(doc.getImage()).write());
        }
        return map;
    }

}
