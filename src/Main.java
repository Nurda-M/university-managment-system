public class Main {
    public static void main(String[] args) {
        // Создание объектов университета [cite: 9]
        University myUni = new University("Astana IT University", "Astana");
        myUni.displayWelcome();

        Professor prof1 = new Professor("Иван Иванов", "PhD", "Computer Science");
        Professor prof2 = new Professor("Иван Иванов", "PhD", "Mathematics");
        Professor prof3 = new Professor("Аскар Смаков", "Master", "Physics");

        Course javaCourse = new Course("Java Programming", 5);

        System.out.println(prof1.getInfo());
        System.out.println(prof3.getInfo());
        System.out.println(javaCourse.toString());

        System.out.println("\n--- Сравнение профессоров ---");
        if (prof1.equals(prof2)) {
            System.out.println("Профессор 1 и Профессор 2 идентичны (по имени и степени).");
        } else {
            System.out.println("Профессора разные.");
        }

        if (prof1.equals(prof3)) {
            System.out.println("Профессор 1 и Профессор 3 идентичны.");
        } else {
            System.out.println("Профессор 1 и Профессор 3 — это разные люди.");
        }
    }
}