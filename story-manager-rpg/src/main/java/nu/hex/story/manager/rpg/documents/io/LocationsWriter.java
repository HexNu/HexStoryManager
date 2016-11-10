package nu.hex.story.manager.rpg.documents.io;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.Book;
import nu.hex.story.manager.rpg.documents.LocationDocument;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class LocationsWriter extends AbstractWriter<List<LocationDocument>> {

    public LocationsWriter(List<LocationDocument> doc) {
        super(doc);
    }

    public LocationsWriter(LocationDocument location) {
        super(Arrays.asList(location));
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        for (LocationDocument location : doc) {
            if (!result.toString().isEmpty()) {
                result.append("\n");
            }
            if (location.getName() != null && !location.getName().isEmpty()) {
                writeId(location, result);
                writeName(location, result);
                writeCountry(location, result);
                writeCurrency(location, result);
                writeHistory(location, result);
                writeLanguage(location, result);
                writeLatitude(location, result);
                writeLongitude(location, result);
                writeDescription(location, result);
                writeNotes(location, result);
            }
        }
        return result.toString();
    }

    private void writeId(LocationDocument location, StringBuilder result) {
        if (location.getId() != null) {
            result.append("id: ").append(location.getId()).append("\n");
        }
    }

    private void writeName(LocationDocument location, StringBuilder result) {
        String[] names = location.getName().split("\n");
        for (String name : names) {
            result.append("name: ").append(name).append("\n");
        }
    }

    private void writeLanguage(LocationDocument location, StringBuilder result) {
        if (location.getLanguage() != null) {
            result.append("language: ").append(location.getLanguage()).append("\n");
        }
    }

    private void writeLatitude(LocationDocument location, StringBuilder result) {
        if (location.getLatitude() != null) {
            result.append("latitude: ").append(location.getLatitude()).append("\n");
        }
    }

    private void writeLongitude(LocationDocument location, StringBuilder result) {
        if (location.getLongitude() != null) {
            result.append("longitude: ").append(location.getLongitude()).append("\n");
        }
    }

    private void writeCountry(LocationDocument location, StringBuilder result) {
        if (location.getCountry() != null) {
            result.append("country: ").append(location.getCountry()).append("\n");
        }
    }

    private void writeCurrency(LocationDocument location, StringBuilder result) {
        if (location.getCurrency() != null) {
            result.append("currency: ").append(location.getCurrency()).append("\n");
        }
    }

    private void writeDescription(LocationDocument location, StringBuilder result) {
        if (location.getDescription() != null) {
            result.append("description: ").append(location.getDescription()).append("\n");
        }
    }

    private void writeNotes(LocationDocument location, StringBuilder result) {
        if (location.getNotes() != null) {
            result.append("notes: ").append(location.getNotes()).append("\n");
        }
    }

    private void writeHistory(LocationDocument location, StringBuilder result) {
        if (location.getHistory() != null) {
            result.append("history: ").append(location.getHistory()).append("\n");
        }
    }
}
