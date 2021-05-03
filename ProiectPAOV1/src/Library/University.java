package Library;

import java.util.Objects;

public class University implements Comparable<University>{
    private String name;
    private Person dean;
    private int year;
    private float prestigeScore;

    public University(String name) {
        this.name = name;
    }

    public University(String name, Person dean, int year) {
        this(name, dean, year, 0);
    }

    public University(String name, Person dean, int year, float prestigeScore) {
        this.name = name;
        this.dean = dean;
        this.year = year;
        this.prestigeScore = prestigeScore;
    }

    public University(University university) {
        this.name = university.getName();
        this.dean = university.getDean();
        this.year = university.getYear();
        this.prestigeScore = university.getPrestigeScore();
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

    public Person getDean() {
        return dean;
    }

    public void setDean(Person dean) {
        this.dean = dean;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrestigeScore() {
        return prestigeScore;
    }

    public void setPrestigeScore(float prestigeScore) {
        this.prestigeScore = prestigeScore;
    }

    @Override
    public int compareTo(University o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University university = (University) o;
        return Objects.equals(name, university.name);
    }
}
