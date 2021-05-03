package Library;

import java.time.LocalDate;
import java.util.Objects;

public class Author extends Person {

    public Author (String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);
    }

    public Author (Author author) {
        super(author.getFirstName(), author.getLastName(), author.getBirthday());
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(birthday, author.birthday);
    }

}
