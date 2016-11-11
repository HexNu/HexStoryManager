package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import java.util.Base64;
import nu.hex.story.manager.rpg.documents.ImageDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class ImageXmlReader extends AbstractXmlReader<ImageDocument> {

    public ImageXmlReader(XmlNode node) {
        super(node);
    }

    public ImageXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public ImageDocument read() {
        ImageDocument result = new ImageDocument();
        if (node.hasAttribute("id")) {
            result.setId(Long.valueOf(node.getAttribute("id")));
        }
        if (node.hasAttribute("name")) {
            result.setName(node.getAttribute("name"));
        }
        if (node.hasAttribute("width")) {
            result.setWidth(Integer.valueOf(node.getAttribute("width")));
        }
        if (node.hasAttribute("height")) {
            result.setHeight(Integer.valueOf(node.getAttribute("height")));
        }
        if (node.hasAttribute("media-type")) {
            result.setMediaType(node.getAttribute("media-type"));
        }
        if (node.getText() != null) {
            result.setImageFromByteArray(Base64.getDecoder().decode(node.getText()));
        }
        return result;
    }

}
