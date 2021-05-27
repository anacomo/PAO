package IO;

import Library.*;
import Service.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Input {
    private static Input instance = null;

    private Input() {
    }

    public static Input getInstance() {
        if (instance == null)
            instance = new Input();
        return instance;
    }

    // * read Authors
    public static void readAuthorsFromCsv() {
        try(var in = new BufferedReader(new FileReader("src/IO/authors.csv"))){
            String line;
            AuthorService as = AuthorService.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.replaceAll(" ", "").split(",");
                as.addAuthor(new Author(fields[0], fields[1],
                        LocalDate.of(Integer.parseInt(fields[4]), Integer.parseInt(fields[3]), Integer.parseInt(fields[2]))),
                        true);
            }

//            System.out.println("\nList of Authors: \n");
//            as.showAuthors();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * read Readers
    public static void readReadersFromCsv() {
        try (var in = new BufferedReader(new FileReader("src/IO/readers.csv"))) {
            String line;
            ReaderService rs = ReaderService.getInstance();

            while ((line = in.readLine()) != null) {
                String [] fields = line.replaceAll(" ", "").split(",");
                rs.addReader(new Reader(fields[0], fields[1], LocalDate.of(Integer.parseInt(fields[4]), Integer.parseInt(fields[3]), Integer.parseInt(fields[2]))), true);
            }
//            System.out.println("\nList of Readers: \n");
//            rs.showReaders();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * read Books
    public static void readBooksFromCsv() {
        try (var in = new BufferedReader(new FileReader("src/IO/books.csv"))) {
            String line;
            BookService bs = BookService.getInstance();

            while ((line = in.readLine()) != null) {
                String [] fields = line.replaceAll(" ", "").split(",");
                bs.addBook(new Book(fields[0], new Author(fields[1], fields[2], LocalDate.of(Integer.parseInt(fields[5]), Integer.parseInt(fields[4]), Integer.parseInt(fields[3])))), true);
            }

//            System.out.println("\nList of Books: \n");
//            bs.showBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * read Sections
    public static void readSectionsFromCsv() {
        try (var in = new BufferedReader(new FileReader("src/IO/sections.csv"))) {
            String line;
            SectionService bs = SectionService.getInstance();

            while ((line = in.readLine()) != null) {
                String [] fields = line.replaceAll(" ", "").split(",");
                bs.addSection(new Section(fields[0]), true);
            }
//            System.out.println("\nList of Sections: \n");
//            bs.showSections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * read Students
    public static void readStudentsFromCsv() {
        try (var in = new BufferedReader(new FileReader("src/IO/students.csv"))) {
            String line;
            StudentService bs = StudentService.getInstance();

            while ((line = in.readLine()) != null) {
                String [] fields = line.replaceAll(" ", "").split(",");
                bs.addStudent(new Student(fields[0], fields[1], LocalDate.of(Integer.parseInt(fields[4]), Integer.parseInt(fields[3]), Integer.parseInt(fields[2]))), true);
            }
//            System.out.println("\nList of Students: \n");
//            bs.showStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * read University
    public static void readUniversitiesFromCsv() {
        try (var in = new BufferedReader(new FileReader("src/IO/universities.csv"))) {
            String line;
            UniversityService bs = UniversityService.getInstance();

            while ((line = in.readLine()) != null) {
                String [] fields = line.split(",");
                bs.addUniversity(new University(fields[0]), true);
            }

//            System.out.println("\nList of Universities: \n");
//            bs.showUniversities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
