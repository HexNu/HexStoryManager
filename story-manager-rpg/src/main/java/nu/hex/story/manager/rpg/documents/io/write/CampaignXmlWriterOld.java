package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class CampaignXmlWriterOld extends AbstractWriter<List<XmlNode>, XmlDocument> {

    private String campaignTitle;
    private String description;

    public CampaignXmlWriterOld(List<XmlNode> doc) {
        super(doc);
    }

    public void setTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public XmlDocument write() {
        XmlNode root = NodeFactory.createNode("story-manager-rpg");
        XmlNode campaign = NodeFactory.createNode("campaign");
        if (campaignTitle != null) {
            campaign.addAttribute("title", campaignTitle);
        }
        if (description != null) {
            campaign.addChild(NodeFactory.createNode("description", description));
        }
        Collections.sort(doc, (a, b) -> a.getName().compareTo(b.getName()));
        doc.stream().forEach((node) -> {
            campaign.addChild(node);
        });
        root.addChild(campaign);
        XmlDocument result = new XmlDocument(root);
        result.getHead().addAttribute("encoding", "UTF-8");
        return result;
    }

}
