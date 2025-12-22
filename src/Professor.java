import java.util.Objects;

public class Professor {
    private String name;
    private String degree;
    private String department;

    public Professor(String name, String degree, String department) {
        this.name = name;
        this.degree = degree;
        this.department = department;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getInfo() {
        return "Профессор: " + name + ", Степень: " + degree + ", Кафедра: " + department;
    }

}