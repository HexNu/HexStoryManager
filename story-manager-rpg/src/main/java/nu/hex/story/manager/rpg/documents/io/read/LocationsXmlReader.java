package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.rpg.documents.LocationDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class LocationsXmlReader extends AbstractXmlReader<List<LocationDocument>> {

    public LocationsXmlReader(XmlNode node) {
        super(node);
    }

    public LocationsXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public List<LocationDocument> read() {
        List<LocationDocument> result = new ArrayList<>();
        if (node.getName().equals("location")) {
            result.add(parseNode(node));
        } else if (node.getName().equals("locations")) {
            node.getChildren("location").stream().forEach((n) -> {
                result.add(parseNode(n));
            });
        }
        return result;
    }

    private LocationDocument parseNode(XmlNode n) {
        LocationDocument result = new LocationDocument();
        if (n.hasAttribute("id")) {
            result.setId(Long.valueOf(n.getAttribute("id")));
        }
        if (n.hasAttribute("name")) {
            result.setName(n.getAttribute("name"));
        }
        if (n.hasAttribute("country")) {
            result.setCountry(n.getAttribute("country"));
        }
        if (n.hasAttribute("language")) {
            result.setLanguage(n.getAttribute("language"));
        }
        if (n.hasAttribute("currency")) {
            result.setCurrency(n.getAttribute("currency"));
        }
        if (n.hasAttribute("latitude")) {
            result.setLatitude(Double.valueOf(n.getAttribute("latitude")));
        }
        if (n.hasAttribute("longitude")) {
            result.setLongitude(Double.valueOf(n.getAttribute("longitude")));
        }
        if (n.hasChildNamed("description")) {
            result.setDescription(n.getChild("description").getText());
        }
        if (n.hasChildNamed("history")) {
            result.setHistory(n.getChild("history").getText());
        }
        if (n.hasChildNamed("notes")) {
            result.setNotes(n.getChild("notes").getText());
        }
        return result;
    }
}
