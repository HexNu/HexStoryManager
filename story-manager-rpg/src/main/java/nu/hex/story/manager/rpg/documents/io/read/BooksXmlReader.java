package nu.hex.story.manager.rpg.documents.io.read;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.rpg.documents.BookDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractXmlReader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 */
public class BooksXmlReader extends AbstractXmlReader<List<BookDocument>> {
    
    public BooksXmlReader(XmlNode node) {
        super(node);
    }
    
    public BooksXmlReader(String path) throws FileNotFoundException {
        super(path);
    }
    
    @Override
    public List<BookDocument> read() {
        List<BookDocument> result = new ArrayList<>();
        if (node.getName().equals("book")) {
            result.add(parseBookNode(node));
        } else if (node.hasChildNamed("book")) {
            node.getChildren("book").stream().forEach((bookNode) -> {
                result.add(parseBookNode(bookNode));
            });
        }
        return result;
    }
    
    private BookDocument parseBookNode(XmlNode node) {
        BookDocument result = new BookDocument();
        if (node.hasAttribute("id")) {
            result.setId(Long.valueOf(node.getAttribute("id")));
        }
        node.getChild("titles").getChildren("title").stream().forEach((title) -> {
            result.appendTitle(title.getText());
        });
        if (node.hasAttribute("number-of-volumes")) {
            int vols = Integer.valueOf(node.getAttribute("number-of-volumes"));
            result.setVolumes(vols);
        }
        if (node.hasChildNamed("authors")) {
            node.getChild("authors").getChildren("author").stream().forEach((author) -> {
                String givenName = "";
                String familyName = "";
                if (author.getText().contains(",")) {
                    String[] names = author.getText().split(",");
                    familyName = names[0];
                    givenName = names[1];
                } else if (author.getText().contains(" ")) {
                    String[] names = author.getText().split(" ");
                    familyName = names[1];
                    givenName = names[0];
                }
                result.addAuthor(givenName, familyName);
            });
        }
        if (node.hasChildNamed("published")) {
            XmlNode pub = node.getChild("published");
            if (pub.hasAttribute("location")) {
                result.setPlaceOfPublication(pub.getAttribute("location"));
            }
            if (pub.hasAttribute("year")) {
                result.setYearOfPublication(Integer.valueOf(pub.getAttribute("year")));
            }
            if (pub.hasAttribute("publisher")) {
                result.setPublisher(pub.getAttribute("publisher"));
            }
        }
        if (node.hasAttribute("language")) {
            result.setLanguage(node.getAttribute("language"));
        }
        if (node.hasChildNamed("subjects")) {
            node.getChild("subjects").getChildren("subject").stream().forEach((n) -> {
                result.appendSubject(n.getText());
            });
        }
        if (node.hasChildNamed("description")) {
            result.appendDescription(node.getChild("description").getText());
        }
        if (node.hasChildNamed("notes")) {
            result.appendNotes(node.getChild("notes").getText());
        }
        return result;
    }
    
}
