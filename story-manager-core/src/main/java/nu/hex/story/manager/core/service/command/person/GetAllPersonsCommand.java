package nu.hex.story.manager.core.service.command.person;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.service.command.AbstractServiceCommand;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
public class GetAllPersonsCommand extends AbstractServiceCommand<XmlDocument> {

    @Override
    public XmlDocument execute() {
        List<Person> result = getDaoFactory().getPersonDao().findAll();
        Collections.sort(result, (a, b) -> a.getDateOfBirth().compareTo(b.getDateOfBirth()));
        return createXmlDocument(result);
    }

    private XmlDocument createXmlDocument(List<Person> persons) {
        XmlNode root = NodeFactory.createNode("persons");
        for (Person p : persons) {
            XmlNode personNode = NodeFactory.createNode(p.getSex().name().toLowerCase());
            personNode.addAttribute("id", String.valueOf(p.getId()));
            personNode.addAttribute("family-name", p.getFamilyName());
            personNode.addAttribute("given-name", p.getGivenName());
            if (p.getMother() != null) {
                personNode.addAttribute("mother", p.getMother().getGivenName() + " " + p.getMother().getFamilyName());
            }
            if (p.getFather() != null) {
                personNode.addAttribute("father", p.getFather().getGivenName() + " " + p.getFather().getFamilyName());
            }
            if (p.getDateOfBirth() != null) {
                personNode.addAttribute("date-of-birth", p.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
            }
            personNode.addAttribute("place-of-birth", p.getPlaceOfBirth());
            if (p.getDateOfDeath() != null) {
                personNode.addAttribute("date-of-death", p.getDateOfDeath().format(DateTimeFormatter.ISO_DATE));
            }
            personNode.addAttribute("place-of-death", p.getPlaceOfDeath());
            personNode.addAttribute("residence", p.getResidence());
            root.addChild(personNode);
        }
        return new XmlDocument(root);
    }
}
