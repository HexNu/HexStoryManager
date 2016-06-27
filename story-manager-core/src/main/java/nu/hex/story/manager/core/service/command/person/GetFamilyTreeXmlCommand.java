package nu.hex.story.manager.core.service.command.person;

import java.time.format.DateTimeFormatter;
import java.util.List;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.domain.PersonalEvent;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-jun-27
 *
 * @author hl
 */
public class GetFamilyTreeXmlCommand extends AbstractServiceCommand<XmlDocument> {

    private final Person mother;
    private final Person father;

    public GetFamilyTreeXmlCommand(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
    }

    @Override
    public XmlDocument execute() {
        XmlDocument result = new XmlDocument(NodeFactory.createNode("family-tree"));
        result.getRoot().addAttribute("family", "The " + father.getFamilyName() + " Family");
        result.getRoot().addAttribute("residence", father.getResidence());
        result.getRoot().addChild(createChildNode(father));
        result.getRoot().addChild(createChildNode(mother));
        return result;
    }

    private XmlNode createChildNode(Person p) {
        XmlNode result = NodeFactory.createNode(p.getSex().name().toLowerCase());
        result.addAttribute("id", p.getId().toString());
        result.addAttribute("name", p.getName());
        if (p.getFather() != null) {
            result.addAttribute("father", p.getFather().getName());
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
        if (!p.getEvents().isEmpty()) {
            XmlNode events = NodeFactory.createNode("personal-events");
            for (PersonalEvent e : p.getEvents()) {
                XmlNode event = NodeFactory.createNode("event");
                event.addAttribute("date", e.getDate().format(DateTimeFormatter.ISO_DATE));
                event.addText(e.getDescription());
                events.addChild(event);
            }
            result.addChild(events);
        }
        if (p.getSex().equals(Person.Sex.FEMALE)) {
            List<Person> children = getDaoFactory().getPersonDao().getChildren(p);
            if (!children.isEmpty()) {
                children.stream().forEach((child) -> {
                    result.addChild(createChildNode(child));
                });
            }
        }
        return result;
    }

}
