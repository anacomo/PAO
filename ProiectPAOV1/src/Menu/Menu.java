package Menu;

import IO.Input;
import IO.Output;
import Library.*;
import Service.*;

import java.time.LocalDate;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Input.readAuthorsFromCsv();
        Input.readReadersFromCsv();
        Input.readBooksFromCsv();
        Input.readSectionsFromCsv();
        Input.readStudentsFromCsv();
        Input.readUniversitiesFromCsv();

        ReaderService rs = ReaderService.getInstance();
        rs.addReader(new Reader("Ana-Maria", "Comorasu", LocalDate.of(2000, 5, 26)), false);
//        rs.showReaders();

        BookService bs = BookService.getInstance();
        bs.addBook(new Book("HowImetyourMother", new Author("Ted", "Moseby", LocalDate.of(2004, 7, 21)), LocalDate.of(2020, 3, 1)), false);
//        bs.showBooks();

        AuthorService as = AuthorService.getInstance();
        as.addAuthor(new Author("Anna", "Todd", LocalDate.of(1980, 4, 29)), false);
//        as.showAuthors();

        SectionService ss = SectionService.getInstance();
        ss.addSection(new Section("Drama"), false);
//        ss.showSections();

        StudentService sts = StudentService.getInstance();
        sts.addStudent(new Student("Draco", "Malfoy", LocalDate.of(2000, 10, 10)), false);
//        sts.showStudents();

        UniversityService us = UniversityService.getInstance();
        us.addUniversity(new University("University of Bristol"), false);
//        us.showUniversities();

    }
}
