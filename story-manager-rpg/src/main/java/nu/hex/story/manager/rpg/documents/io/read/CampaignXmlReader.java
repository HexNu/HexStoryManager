package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class CampaignXmlReader extends AbstractXmlReader<CampaignDocument> {

    public CampaignXmlReader(XmlNode node) {
        super(node);
    }

    public CampaignXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public CampaignDocument read() {
        CampaignDocument result = new CampaignDocument();
        if (node.hasAttribute("title")) {
            result.setTitle(node.getAttribute("title"));
        }
        if (node.hasChildNamed("description")) {
            result.setDescription(node.getChild("description").getText());
        }
        if (node.hasChildNamed("books")) {
            result.setBooks(new BooksXmlReader(node.getChild("books")).read());
        }
        if (node.hasChildNamed("locations")) {
            result.setLocations(new LocationsXmlReader(node.getChild("locations")).read());
        }
        return result;
    }

}
