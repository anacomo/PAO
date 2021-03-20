package Library;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends Reader{
    private University university;
    public Student (String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);
    }

    public Student (String firstName, String lastName, LocalDate birthday, University university) {
        super(firstName, lastName, birthday);
        this.university = university;
    }

    public Student (String firstName, String lastName, LocalDate birthday, LocalDate registrationDate) {
        super(firstName, lastName, birthday, registrationDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", university='" + university + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university);
    }

    public String getUniversity() {
        return university.getName();
    }

    public void setUniversity(University institution) {
        this.university = institution;
    }

}
