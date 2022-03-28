package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.hex.story.manager.core.domain.person.Person.Sex;
import nu.hex.story.manager.rpg.documents.ImageDocument;
import nu.hex.story.manager.rpg.documents.PersonDocument;
import nu.hex.story.manager.rpg.documents.PortraitDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractReader;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class PersonsReader extends AbstractReader<List<PersonDocument>> {

    public PersonsReader(String path) throws IOException {
        super(path);
    }

    public PersonsReader(List<String> lines) {
        super(lines);
    }

    @Override
    public List<PersonDocument> read() {
        List<PersonDocument> result = new ArrayList<>();
        PersonDocument person = new PersonDocument();
        PortraitDocument portrait = new PortraitDocument();
        person.addPortrait(portrait);
        ImageDocument image = new ImageDocument();
        portrait.setImage(image);
        result.add(person);
        String field = "";
        for (String line : lines) {
            if (!line.startsWith("%")) {
                if (line.contains(":")) {
                    field = getField(line);
                } else if (line.isEmpty()) {
                    person = new PersonDocument();
                    portrait = new PortraitDocument();
                    person.addPortrait(portrait);
                    image = new ImageDocument();
                    portrait.setImage(image);
                    result.add(person);
                }
                switch (field) {
                    case "":
                        break;
                    case "id":
                        break;
                    case "family-name":
                        if (!line.isEmpty()) {
                            person.setFamilyName(getValue(line));
                        }
                        break;
                    case "given-name":
                        if (!line.isEmpty()) {
                            person.setGivenName(getValue(line));
                        }
                        break;
                    case "mother":
                        if (!line.isEmpty()) {
                            String value = getValue(line);
                            if (value.contains(",")) {
                                person.setMother(value.split(",")[1].trim(), value.split(",")[0].trim());
                            } else if (value.contains(" ")) {
                                person.setMother(value.split(" ")[0].trim(), value.split(" ")[1].trim());
                            } else {
                                person.setMother(null, value);
                            }
                        }
                        break;
                    case "father":
                        if (!line.isEmpty()) {
                            String value = getValue(line);
                            if (value.contains(",")) {
                                person.setFather(value.split(",")[1].trim(), value.split(",")[0].trim());
                            } else if (value.contains(" ")) {
                                person.setFather(value.split(" ")[0].trim(), value.split(" ")[1].trim());
                            } else {
                                person.setFather(null, value);
                            }
                        }
                        break;
                    case "sex":
                        if (!line.isEmpty()) {
                            person.setSex(Sex.getByString(getValue(line)));
                        }
                        break;
                    case "character-race":
                        if (!line.isEmpty()) {
                            person.setCharacterRace(getValue(line));
                        }
                        break;
                    case "character-class":
                        if (!line.isEmpty()) {
                            person.setCharacterClass(getValue(line));
                        }
                        break;
                    case "date-of-birth":
                        if (!line.isEmpty()) {
                            person.setDateOfBirth(getValue(line));
                        }
                        break;
                    case "place-of-birth":
                        if (!line.isEmpty()) {
                            person.setPlaceOfBirth(getValue(line));
                        }
                        break;
                    case "date-of-death":
                        if (!line.isEmpty()) {
                            person.setDateOfDeath(getValue(line));
                        }
                        break;
                    case "place-of-death":
                        if (!line.isEmpty()) {
                            person.setPlaceOfDeath(getValue(line));
                        }
                        break;
                    case "cause-of-death":
                        if (!line.isEmpty()) {
                            person.setCauseOfDeath(getValue(line));
                        }
                        break;
                    case "children":
                        if (!line.isEmpty()) {
                            person.setChildren(getValueAsInteger(line));
                        }
                        break;
                    case "residence":
                        if (!line.isEmpty()) {
                            person.setResidence(getValue(line));
                        }
                        break;
                    case "height":
                        if (!line.isEmpty()) {
                            person.setHeight(getValueAsInteger(line));
                        }
                        break;
                    case "weight":
                        if (!line.isEmpty()) {
                            person.setWeight(getValueAsInteger(line));
                        }
                        break;
                    case "eyes":
                        if (!line.isEmpty()) {
                            person.setEyes(getValue(line));
                        }
                        break;
                    case "skin":
                        if (!line.isEmpty()) {
                            person.setSkin(getValue(line));
                        }
                        break;
                    case "hair":
                        if (!line.isEmpty()) {
                            person.setHair(getValue(line));
                        }
                        break;
                    case "description":
                        if (!line.isEmpty()) {
                            if (person.getDescription() != null && !person.getDescription().isEmpty()) {
                                person.appendDescription("\n");
                            }
                            person.appendDescription(getValue(line));
                        }
                        break;
                    case "history":
                        if (!line.isEmpty()) {
                            if (person.getHistory() != null && !person.getHistory().isEmpty()) {
                                person.appendHistory("\n");
                            }
                            person.appendHistory(getValue(line));
                        }
                        break;
                    case "notes":
                        if (!line.isEmpty()) {
                            if (person.getNotes() != null && !person.getNotes().isEmpty()) {
                                person.appendNotes("\n");
                            }
                            person.appendNotes(getValue(line));
                        }
                        break;
                    case "portrait-label":
                        if (!line.isEmpty()) {
                            portrait.setLabel(getValue(line));
                        }
                        break;
                    case "portrait-date":
                        if (!line.isEmpty()) {
                            portrait.setDate(getValue(line));
                        }
                        break;
                    case "portrait-image-location":
                        if (!line.isEmpty()) {
                            try {
                                portrait.getImage().setImageFromInputStream(new FileInputStream(getValueAsFile(line)));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(PersonsReader.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case "portrait-image-width":
                        if (!line.isEmpty()) {
                            portrait.getImage().setWidth(getValueAsInteger(line));
                        }
                        break;
                    case "portrait-image-height":
                        if (!line.isEmpty()) {
                            portrait.getImage().setHeight(getValueAsInteger(line));
                        }
                        break;
                    case "portrait-image-media-type":
                        if (!line.isEmpty()) {
                            portrait.getImage().setMediaType(getValue(line));
                        }
                        break;
                }
            }
        }
        for (Iterator<PersonDocument> it = result.iterator(); it.hasNext();) {
            PersonDocument p = it.next();
            if ((p.getFamilyName() == null || p.getFamilyName().isEmpty()) && (p.getGivenName() == null || p.getGivenName().isEmpty())) {
                it.remove();
            }
        }
        return result;
    }

}
