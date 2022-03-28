package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Base64;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class ImageXmlWriter extends AbstractWriter<Image, XmlNode> {

    public ImageXmlWriter(Image doc) {
        super(doc);
    }

    @Override
    public XmlNode write() {
        XmlNode result = NodeFactory.createNode("image");
        if (doc.getId() != null) {
            result.addAttribute("id", doc.getId().toString());
        }
        if (doc.getName() != null) {
            result.addAttribute("name", doc.getName());
        }
        if (doc.getWidth() != null) {
            result.addAttribute("width", doc.getWidth());
        }
        if (doc.getHeight() != null) {
            result.addAttribute("height", doc.getHeight());
        }
        if (doc.getMediaType() != null) {
            result.addAttribute("media-type", doc.getMediaType());
        }
        if (doc.getImageAsByteArray() != null) {
            result.addText(Base64.getEncoder().encodeToString(doc.getImageAsByteArray()));
        }
        return result;
    }

}
