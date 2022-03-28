package nu.hex.story.manager.rpg.documents.io.write;

import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.rpg.documents.BookDocument;
import nu.hex.story.manager.rpg.documents.io.AbstractWriter;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class BooksWriter extends AbstractWriter<List<BookDocument>, String> {

    public BooksWriter(List<BookDocument> doc) {
        super(doc);
    }

    public BooksWriter(BookDocument book) {
        super(Arrays.asList(book));
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        for (BookDocument book : doc) {
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

    private void writeId(BookDocument book, StringBuilder result) {
        if (book.getId() != null) {
            result.append("id: ").append(book.getId()).append("\n");
        }
    }

    private void writeTitle(BookDocument book, StringBuilder result) {
        String[] titles = book.getTitle().split("\n");
        for (String t : titles) {
            result.append("title: ").append(t).append("\n");
        }
    }

    private void writeAuthors(BookDocument book, StringBuilder result) {
        if (!book.getAuthors().isEmpty()) {
            book.getAuthors().stream().forEach((author) -> {
                result.append("author: ").append(author.getName()).append("\n");
            });
        }
    }

    private void writeNumberOfVolumes(BookDocument book, StringBuilder result) {
        if (book.getNumberOfVolumes() > 1) {
            result.append("volumes: ").append(book.getNumberOfVolumes()).append("\n");
        }
    }

    private void writePublished(BookDocument book, StringBuilder result) {
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

    private void writeLanguage(BookDocument book, StringBuilder result) {
        if (book.getLanguage() != null) {
            result.append("language: ").append(book.getLanguage()).append("\n");
        }
    }

    private void writeSubjects(BookDocument book, StringBuilder result) {
        if (book.getSubject() != null) {
            String[] subj = book.getSubject().split("\n");
            for (String sub : subj) {
                result.append("subject: ").append(sub).append("\n");
            }
        }
    }

    private void writeDescription(BookDocument book, StringBuilder result) {
        if (book.getDescription() != null) {
            result.append("description: ").append(book.getDescription()).append("\n");
        }
    }

    private void writeNotes(BookDocument book, StringBuilder result) {
        if (book.getNotes() != null) {
            result.append("notes: ").append(book.getNotes()).append("\n");
        }
    }
}
