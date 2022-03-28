package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.BookDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;
import se.digitman.lightxml.NodeFactory;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class BooksXmlWriter extends AbstractWriter<List<BookDocument>, XmlNode> {

    public BooksXmlWriter(List<BookDocument> doc) {
        super(doc);
    }

    public BooksXmlWriter(BookDocument book) {
        super(Arrays.asList(book));
    }

    @Override
    public XmlNode write() {
        XmlNode booksNode = NodeFactory.createNode("books");
        for (BookDocument book : doc) {
            XmlNode entry = NodeFactory.createNode("book");
            booksNode.addChild(entry);
            if (book.getTitle() != null && !book.getTitle().isEmpty()) {
                writeId(book, entry);
                writeTitle(book, entry);
                writeAuthors(book, entry);
                writeNumberOfVolumes(book, entry);
                writePublished(book, entry);
                writeLanguage(book, entry);
                writeSubjects(book, entry);
                writeDescription(book, entry);
                writeNotes(book, entry);
            }
        }
        return booksNode;
    }
//
//    private XmlNode addRow(String label, Long content) {
//        return addRow(label, String.valueOf(content));
//    }
//
//    private XmlNode addRow(String label, Integer content) {
//        return addRow(label, String.valueOf(content));
//    }
//
//    private XmlNode addRow(String label, StringBuilder content) {
//        return addRow(label, content.toString());
//    }

    private XmlNode addRow(String label, String content) {
        XmlNode row = NodeFactory.createNode(label, content);
        return row;
    }

    private XmlNode addRow(String label, String[] content) {
        XmlNode row = NodeFactory.createNode(label + "s");
        for (String line : content) {
            row.addChild(NodeFactory.createNode(label, line));
        }
        return row;
    }

    private void writeId(BookDocument book, XmlNode entryNode) {
        if (book.getId() != null) {
            entryNode.addAttribute("id", book.getId().toString());
        }
    }

    private void writeTitle(BookDocument book, XmlNode entryNode) {
        entryNode.addChild(addRow("title", book.getTitle().split("\n")));
//        XmlNode titlesNode = NodeFactory.createNode("titles");
//        entryNode.addChild(titlesNode);
//        for (String title : book.getTitle().split("\n")) {
//            titlesNode.addChild(addRow("title", title));
//        }
    }

    private void writeAuthors(BookDocument book, XmlNode entryNode) {
        if (!book.getAuthors().isEmpty()) {
            XmlNode authorsNode = NodeFactory.createNode("authors");
            entryNode.addChild(authorsNode);
            book.getAuthors().stream().forEach((author) -> {
                authorsNode.addChild(addRow("author", author.getName()));
            });
        }
    }

    private void writeNumberOfVolumes(BookDocument book, XmlNode entryNode) {
        if (book.getNumberOfVolumes() > 1) {
            entryNode.addAttribute("number-of-volumes", book.getNumberOfVolumes());
        }
    }

    private void writePublished(BookDocument book, XmlNode entryNode) {
        XmlNode published = NodeFactory.createNode("published");
        if (book.getPlaceOfPublication() != null) {
            published.addAttribute("location", book.getPlaceOfPublication());
        }
        if (book.getYearOfPublication() != null) {
            published.addAttribute("year", book.getYearOfPublication());
        }
        if (book.getPublisher() != null) {
            published.addAttribute("publisher", book.getPublisher());
        }
        if (!published.toString().equals("<published/>")) {
            entryNode.addChild(published);
        }
    }

    private void writeLanguage(BookDocument book, XmlNode entryNode) {
        if (book.getLanguage() != null) {
            entryNode.addAttribute("language", book.getLanguage());
        }
    }

    private void writeSubjects(BookDocument book, XmlNode entryNode) {
        if (book.getSubject() != null) {
            entryNode.addChild(addRow("subject", book.getSubject().split("\n")));
        }
    }

    private void writeDescription(BookDocument book, XmlNode entryNode) {
        if (book.getDescription() != null) {
            entryNode.addChild(addRow("description", book.getDescription()));
        }
    }

    private void writeNotes(BookDocument book, XmlNode entryNode) {
        if (book.getNotes() != null) {
            entryNode.addChild(addRow("notes", book.getNotes()));
        }
    }

    public static void main(String[] args) {
        Long l = 100L;
        System.out.println(l.toString());
    }
}
