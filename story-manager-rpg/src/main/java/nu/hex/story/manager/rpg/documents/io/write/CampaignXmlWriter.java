package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class CampaignXmlWriter extends AbstractWriter<List<CampaignDocument>, XmlNode> {

    public CampaignXmlWriter(List<CampaignDocument> doc) {
        super(doc);
    }

    public CampaignXmlWriter(CampaignDocument doc) {
        super(Arrays.asList(doc));
    }

    @Override
    public XmlNode write() {
        XmlNode campaignsNode = NodeFactory.createNode("campaigns");
        for (CampaignDocument c : doc) {
            XmlNode campaign = NodeFactory.createNode("campaign");
            campaignsNode.addChild(campaign);
            if (c.getTitle() != null) {
                campaign.addAttribute("title", c.getTitle());
            }
            if (c.getDescription() != null) {
                campaign.addChild(NodeFactory.createNode("description", c.getDescription()));
            }
            if (c.getBooks() != null && !c.getBooks().isEmpty()) {
                campaign.addChild(new BooksXmlWriter(c.getBooks()).write());
            }
            if (c.getLocations() != null && !c.getLocations().isEmpty()) {
                campaign.addChild(new LocationsXmlWriter(c.getLocations()).write());
            }
            if (c.getPersons() != null && !c.getPersons().isEmpty()) {
                campaign.addChild(new PersonsXmlWriter(c.getPersons()).write());
            }
        }
        return campaignsNode;
    }

}
