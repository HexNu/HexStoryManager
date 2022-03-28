package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class SmrxXmlWriter extends AbstractWriter<List<CampaignDocument>, XmlDocument> {

    public SmrxXmlWriter(List<CampaignDocument> doc) {
        super(doc);
    }

    public SmrxXmlWriter(CampaignDocument doc) {
        super(Arrays.asList(doc));
    }

    @Override
    public XmlDocument write() {
        XmlNode smr = NodeFactory.createNode("story-manager-rpg");
        for (CampaignDocument d : doc) {
            smr.addChild(new CampaignXmlWriter(d).write());
        }
        XmlDocument result = new XmlDocument(smr);
        result.getHead().addAttribute("encoding", "UTF-8");
        return result;
    }

}
