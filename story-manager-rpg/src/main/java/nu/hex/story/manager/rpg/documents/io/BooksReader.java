package nu.hex.story.manager.rpg.documents.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nu.hex.story.manager.rpg.documents.Book;

public class BooksReader implements DocumentReader<List<Book>> {

    private final List<String> lines;

    public BooksReader(String path) throws IOException {
        this.lines = Files.readAllLines(new File(path).toPath());
    }

    public BooksReader(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public List<Book> read() {
        List<Book> result = new ArrayList<>();
        Book book = new Book();
        result.add(book);
        String field = "";
        for (String line : lines) {
            if (line.contains(":")) {
                field = getField(line);
            } else if (line.isEmpty()) {
                book = new Book();
                result.add(book);
            }
            switch (field) {
                case "":
                    break;
                case "id":
                    if (!line.isEmpty()) {
                        book.setId(getValueAsLong(line));
                    }
                    break;
                case "volumes":
                    if (!line.isEmpty()) {
                        book.setVolumes(getValueAsInteger(line));
                    }
                    break;
                case "title":
                    if (!line.isEmpty()) {
                        book.appendTitle(getValue(line));
                    }
                    break;
                case "author":
                    if (!line.isEmpty()) {
                        String value = getValue(line);
                        if (value.contains(",")) {
                            book.addAuthor(value.split(",")[1].trim(), value.split(",")[0].trim());
                        } else if (value.contains(" ")) {
                            book.addAuthor(value.split(" ")[0].trim(), value.split(" ")[1].trim());
                        } else {
                            book.addAuthor(null, value);
                        }
                    }
                    break;
                case "language":
                    if (!line.isEmpty()) {
                        book.setLanguage(getValue(line));
                    }
                    break;
                case "publishing-place":
                    if (!line.isEmpty()) {
                        book.setPlaceOfPublication(getValue(line));
                    }
                    break;
                case "publishing-year":
                    if (!line.isEmpty()) {
                        book.setYearOfPublication(getValueAsInteger(line));
                    }
                    break;
                case "published":
                    if (!line.isEmpty()) {
                        if (getValue(line).matches("\\d*")) {
                            book.setYearOfPublication(getValueAsInteger(line));
                        } else {
                            String[] pub = getValue(line).split(" - ");
                            if (pub.length < 1) {
                                break;
                            }
                            book.setPlaceOfPublication(pub[0]);
                            if (pub.length < 2) {
                                break;
                            }
                            book.setYearOfPublication(Integer.valueOf(pub[1]));
                            if (pub.length < 3) {
                                break;
                            }
                            book.setPublisher(pub[2]);
                        }
                    }
                    break;
                case "subject":
                    if (!line.isEmpty()) {
                        book.appendSubject(getValue(line));
                    }
                    break;
                case "description":
                    if (!line.isEmpty()) {
                        if (book.getDescription() != null && !book.getDescription().isEmpty()) {
                            book.appendDescription("\n");
                        }
                        book.appendDescription(getValue(line));
                    }
                    break;
                case "notes":
                    if (!line.isEmpty()) {
                        if (book.getNotes() != null && !book.getNotes().isEmpty()) {
                            book.appendNotes("\n");
                        }
                        book.appendNotes(getValue(line));
                    }
                    break;
            }
        }
        for (Iterator<Book> it = result.iterator(); it.hasNext();) {
            Book b = it.next();
            if (b.getTitle() == null || b.getTitle().isEmpty()) {
                it.remove();
            }
        }
        return result;
    }

    protected String getValue(String line) {
        return line.substring(line.indexOf(":") + 1).trim();
    }

    protected Long getValueAsLong(String line) {
        return Long.valueOf(getValue(line));
    }

    protected Integer getValueAsInteger(String line) {
        return Integer.valueOf(getValue(line));
    }

    protected String getField(String line) {
        return line.substring(0, line.indexOf(":"));
    }

    public static void main(String[] args) throws IOException {
        List<Book> books = new BooksReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").read();
//        new FileWriter(new BooksWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").write();
        new FileWriter(new BooksHtmlWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.hsrb").write();
    }
}
