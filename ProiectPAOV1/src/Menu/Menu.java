package Menu;

import Library.*;
import Service.*;

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
        AuthorService as = AuthorService.getInstance();
        as.addAuthor(new Author("Anna", "Todd"));
        as.showAuthors();
        SectionService ss = SectionService.getInstance();
        ss.addSection(new Section("Romance"));
        ss.addSection(new Section("Travel"));
        ss.showSections();
        UniversityService us = UniversityService.getInstance();
        us.addUniversity(new University("University of Bucharest"));
        us.showUniversities();
    }
}
