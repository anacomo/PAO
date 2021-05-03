package IO;

import Library.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Output {
    private static Output instance = null;

    public static Output getInstance() {
        if (instance == null)
            instance = new Output();
        return instance;
    }

    // * user audit
    public static void userAudit(String operationType) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/audit.csv", true))) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            out.write(operationType + ", " + timestamp.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add Author on CSV
    public static void writeAuthorOnCsv(Author author) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/authors.csv", true))) {
            out.write(author.getFirstName() + ", " + author.getLastName() + ", " + author.getBirthday().getDayOfMonth() + ", " + author.getBirthday().getMonthValue() + ", " + author.getBirthday().getYear() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add Book to CSV
    public static void writeBookToCsv(Book book) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/books.csv", true))) {
            out.write(book.getTitle() + ", " + book.getAuthor().getFirstName() + ", " + book.getAuthor().getLastName() + ", " + book.getAuthor().getBirthday().getDayOfMonth() + ", " + book.getAuthor().getBirthday().getMonthValue() + ", " + book.getAuthor().getBirthday().getYear() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add Reader to CSV
    public static void writeReaderOnCsv(Reader reader) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/readers.csv", true))) {
            out.write(reader.getFirstName() + ", " + reader.getLastName() + ", " + reader.getBirthday().getDayOfMonth() + ", " + reader.getBirthday().getMonthValue() + ", " + reader.getBirthday().getYear() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add Section to CSV
    public static void writeSectionOnCsv(Section section) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/sections.csv", true))) {
            out.write(section.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add Student on CSV
    public static void writeStudentOnCsv(Student student) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/students.csv", true))) {
            out.write(student.getFirstName() + ", " + student.getLastName() + ", " + student.getBirthday().getDayOfMonth() + ", " + student.getBirthday().getMonthValue() + ", " + student.getBirthday().getYear() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // * add University to CSV
    public static void writeUniversityOnCsv(University university) {
        try (var out = new BufferedWriter(new FileWriter("src/IO/universities.csv", true))) {
            out.write(university.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
