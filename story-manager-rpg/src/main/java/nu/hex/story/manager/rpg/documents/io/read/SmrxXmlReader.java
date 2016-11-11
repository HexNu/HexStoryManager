package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class SmrxXmlReader extends AbstractXmlReader<List<CampaignDocument>> {

    public SmrxXmlReader(XmlNode node) {
        super(node);
    }

    public SmrxXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public List<CampaignDocument> read() {
        List<CampaignDocument> result = new ArrayList<>();
        if (node.getName().equals("campaign")) {
            result.add(parseCampaignNode(node));
        } else {
            node.getChildren("campaign").stream().forEach((n) -> {
                result.add(parseCampaignNode(n));
            });
        }
        return result;
    }

    private CampaignDocument parseCampaignNode(XmlNode campaignNode) {
        return new CampaignXmlReader(campaignNode).read();
    }

}
