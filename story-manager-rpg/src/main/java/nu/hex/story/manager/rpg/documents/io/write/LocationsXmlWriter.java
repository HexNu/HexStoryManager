package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.LocationDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class LocationsXmlWriter extends AbstractWriter<List<LocationDocument>, XmlNode> {

    public LocationsXmlWriter(List<LocationDocument> doc) {
        super(doc);
    }

    public LocationsXmlWriter(LocationDocument location) {
        super(Arrays.asList(location));
    }

    @Override
    public XmlNode write() {
        XmlNode result = NodeFactory.createNode("locations");
        for (LocationDocument location : doc) {
            if (location.getName() != null && !location.getName().isEmpty()) {
                XmlNode entryNode = NodeFactory.createNode("location");
                result.addChild(entryNode);
                writeId(location, entryNode);
                writeName(location, entryNode);
                writeCountry(location, entryNode);
                writeCurrency(location, entryNode);
                writeHistory(location, entryNode);
                writeLanguage(location, entryNode);
                writeLatitude(location, entryNode);
                writeLongitude(location, entryNode);
                writeDescription(location, entryNode);
                writeNotes(location, entryNode);
                writeMap(location, entryNode);
            }
        }
        return result;
    }

    private void writeId(LocationDocument location, XmlNode result) {
        if (location.getId() != null) {
            result.addAttribute("id", location.getId().toString());
        }
    }

    private void writeName(LocationDocument location, XmlNode result) {
        String[] names = location.getName().split("\n");
        for (String name : names) {
            result.addAttribute("name", name);
        }
    }

    private void writeLanguage(LocationDocument location, XmlNode result) {
        if (location.getLanguage() != null) {
            result.addAttribute("language", location.getLanguage());
        }
    }

    private void writeLatitude(LocationDocument location, XmlNode result) {
        if (location.getLatitude() != null) {
            result.addAttribute("latitude", location.getLatitude().toString());
        }
    }

    private void writeLongitude(LocationDocument location, XmlNode result) {
        if (location.getLongitude() != null) {
            result.addAttribute("longitude", location.getLongitude().toString());
        }
    }

    private void writeCountry(LocationDocument location, XmlNode result) {
        if (location.getCountry() != null) {
            result.addAttribute("country", location.getCountry());
        }
    }

    private void writeCurrency(LocationDocument location, XmlNode result) {
        if (location.getCurrency() != null) {
            result.addAttribute("currency", location.getCurrency());
        }
    }

    private void writeDescription(LocationDocument location, XmlNode result) {
        if (location.getDescription() != null) {
            result.addChild(NodeFactory.createNode("description", location.getDescription()));
        }
    }

    private void writeNotes(LocationDocument location, XmlNode result) {
        if (location.getNotes() != null) {
            result.addChild(NodeFactory.createNode("notes", location.getNotes()));
        }
    }

    private void writeHistory(LocationDocument location, XmlNode result) {
        if (location.getHistory() != null) {
            result.addChild(NodeFactory.createNode("history", location.getHistory()));
        }
    }

    private void writeMap(LocationDocument location, XmlNode result) {
        if (location.getMap() != null) {
            result.addChild(new MapXmlWriter(location.getMap()).write());
        }
    }

    public static void main(String[] args) {
        Double d = 10.143;
        System.out.println(d.toString());
    }
}
