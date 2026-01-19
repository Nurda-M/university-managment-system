import java.util.Objects;

public abstract class Person implements Identifiable {
    private final String id;
    private String name;

    public Person(String id, String name) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public String getId() {
        return id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = Objects.requireNonNull(name); }

    public abstract String getSummary();

    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', name='" + name + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id.equals(person.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
