package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import nu.hex.story.manager.rpg.documents.MapDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class MapXmlReader extends AbstractXmlReader<MapDocument> {

    public MapXmlReader(XmlNode node) {
        super(node);
    }

    public MapXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public MapDocument read() {
        MapDocument result = new MapDocument();
        if (node.getAttribute("author") != null) {
            result.setAuthor(node.getAttribute("author"));
        }
        if (node.getAttribute("title") != null) {
            result.setTitle(node.getAttribute("title"));
        }
        if (node.getAttribute("description") != null) {
            result.setDescription(node.getAttribute("description"));
        }
        if (node.hasChildNamed("image")) {
            result.setImage(new ImageXmlReader(node.getChild("image")).read());
        }
        return result;
    }

}
