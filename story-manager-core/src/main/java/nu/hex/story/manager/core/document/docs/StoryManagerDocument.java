package nu.hex.story.manager.core.document.docs;

import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.core.document.AbstractEntityDocument;
import nu.hex.story.manager.core.domain.image.Cover;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-okt-18
 *
 * @author hl
 */
public class StoryManagerDocument extends AbstractEntityDocument<Story> {

    public StoryManagerDocument(Story entity) {
        super(entity);
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        result.append(getEntity().getName());
        getEntity().getPlot().getPlotItems().stream().forEach((item) -> {
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
        body.addChild(NodeFactory.createNode("h1", getEntity().getTitle()));
        XmlNode article = NodeFactory.createNode("article");
        body.addChild(article);
        article.addChild(NodeFactory.createNode("h2", "Plot:"));
        getEntity().getPlot().getPlotItems().stream().forEach((item) -> {
            XmlNode div = NodeFactory.createNode("div");
            div.addChild(NodeFactory.createNode("h3", item.getLabel()));
            String[] pars = item.getText().split("\n");
            for (String par : pars) {
                div.addChild(NodeFactory.createNode("p", par));
            }
            article.addChild(div);
        });
        XmlNode footer = NodeFactory.createNode("footer");
        footer.addChild(NodeFactory.createNode("p", "Author: " + getEntity().getAuthor()));
        body.addChild(footer);
        return html.toString();
    }

    @Override
    public XmlDocument writeHSMF() {
        XmlNode root = NodeFactory.createNode("hex-story-manager");
        XmlNode storyNode = NodeFactory.createNode("story");
        root.addChild(storyNode);
        storyNode.addAttribute("title", getEntity().getTitle());
        if (getEntity().getSubTitle() != null) {
            storyNode.addAttribute("sub-title", getEntity().getSubTitle());
        }
        storyNode.addAttribute("author", getEntity().getAuthor());
        if (getEntity().getCover() != null) {
            XmlNode coverNode = NodeFactory.createNode("cover");
            storyNode.addChild(coverNode);
            if (getEntity().getCover().getTitle() != null) {
                coverNode.addAttribute("title", getEntity().getCover().getTitle());
            }
            if (getEntity().getCover().getAuthor() != null) {
                coverNode.addAttribute("title", getEntity().getCover().getAuthor());
            }
            if (getEntity().getCover().getImage() != null) {
                Cover cover = getEntity().getCover();
                XmlNode imageNode = NodeFactory.createNode("image");
                coverNode.addChild(imageNode);
                if (cover.getImage().getName() != null) {
                    imageNode.addAttribute("name", cover.getImage().getName());
                }
                if (cover.getImage().getMediaType() != null) {
                    imageNode.addAttribute("media-type", cover.getImage().getMediaType());
                }
                if (cover.getImage().getHeight() != null) {
                    imageNode.addAttribute("height", cover.getImage().getHeight());
                }
                if (cover.getImage().getWidth() != null) {
                    imageNode.addAttribute("width", cover.getImage().getWidth());
                }
                if (cover.getImage().getImageAsByteArray().length > 0) {
                    imageNode.addText(Base64.getEncoder().encodeToString(cover.getImage().getImageAsByteArray()));
                }

            }
        }
        if (getEntity().getPlot() != null) {
            XmlNode plotNode = NodeFactory.createNode("plot");
            storyNode.addChild(plotNode);
            getEntity().getPlot().getPlotItems().stream().forEach((item) -> {
                XmlNode itemNode = NodeFactory.createNode("item");
                plotNode.addChild(itemNode);
                itemNode.addAttribute("index", item.getIndex());
                itemNode.addAttribute("label", item.getLabel());
                for (String par : item.getText().split("\n")) {
                    itemNode.addChild(NodeFactory.createNode("line", par.replaceAll("[\\s]{2,}", " ").trim()));
                }
            });
        }
        if (!getEntity().getPersons().isEmpty()) {
            XmlNode personsNode = NodeFactory.createNode("persons");
            storyNode.addChild(personsNode);
            List<Person> persons = getEntity().getPersons();
            Collections.sort(persons, (a, b) -> a.getDateOfBirth().compareTo(b.getDateOfBirth()));
            persons.stream().forEach((person) -> {
                XmlNode personNode = NodeFactory.createNode("person");
                personNode.addAttribute("id", String.valueOf(person.getId()));
                personNode.addAttribute("given-name", person.getGivenName());
                personNode.addAttribute("family-name", person.getFamilyName());
                if (person.getDateOfBirth() != null) {
                    personNode.addAttribute("date-of-birth", person.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
                    if (person.getPlaceOfBirth() != null) {
                        personNode.addAttribute("place-of-birth", person.getPlaceOfBirth());
                    }
                }
                if (person.getDateOfDeath() != null) {
                    personNode.addAttribute("date-of-death", person.getDateOfDeath().format(DateTimeFormatter.ISO_DATE));
                    if (person.getPlaceOfDeath() != null) {
                        personNode.addAttribute("place-of-death", person.getPlaceOfDeath());
                    }
                    if (person.getCauseOfDeath() != null) {
                        personNode.addAttribute("cause-of-death", person.getCauseOfDeath());
                    }
                }
                if (person.getResidence() != null) {
                    personNode.addAttribute("residence", person.getResidence());
                }
                if (person.getMother() != null || person.getFather() != null) {
                    XmlNode parentsNode = NodeFactory.createNode("parents");
                    personNode.addChild(parentsNode);
                    if (person.getMother() != null) {
                        XmlNode motherNode = NodeFactory.createNode("mother");
                        parentsNode.addChild(motherNode);
                        motherNode.addAttribute("id", String.valueOf(person.getMother().getId()));
                        motherNode.addAttribute("mother", person.getMother().getGivenName() + " " + person.getMother().getFamilyName());
                    }
                    if (person.getFather() != null) {
                        XmlNode fatherNode = NodeFactory.createNode("father");
                        parentsNode.addChild(fatherNode);
                        fatherNode.addAttribute("id", String.valueOf(person.getFather().getId()));
                        fatherNode.addAttribute("father", person.getFather().getGivenName() + " " + person.getFather().getFamilyName());
                    }
                }
                if (!person.getPortraits().isEmpty()) {
                    XmlNode portraitsNode = NodeFactory.createNode("portraits");
                    personNode.addChild(portraitsNode);
                    person.getPortraits().stream().forEach((portrait) -> {
                        XmlNode portraitNode = NodeFactory.createNode("portrait");
                        portraitsNode.addChild(portraitNode);
                        portraitNode.addAttribute("label", portrait.getLabel());
                        if (portrait.getDate() != null) {
                            portraitNode.addAttribute("date", portrait.getDate().format(DateTimeFormatter.ISO_DATE));
                        }
                        if (portrait.getDescription() != null) {
                            XmlNode descriptionNode = NodeFactory.createNode("description");
                            portraitNode.addChild(descriptionNode);
                            for (String par : portrait.getDescription().split("\n")) {
                                descriptionNode.addChild(NodeFactory.createNode("line", par.replaceAll("[\\s]{2,}", " ").trim()));
                            }
                        }
                        if (portrait.getImage() != null) {
                            XmlNode imageNode = NodeFactory.createNode("image");
                            portraitNode.addChild(imageNode);
                            if (portrait.getImage().getName() != null) {
                                imageNode.addAttribute("name", portrait.getImage().getName());
                            }
                            if (portrait.getImage().getMediaType() != null) {
                                imageNode.addAttribute("media-type", portrait.getImage().getMediaType());
                            }
                            if (portrait.getImage().getHeight() != null) {
                                imageNode.addAttribute("height", portrait.getImage().getHeight());
                            }
                            if (portrait.getImage().getWidth() != null) {
                                imageNode.addAttribute("width", portrait.getImage().getWidth());
                            }
                            if (portrait.getImage().getImageAsByteArray().length > 0) {
                                imageNode.addText(Base64.getEncoder().encodeToString(portrait.getImage().getImageAsByteArray()));
                            }
                        }
                    });
                }
                personsNode.addChild(personNode);
            });

        }
        if (!getEntity().getChapters().isEmpty()) {
            XmlNode chaptersNode = NodeFactory.createNode("chapters");
            storyNode.addChild(chaptersNode);
            getEntity().getChapters().stream().forEach((chapter) -> {
                XmlNode chapterNode = NodeFactory.createNode("chapter");
                chaptersNode.addChild(chapterNode);
                chapterNode.addAttribute("number", chapter.getNumber());
                chapterNode.addAttribute("label", chapter.getHeading());
                if (chapter.getDescription() != null) {
                    XmlNode descriptionNode = NodeFactory.createNode("description");
                    chapterNode.addChild(descriptionNode);
                    for (String par : chapter.getDescription().split("\n")) {
                        descriptionNode.addChild(NodeFactory.createNode("line", par.replaceAll("[\\s]{2,}", " ").trim()));
                    }
                }
                if (chapter.getText() != null) {
                    XmlNode paragraphsNode = NodeFactory.createNode("paragraphs");
                    chapterNode.addChild(paragraphsNode);
                    for (String par : chapter.getText().split("\n")) {
                        paragraphsNode.addChild(NodeFactory.createNode("paragraph", par.replaceAll("[\\s]{2,}", " ").trim()));
                    }
                }
                if (!chapter.getIllustrations().isEmpty()) {
                    XmlNode illustrationsNode = NodeFactory.createNode("illustrations");
                    chapterNode.addChild(illustrationsNode);
                    chapter.getIllustrations().stream().forEach((illustration) -> {
                        XmlNode illustrationNode = NodeFactory.createNode("illustration");
                        illustrationsNode.addChild(illustrationNode);
                        illustrationNode.addAttribute("label", illustration.getLabel());
                        if (illustration.getDate() != null) {
                            illustrationNode.addAttribute("date", illustration.getDate().format(DateTimeFormatter.ISO_DATE));
                        }
                        if (illustration.getShortDescription() != null) {
                            illustrationNode.addChild(NodeFactory.createNode("short-description", illustration.getShortDescription()));
                        }
                        if (illustration.getDescription() != null) {
                            XmlNode descriptionNode = NodeFactory.createNode("description");
                            illustrationNode.addChild(descriptionNode);
                            for (String par : illustration.getDescription().split("\n")) {
                                descriptionNode.addChild(NodeFactory.createNode("line", par.replaceAll("[\\s]{2,}", " ").trim()));
                            }
                        }
                        if (illustration.getImage() != null) {
                            XmlNode imageNode = NodeFactory.createNode("image");
                            illustrationNode.addChild(imageNode);
                            if (illustration.getImage().getName() != null) {
                                imageNode.addAttribute("name", illustration.getImage().getName());
                            }
                            if (illustration.getImage().getMediaType() != null) {
                                imageNode.addAttribute("media-type", illustration.getImage().getMediaType());
                            }
                            if (illustration.getImage().getHeight() != null) {
                                imageNode.addAttribute("height", illustration.getImage().getHeight());
                            }
                            if (illustration.getImage().getWidth() != null) {
                                imageNode.addAttribute("width", illustration.getImage().getWidth());
                            }
                            if (illustration.getImage().getImageAsByteArray().length > 0) {
                                imageNode.addText(Base64.getEncoder().encodeToString(illustration.getImage().getImageAsByteArray()));
                            }
                        }
                    });
                }
            });
        }
        XmlDocument result = new XmlDocument(root);
        return result;
    }
}
