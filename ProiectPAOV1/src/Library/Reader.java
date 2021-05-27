package Library;

import java.time.LocalDate;
import java.util.Objects;

public class Reader extends Person{
    LocalDate registrationDate;

    public Reader (String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);
        this.registrationDate = LocalDate.now();
    }

    public Reader (String firstName, String lastName, LocalDate birthday, LocalDate registrationDate) {
        super(firstName, lastName, birthday);
        this.registrationDate = registrationDate;
    }

    public Reader(Reader reader) {
        super(reader);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(firstName, reader.firstName) && Objects.equals(lastName, reader.lastName) && Objects.equals(birthday, reader.birthday);
    }

}
