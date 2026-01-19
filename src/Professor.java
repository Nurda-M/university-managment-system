import java.util.Objects;

public class Professor extends Person {
    private String degree;
    private String department;

    public Professor(String id, String name, String degree, String department) {
        super(id, name);
        this.degree = degree;
        this.department = department;
    }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }


    public String getSummary() {
        return "Профессор: " + getName() + ", Степень: " + degree + ", Кафедра: " + department;
    }

    public String getInfo() {
        return getSummary();
    }

    @Override
    public String toString() {
        return "Professor{id='" + getId() + "', name='" + getName() + "', degree='" + degree + "', department='" + department + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Professor)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
