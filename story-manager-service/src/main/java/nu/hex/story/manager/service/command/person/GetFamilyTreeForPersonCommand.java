package nu.hex.story.manager.service.command.person;

import java.time.format.DateTimeFormatter;
import java.util.Base64;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.service.command.AbstractServiceCommand;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetFamilyTreeForPersonCommand extends AbstractServiceCommand<XmlDocument> {

    private final Person person;

    public GetFamilyTreeForPersonCommand(Person person) {
        this.person = person;
    }

    @Override
    public XmlDocument execute() {
        XmlNode familyTree = NodeFactory.createNode("family-tree");
        familyTree.addAttribute("for", person.getGivenName() + " " + person.getFamilyName());
        familyTree.addAttribute("residence", person.getResidence());
        XmlNode personNode = createPersonNode(person);
        familyTree.addChild(personNode);
        return new XmlDocument(familyTree);
    }

    private XmlNode createPersonNode(Person p) {
        XmlNode result;
        if (p.getId().equals(person.getId())) {
            result = NodeFactory.createNode(p.getSex().name().toLowerCase());
        } else {
            result = NodeFactory.createNode(p.getSex().equals(Person.Sex.FEMALE) ? "mother" : "father");
        }
        result.addAttribute("id", p.getId().toString());
        result.addAttribute("family-name", p.getFamilyName());
        result.addAttribute("given-name", p.getGivenName());
        if (p.getMother() != null) {
            result.addChild(createPersonNode(p.getMother()));
        }
        if (p.getFather() != null) {
            result.addChild(createPersonNode(p.getFather()));
//            result.addAttribute("father", p.getFather().getName());
        }
        result.addAttribute("date-of-birth", p.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
        if (p.getPlaceOfBirth() != null) {
            result.addAttribute("place-of-birth", p.getPlaceOfBirth());
        }
        if (p.getDateOfDeath() != null) {
            result.addAttribute("date-of-death", p.getDateOfDeath().format(DateTimeFormatter.ISO_DATE));
        }
        if (p.getPlaceOfDeath() != null) {
            result.addAttribute("place-of-death", p.getPlaceOfDeath());
        }
        if (p.getCauseOfDeath() != null) {
            result.addAttribute("cause-of-death", p.getCauseOfDeath());
        }
//        if (!p.getPortraits().isEmpty()) {
//            XmlNode portraits = NodeFactory.createNode("portaits");
//            p.getPortraits().stream().forEach((portrait) -> {
//                portraits.addChild(createPortaitNode(portrait));
//            });
//            result.addChild(portraits);
//        }
        if (!p.getEvents().isEmpty()) {
            XmlNode events = NodeFactory.createNode("personal-events");
            p.getEvents().stream().forEach((e) -> {
                events.addChild(createEventNode(e));
            });
            result.addChild(events);
        }
//        if (p.getSex().equals(Person.Sex.FEMALE)) {
//            List<Person> children = getDaoFactory().getPersonDao().getChildren(p);
//            if (!children.isEmpty()) {
//                children.stream().forEach((child) -> {
//                    result.addChild(createPersonNode(child));
//                });
//            }
//        }
        return result;
    }

    private XmlNode createEventNode(PersonalEvent e) {
        XmlNode result = NodeFactory.createNode("event");
        result.addAttribute("id", e.getId().toString());
        result.addAttribute("label", e.getLabel());
        result.addAttribute("date", e.getDate().format(DateTimeFormatter.ISO_DATE));
        result.addText(e.getDescription());
        return result;
    }

    private XmlNode createPortaitNode(Portrait p) {
        XmlNode result = NodeFactory.createNode("portrait");
        result.addAttribute("id", p.getId().toString());
        result.addAttribute("label", p.getLabel());
        result.addAttribute("date", p.getDate().format(DateTimeFormatter.ISO_DATE));
        result.addChild(createImageNode(p.getImage()));
        return result;
    }

    private XmlNode createImageNode(Image i) {
        XmlNode result = NodeFactory.createNode("image");
        result.addAttribute("id", i.getId().toString());
        result.addAttribute("width", i.getWidth());
        result.addAttribute("height", i.getHeight());
        result.addAttribute("media-type", i.getMediaType());
        result.addText(Base64.getEncoder().encodeToString(i.getImageAsByteArray()));
        return result;

    }

}
