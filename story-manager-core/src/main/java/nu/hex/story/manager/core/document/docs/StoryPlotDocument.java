package nu.hex.story.manager.core.document.docs;

import nu.hex.story.manager.core.domain.story.Plot;
import nu.hex.story.manager.core.document.AbstractEntityDocument;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class StoryPlotDocument extends AbstractEntityDocument<Plot> {

    public StoryPlotDocument(Plot entity) {
        super(entity);
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        result.append(getEntity().getName());
        getEntity().getPlotItems().stream().forEach((item) -> {
            result.append("\n\n")
                    .append(item.getLabel()).append("\n")
                    .append(item.getText());
        });
        return result.toString();
    }

    @Override
    public String writeHTML() {
        XmlNode html = NodeFactory.createNode("html");
        XmlNode head = NodeFactory.createNode("head");
        html.addChild(head);
        head.addChild(NodeFactory.createNode("title", getEntity().getName()));
        XmlNode body = NodeFactory.createNode("body");
        html.addChild(body);
        body.addChild(NodeFactory.createNode("h1", getEntity().getStory().getTitle()));
        XmlNode article = NodeFactory.createNode("article");
        body.addChild(article);
        article.addChild(NodeFactory.createNode("h2", "Plot:"));
        getEntity().getPlotItems().stream().forEach((item) -> {
            XmlNode div = NodeFactory.createNode("div");
            div.addChild(NodeFactory.createNode("h3", item.getLabel()));
            String[] pars = item.getText().split("\n");
            for (String par : pars) {
                div.addChild(NodeFactory.createNode("p", par));
            }
            article.addChild(div);
        });
        XmlNode footer = NodeFactory.createNode("footer");
        footer.addChild(NodeFactory.createNode("p", "Author: " + getEntity().getStory().getAuthor()));
        body.addChild(footer);
        return html.toString();
    }

    @Override
    public XmlDocument writeHSMF() {
        XmlNode root = NodeFactory.createNode("hex-story-manager");
        XmlNode story = NodeFactory.createNode("story");
        root.addChild(story);
        story.addAttribute("title", getEntity().getStory().getTitle());
        story.addAttribute("author", getEntity().getStory().getAuthor());
        XmlNode plotNode = NodeFactory.createNode("plot");
        story.addChild(plotNode);
        getEntity().getPlotItems().stream().forEach((item)-> {
            XmlNode itemNode = NodeFactory.createNode("item");
            plotNode.addChild(itemNode);
            itemNode.addAttribute("index", item.getIndex());
            itemNode.addAttribute("label", item.getLabel());
            for (String par : item.getText().split("\n")) {
                itemNode.addChild(NodeFactory.createNode("line", par));
            }
        });
        XmlDocument result = new XmlDocument(root);
        return result;
    }
}
