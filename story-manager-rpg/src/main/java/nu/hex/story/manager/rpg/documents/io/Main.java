package nu.hex.story.manager.rpg.documents.io;

import java.io.IOException;
import java.util.List;
import nu.hex.story.manager.rpg.documents.Book;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Book> books = new BooksReader("/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").read();
//        new FileWriter(new BooksWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.srb").write();
        new FileWriter(new BooksHtmlWriter(books).write(), "/home/hl/Dokument/RPG/Angelina Blight/docs/Books.hsrb").write();

    }
}
