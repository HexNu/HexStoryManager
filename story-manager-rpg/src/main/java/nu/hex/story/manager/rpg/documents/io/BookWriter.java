package nu.hex.story.manager.rpg.documents.io;

import nu.hex.story.manager.rpg.documents.Book;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class BookWriter extends AbstractWriter<Book> {

    public BookWriter(Book content) {
        super(content);
    }

    @Override
    public String write() {
        StringBuilder result = new StringBuilder();
        if (doc.getTitle() != null && !doc.getTitle().isEmpty()) {
            writeId(result);
            writeTitle(result);
            writeAuthors(result);
            writeNumberOfVolumes(result);
            writePublishing(result);
            writeLanguage(result);
            writeSubjects(result);
            writeDescription(result);
            writeNotes(result);
        }
        return result.toString();
    }

    private void writeId(StringBuilder result) {
        if (doc.getId() != null) {
            result.append("id: ").append(doc.getId()).append("\n");
        }
    }

    private void writeTitle(StringBuilder result) {
        String[] titles = doc.getTitle().split("\n");
        for (String t : titles) {
            result.append("title: ").append(t).append("\n");
        }
    }

    private void writeAuthors(StringBuilder result) {
        if (!doc.getAuthors().isEmpty()) {
            doc.getAuthors().stream().forEach((author) -> {
                result.append("author: ").append(author.getName()).append("\n");
            });
        }
    }

    private void writeNumberOfVolumes(StringBuilder result) {
        if (doc.getNumberOfVolumes() > 1) {
            result.append("volumes: ").append(doc.getNumberOfVolumes()).append("\n");
        }
    }

    private void writePublishing(StringBuilder result) {
        StringBuilder publishing = new StringBuilder();
        publishing.append("publishing: ");
        if (doc.getPlaceOfPublication() != null) {
            publishing.append(doc.getPlaceOfPublication());
            if (doc.getYearOfPublication() != null || doc.getPublisher() != null) {
                publishing.append(" - ");
            }
        }
        if (doc.getYearOfPublication() != null) {
            publishing.append(doc.getYearOfPublication());
            if (doc.getPublisher() != null) {
                publishing.append(" - ");
            }
        }
        if (doc.getPublisher() != null) {
            publishing.append(doc.getPublisher());
        }
        if (!publishing.toString().endsWith(": ")) {
            result.append(publishing.toString()).append("\n");
        }
    }

    private void writeLanguage(StringBuilder result) {
        if (doc.getLanguage() != null) {
            result.append("language: ").append(doc.getLanguage()).append("\n");
        }
    }

    private void writeSubjects(StringBuilder result) {
        if (doc.getSubject() != null) {
            String[] subj = doc.getSubject().split("\n");
            for (String sub : subj) {
                result.append("subject: ").append(sub).append("\n");
            }
        }
    }

    private void writeDescription(StringBuilder result) {
        if (doc.getDescription() != null) {
            result.append("description: ").append(doc.getDescription()).append("\n");
        }
    }

    private void writeNotes(StringBuilder result) {
        if (doc.getNotes() != null) {
            result.append("notes: ").append(doc.getNotes()).append("\n");
        }
    }
}
