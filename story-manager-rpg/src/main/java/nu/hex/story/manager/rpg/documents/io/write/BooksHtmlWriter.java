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
public class BooksHtmlWriter extends AbstractWriter<List<BookDocument>, String> {

    public BooksHtmlWriter(List<BookDocument> doc) {
        super(doc);
    }

    public BooksHtmlWriter(BookDocument book) {
        super(Arrays.asList(book));
    }

    @Override
    public String write() {
        XmlNode docNode = NodeFactory.createNode("html");
        docNode.addChild(createHead("Booklist"));
        docNode.addChild(createBody("Booklist"));
        XmlNode listNode = NodeFactory.createNode("div");
        listNode.addAttribute("id", "book-list");
        docNode.getChild("body").addChild(listNode);
        for (BookDocument book : doc) {
            XmlNode entry = NodeFactory.createNode("div");
            entry.addAttribute("class", "book-entry");
            listNode.addChild(entry);
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
        return "<!DOCTYPE html>\n" + docNode.toString();
    }

    private XmlNode addRow(String label, Long content) {
        return addRow(label, String.valueOf(content));
    }

    private XmlNode addRow(String label, Integer content) {
        return addRow(label, String.valueOf(content));
    }

    private XmlNode addRow(String label, StringBuilder content) {
        return addRow(label, content.toString());
    }

    private XmlNode addRow(String label, String content) {
        XmlNode row = NodeFactory.createNode("div");
        row.addAttribute("class", "row");
        row.addChild(NodeFactory.createNode("label", label + ":"));
        XmlNode field = NodeFactory.createNode("div", content);
        field.addAttribute("class", "field");
        row.addChild(field);
        return row;
    }

    private XmlNode addRow(String label, String[] content) {
        XmlNode row = NodeFactory.createNode("div");
        row.addAttribute("class", "row");
        row.addChild(NodeFactory.createNode("label", label + ":"));
        XmlNode field = NodeFactory.createNode("div");
        field.addAttribute("class", "field");
        for (String line : content) {
            field.addChild(NodeFactory.createNode("p", line));
        }
        row.addChild(field);
        return row;
    }

    private void writeId(BookDocument book, XmlNode entryNode) {
        if (book.getId() != null) {
            entryNode.addChild(addRow("ID", book.getId()));
        }
    }

    private void writeTitle(BookDocument book, XmlNode entryNode) {
        for (String title : book.getTitle().split("\n")) {
            entryNode.addChild(addRow("Title", title));
        }
    }

    private void writeAuthors(BookDocument book, XmlNode entryNode) {
        if (!book.getAuthors().isEmpty()) {
            book.getAuthors().stream().forEach((author) -> {
                entryNode.addChild(addRow("Author", author.getName()));
            });
        }
    }

    private void writeNumberOfVolumes(BookDocument book, XmlNode entryNode) {
        if (book.getNumberOfVolumes() > 1) {
            entryNode.addChild(addRow("# of Volumes", book.getNumberOfVolumes()));
        }
    }

    private void writePublished(BookDocument book, XmlNode entryNode) {
        StringBuilder published = new StringBuilder();
        if (book.getPlaceOfPublication() != null) {
            published.append(book.getPlaceOfPublication());
            if (book.getYearOfPublication() != null || book.getPublisher() != null) {
                published.append(" - ");
            }
        }
        if (book.getYearOfPublication() != null) {
            published.append(book.getYearOfPublication());
            if (book.getPublisher() != null) {
                published.append(" - ");
            }
        }
        if (book.getPublisher() != null) {
            published.append(book.getPublisher());
        }
        if (!published.toString().isEmpty()) {
            entryNode.addChild(addRow("Published", published));
        }
    }

    private void writeLanguage(BookDocument book, XmlNode entryNode) {
        if (book.getLanguage() != null) {
            entryNode.addChild(addRow("Language", book.getLanguage()));
        }
    }

    private void writeSubjects(BookDocument book, XmlNode entryNode) {
        if (book.getSubject() != null) {
            for (String subjects : book.getSubject().split("\n")) {
                entryNode.addChild(addRow("Subject", subjects));
            }
        }
    }

    private void writeDescription(BookDocument book, XmlNode entryNode) {
        if (book.getDescription() != null) {
            XmlNode row = addRow("Description", book.getDescription().split("\n"));
            row.addAttribute("class", "row multiline");
            entryNode.addChild(row);
        }
    }

    private void writeNotes(BookDocument book, XmlNode entryNode) {
        if (book.getNotes() != null) {
            XmlNode row = addRow("Notes", book.getNotes().split("\n"));
            row.addAttribute("class", "row multiline");
            entryNode.addChild(row);
        }
    }

    private XmlNode createHead(String title) {
        XmlNode headNode = NodeFactory.createNode("head");
        headNode.addChild(NodeFactory.createNode("title", title));
        XmlNode encoding = NodeFactory.createNode("meta");
        encoding.addAttribute("http-equiv", "Content-Type");
        encoding.addAttribute("content", "text/html; charset=utf-8");
        headNode.addChild(encoding);
        headNode.addChild(NodeFactory.createNode("style", getCss()));
        return headNode;
    }

    private XmlNode createBody(String title) {
        XmlNode bodyNode = NodeFactory.createNode("body");
        bodyNode.addChild(NodeFactory.createNode("h1", title));
        return bodyNode;
    }

    private String getCss() {
        return "\n"
                + "body {\n"
                + "    background-color: white;\n"
                + "    font-family: serif;\n"
                + "}\n"
                + "h1 {\n"
                + "    text-align: center;\n"
                + "    font-size: 30px;\n"
                + "}\n"
                + "div#book-list {\n"
                + "    margin-bottom: 1.8em;\n"
                + "}\n"
                + "div.book-entry {\n"
                + "    margin: 0;\n"
                + "    padding: 0.5em 0;\n"
                + "}\n"
                + "div.book-entry:nth-child(odd) {\n"
                + "    background-color: #F6F6F6;\n"
                + "}\n"
                + "div.row label {\n"
                + "    font-weight: bold;\n"
                + "    display: inline-block;\n"
                + "    text-align: right;\n"
                + "    padding-right: 18px;\n"
                + "    width: 160px;\n"
                + "    height: 21px;\n"
                + "}\n"
                + "div.multiline label {\n"
                + "    height: auto;\n"
                + "    vertical-align: top;\n"
                + "}\n"
                + "div.row div.field {\n"
                + "    display: inline-block;\n"
                + "    width: 600px;\n"
                + "    height: 21px;\n"
                + "    display: inline-block;\n"
                + "}\n"
                + "div.multiline div.field {\n"
                + "    height: auto;\n"
                + "}\n"
                + "div.multiline div.field p {\n"
                + "    margin: 0 0 0.4em 0;\n"
                + "}\n"
                + "";
    }

}
