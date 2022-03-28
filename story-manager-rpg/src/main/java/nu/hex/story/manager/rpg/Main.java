package nu.hex.story.manager.rpg;

import java.io.IOException;
import java.util.List;
import nu.hex.story.manager.rpg.documents.BookDocument;
import nu.hex.story.manager.rpg.documents.CampaignDocument;
import nu.hex.story.manager.rpg.documents.LocationDocument;
import nu.hex.story.manager.rpg.documents.PersonDocument;
import nu.hex.story.manager.rpg.documents.io.read.BooksReader;
import nu.hex.story.manager.rpg.documents.io.FileWriter;
import nu.hex.story.manager.rpg.documents.io.read.LocationsReader;
import nu.hex.story.manager.rpg.documents.io.read.PersonsReader;
import nu.hex.story.manager.rpg.documents.io.write.SmrxXmlWriter;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<BookDocument> books = new BooksReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").read();
        List<PersonDocument> persons = new PersonsReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Persons.srp").read();
        List<LocationDocument> locations = new LocationsReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Locations.srl").read();
        CampaignDocument campaign = new CampaignDocument();
        campaign.setTitle("Northern Lights");
        campaign.setDescription("In Northern Lights the characters will explore everything that is happening in the northern countries, Aglium and Edra.\n"
                + "In Stare, formerly Oclos, an aristocratic villain has just been twarted while in Ægis, an order of quasi scientific monks are trying to summon Doohlach, a demon that will wreak havoc over the world.");
        campaign.setBooks(books);
        campaign.setLocations(locations);
        campaign.setPersons(persons);
        new FileWriter(new SmrxXmlWriter(campaign).write(), "/home/hl/Dokument/RPG/Northern Lights.smrx").write();
    }
}
