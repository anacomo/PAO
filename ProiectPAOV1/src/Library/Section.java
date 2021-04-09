package Library;

public class Section implements Comparable<Section>{
    private String name;

    public Section(String name) {
        this.name = name;
    }

    public Section (Section section) {
        this.name = section.getName();
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Section o) {
        return this.name.compareTo(o.getName());
    }
}
