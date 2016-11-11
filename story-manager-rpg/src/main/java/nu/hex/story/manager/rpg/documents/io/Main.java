package nu.hex.story.manager.rpg.documents.io;

import java.io.IOException;
import java.util.List;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.PersonDocument;
import nu.hex.story.manager.rpg.documents.io.read.PersonsReader;
import nu.hex.story.manager.rpg.documents.io.read.SmrxXmlReader;
import nu.hex.story.manager.rpg.documents.io.write.SmrxXmlWriter;
import se.digitman.lightxml.XmlDocument;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<PersonDocument> persons = new PersonsReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Persons.srp").read();
        for (Person p : persons) {
            System.out.println(p.getName());
        }
        List<CampaignDocument> campaigns = new SmrxXmlReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Campaign.smrx").read();
        campaigns.get(0).setPersons(persons);
        
        XmlDocument doc = new SmrxXmlWriter(campaigns).write();
        new FileWriter(doc, "/home/hl/Dokument/RPG/NorthernLights.smrx").write();
//        System.out.println(campaigns.get(0).getPersons().get(0).getSex());
//        campaigns.stream().forEach((c) -> {
//            System.out.println(c.getTitle());
//            System.out.println(c.getDescription());
//            c.getBooks().stream().forEach((b) -> {
//                System.out.println(b.getTitle());
//            });
//            c.getLocations().stream().forEach((l) -> {
//                System.out.println(l.getName());
//            });
//        });
    }
}
