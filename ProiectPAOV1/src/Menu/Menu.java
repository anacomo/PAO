package Menu;

import Library.Author;
import Library.Book;
import Library.Reader;
import Service.BookService;
import Service.ReaderService;

import java.time.LocalDate;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ReaderService rs = ReaderService.getInstance();
        rs.addReader(new Reader("Ana-Maria", "Comorasu", LocalDate.of(2000, 5, 26)));
        rs.showReaders();
        BookService bs = BookService.getInstance();
        bs.addBook(new Book("How I met your Mother", new Author("Ted", "Moseby"), LocalDate.of(2020, 3, 1)));
        bs.showBooks();
    }
}
