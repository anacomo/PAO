package Service;

import IO.Output;
import Library.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    private List<Student> studentList;
    private static StudentService instance = null;

    private StudentService() {
        studentList = new ArrayList<>();
    }

    public static StudentService getInstance() {
        if (instance == null)
            instance = new StudentService();
        return instance;
    }

    public void addStudent(Student student, boolean csv) {
        boolean exists = false;
        for (Student s : studentList)
            if (s.equals(student)) {
                exists = true;
                break;
            }
        if (!exists) {
            studentList.add(new Student(student));
            if (!csv)
            {
                Output.writeStudentOnCsv(student);
                Output.userAudit("Add Student");
            }
            sortStudents();
        }
    }

    private void sortStudents() {
        Collections.sort(studentList);
    }

    public void showStudents() {
        for (Student s : studentList)
            System.out.println(s.toString());
    }
}
