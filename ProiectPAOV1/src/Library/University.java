package Library;

public class University {
    private String name;
    private Person dean;
    private int year;

    public University(String name) {
        this.name = name;
    }

    public University (String name, Person dean, int year) {
        this.name = name;
        this.dean = dean;
        this.year = year;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", dean=" + dean +
                ", year=" + year +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
