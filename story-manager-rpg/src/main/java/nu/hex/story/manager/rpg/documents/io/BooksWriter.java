package nu.hex.story.manager.rpg.documents.io;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.Book;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class BooksWriter extends AbstractWriter<List<Book>> {

    public BooksWriter(List<Book> doc) {
        super(doc);
    }

    public BooksWriter(Book book) {
        super(Arrays.asList(book));
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        for (Book book : doc) {
            if (!result.toString().isEmpty()) {
                result.append("\n");
            }
            if (book.getTitle() != null && !book.getTitle().isEmpty()) {
                writeId(book, result);
                writeTitle(book, result);
                writeAuthors(book, result);
                writeNumberOfVolumes(book, result);
                writePublished(book, result);
                writeLanguage(book, result);
                writeSubjects(book, result);
                writeDescription(book, result);
                writeNotes(book, result);
            }
        }
        return result.toString();
    }

    private void writeId(Book book, StringBuilder result) {
        if (book.getId() != null) {
            result.append("id: ").append(book.getId()).append("\n");
        }
    }

    private void writeTitle(Book book, StringBuilder result) {
        String[] titles = book.getTitle().split("\n");
        for (String t : titles) {
            result.append("title: ").append(t).append("\n");
        }
    }

    private void writeAuthors(Book book, StringBuilder result) {
        if (!book.getAuthors().isEmpty()) {
            book.getAuthors().stream().forEach((author) -> {
                result.append("author: ").append(author.getName()).append("\n");
            });
        }
    }

    private void writeNumberOfVolumes(Book book, StringBuilder result) {
        if (book.getNumberOfVolumes() > 1) {
            result.append("volumes: ").append(book.getNumberOfVolumes()).append("\n");
        }
    }

    private void writePublished(Book book, StringBuilder result) {
        StringBuilder published = new StringBuilder();
        published.append("published: ");
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
        if (!published.toString().endsWith(": ")) {
            result.append(published.toString()).append("\n");
        }
    }

    private void writeLanguage(Book book, StringBuilder result) {
        if (book.getLanguage() != null) {
            result.append("language: ").append(book.getLanguage()).append("\n");
        }
    }

    private void writeSubjects(Book book, StringBuilder result) {
        if (book.getSubject() != null) {
            String[] subj = book.getSubject().split("\n");
            for (String sub : subj) {
                result.append("subject: ").append(sub).append("\n");
            }
        }
    }

    private void writeDescription(Book book, StringBuilder result) {
        if (book.getDescription() != null) {
            result.append("description: ").append(book.getDescription()).append("\n");
        }
    }

    private void writeNotes(Book book, StringBuilder result) {
        if (book.getNotes() != null) {
            result.append("notes: ").append(book.getNotes()).append("\n");
        }
    }
}
