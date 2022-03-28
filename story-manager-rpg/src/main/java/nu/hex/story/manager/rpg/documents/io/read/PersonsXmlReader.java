package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.rpg.documents.PersonDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PersonsXmlReader extends AbstractXmlReader<List<PersonDocument>> {

    public PersonsXmlReader(XmlNode node) {
        super(node);
    }

    public PersonsXmlReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public List<PersonDocument> read() {
        List<PersonDocument> result = new ArrayList<>();
        for (XmlNode personNode : node.getChildren("person")) {
            PersonDocument personDocument = new PersonDocument();
            result.add(personDocument);
            if (personNode.hasAttribute("family-name")) {
                personDocument.setFamilyName(personNode.getAttribute("family-name"));
            }
            if (personNode.hasAttribute("given-name")) {
                personDocument.setGivenName(personNode.getAttribute("given-name"));
            }
            if (personNode.hasChildNamed("mother")) {
                XmlNode motherNode = personNode.getChild("mother");
                personDocument.setMother(new PersonDocument());
                if (motherNode.hasAttribute("given-name")) {
                    personDocument.getMother().setGivenName(motherNode.getAttribute("given-name"));
                }
                if (motherNode.hasAttribute("family-name")) {
                    personDocument.getMother().setFamilyName(motherNode.getAttribute("family-name"));
                }
            }
            if (personNode.hasChildNamed("father")) {
                personDocument.setFather(new PersonDocument());
                XmlNode fatherNode = personNode.getChild("father");
                if (fatherNode.hasAttribute("given-name")) {
                    personDocument.getFather().setGivenName(fatherNode.getAttribute("given-name"));
                }
                if (fatherNode.hasAttribute("family-name")) {
                    personDocument.getFather().setFamilyName(fatherNode.getAttribute("family-name"));
                }
            }
            if (personNode.hasAttribute("sex")) {
                personDocument.setSex(Person.Sex.getByString(personNode.getAttribute("sex")));
            }
            if (personNode.hasAttribute("character-class")) {
                personDocument.setCharacterClass(personNode.getAttribute("character-class"));
            }
            if (personNode.hasAttribute("character-race")) {
                personDocument.setCharacterRace(personNode.getAttribute("character-race"));
            }
            if (personNode.hasAttribute("date-of-birth")) {
                personDocument.setDateOfBirth(personNode.getAttribute("date-of-birth"));
            }
            if (personNode.hasAttribute("place-of-birth")) {
                personDocument.setPlaceOfBirth(personNode.getAttribute("place-of-birth"));
            }
            if (personNode.hasAttribute("date-of-death")) {
                personDocument.setDateOfDeath(personNode.getAttribute("date-of-death"));
            }
            if (personNode.hasAttribute("place-of-death")) {
                personDocument.setPlaceOfDeath(personNode.getAttribute("place-of-death"));
            }
            if (personNode.hasAttribute("cause-of-death")) {
                personDocument.setCauseOfDeath(personNode.getAttribute("cause-of-death"));
            }
            if (personNode.hasAttribute("residence")) {
                personDocument.setResidence(personNode.getAttribute("residence"));
            }
            if (personNode.hasChildNamed("children") && personNode.getChild("children").hasChildNamed("child")) {
                personNode.getChild("children").getChildren("child").stream().map((childNode) -> {
                    PersonDocument child = new PersonDocument();
                    if (childNode.hasAttribute("given-name")) {
                        child.setGivenName(childNode.getAttribute("given-name"));
                    }
                    if (childNode.hasAttribute("family-name")) {
                        child.setFamilyName(childNode.getAttribute("family-name"));
                    }
                    return child;
                }).forEach((child) -> {
                    personDocument.addChild(child);
                });
            }
            if (personNode.hasChildNamed("description")) {
                XmlNode descriptionNode = personNode.getChild("description");
                if (descriptionNode.hasAttribute("hair")) {
                    personDocument.setHair(descriptionNode.getAttribute("hair"));
                }
                if (descriptionNode.hasAttribute("eyes")) {
                    personDocument.setEyes(descriptionNode.getAttribute("eyes"));
                }
                if (descriptionNode.hasAttribute("skin")) {
                    personDocument.setSkin(descriptionNode.getAttribute("skin"));
                }
                if (descriptionNode.hasAttribute("height")) {
                    personDocument.setHeight(Integer.valueOf(descriptionNode.getAttribute("height")));
                }
                if (descriptionNode.hasAttribute("weight")) {
                    personDocument.setWeight(Integer.valueOf(descriptionNode.getAttribute("weight")));
                }
                if (descriptionNode.getText() != null) {
                    personDocument.appendDescription(descriptionNode.getText());
                }
            }
            if (personNode.hasChildNamed("history")) {
                personDocument.appendHistory(personNode.getChild("history").getText());
            }
            if (personNode.hasChildNamed("notes")) {
                personDocument.appendNotes(personNode.getChild("notes").getText());
            }
            if (personNode.hasChildNamed("portrait")) {
                personDocument.addPortrait(new PortraitXmlReader(personNode.getChild("portrait")).read());
            }
        }
        return result;
    }

}
