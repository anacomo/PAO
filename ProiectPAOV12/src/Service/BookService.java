package Service;

import IO.Output;
import Library.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {
    private List<Book> bookList;
    private static BookService instance = null;

    private BookService() {
        bookList = new ArrayList<>();
    }
    public static BookService getInstance() {
        if(instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void addBook(Book book, boolean csv) {
        boolean exists = false;
        for(Book b : bookList)
            if (b.equals(book)) {
                exists = true;
                break;
            }
        if(!exists) {
            bookList.add(new Book(book));
            if (!csv) {
                Output.writeBookToCsv(book);
                Output.userAudit("Add Book");
            }
            sortBooks();
        }
    }

    private void sortBooks() {
        Collections.sort(bookList);
    }

    public void showBooks() {
        for(Book b : bookList)
            System.out.println(b.toString());
    }
}
