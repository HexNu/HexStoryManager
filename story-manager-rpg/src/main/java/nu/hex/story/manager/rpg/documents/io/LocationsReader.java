package nu.hex.story.manager.rpg.documents.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.hex.mediatype.CommonMediaType;
import nu.hex.story.manager.rpg.documents.LocationDocument;

public class LocationsReader extends AbstractReader<List<LocationDocument>> {

    public LocationsReader(String path) throws IOException {
        super(path);
    }

    public LocationsReader(List<String> lines) {
        super(lines);
    }

    @Override
    public List<LocationDocument> read() {
        List<LocationDocument> result = new ArrayList<>();
        LocationDocument location = new LocationDocument();
        result.add(location);
        String field = "";
        for (String line : lines) {
            if (!line.startsWith("%")) {
                if (line.contains(":")) {
                    field = getField(line);
                } else if (line.isEmpty()) {
                    location = new LocationDocument();
                    result.add(location);
                }
                switch (field) {
                    case "":
                        break;
                    case "id":
                        if (!line.isEmpty()) {
                            location.setId(getValueAsLong(line));
                        }
                        break;
                    case "name":
                        if (!line.isEmpty()) {
                            location.setName(getValue(line));
                        }
                        break;
                    case "latitude":
                        if (!line.isEmpty()) {
                            location.setLatitude(getValueAsDouble(line));
                        }
                        break;
                    case "longitude":
                        if (!line.isEmpty()) {
                            location.setLongitude(getValueAsDouble(line));
                        }
                        break;
                    case "language":
                        if (!line.isEmpty()) {
                            location.setLanguage(getValue(line));
                        }
                        break;
                    case "country":
                        if (!line.isEmpty()) {
                            location.setCountry(getValue(line));
                        }
                        break;
                    case "currency":
                        if (!line.isEmpty()) {
                            location.setCurrency(getValue(line));
                        }
                        break;
                    case "description":
                        if (!line.isEmpty()) {
                            if (location.getDescription() != null && !location.getDescription().isEmpty()) {
                                location.appendDescription("\n");
                            }
                            location.appendDescription(getValue(line));
                        }
                        break;
                    case "notes":
                        if (!line.isEmpty()) {
                            if (location.getNotes() != null && !location.getNotes().isEmpty()) {
                                location.appendNotes("\n");
                            }
                            location.appendNotes(getValue(line));
                        }
                        break;
                    case "map-title":
                        if (!line.isEmpty()) {
                            location.getMap().setTitle(getValue(line));
                        }
                        break;
                    case "map-image-location":
                        if (!line.isEmpty()) {
                            try {
                                location.getMap().getImage().setImageFromInputStream(new FileInputStream(new File(getValue(line))));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(LocationsReader.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case "map-image-width":
                        if (!line.isEmpty()) {
                            location.getMap().getImage().setWidth(getValueAsInteger(line));
                        }
                        break;
                    case "map-image-height":
                        if (!line.isEmpty()) {
                            location.getMap().getImage().setHeight(getValueAsInteger(line));
                        }
                        break;
                    case "map-image-mediatype":
                        if (!line.isEmpty()) {
                            location.getMap().getImage().setMediaType(getValue(line));
                        }
                        break;
                }
            }
        }
        for (Iterator<LocationDocument> it = result.iterator(); it.hasNext();) {
            LocationDocument c = it.next();
            if (c.getName() == null || c.getName().isEmpty()) {
                it.remove();
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<LocationDocument> locations = new LocationsReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Location.srl").read();
        for (LocationDocument location : locations) {
            if (location.getMap().getImage().getMediaType().equals(CommonMediaType.IMAGE_SVG_XML)) {
                System.out.println(new String(location.getMap().getImage().getImageAsByteArray()));
            } else {
                System.out.println(location.getMap().getImage().getImage());
            }
        }
//        new FileWriter(new BooksWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").write();
//        new FileWriter(new BooksHtmlWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.hsrb").write();
    }
}
