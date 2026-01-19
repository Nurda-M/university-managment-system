public class Main {
    public static void main(String[] args) {
        University myUni = new University("Astana IT University", "Astana");
        myUni.displayWelcome();

        Professor prof1 = new Professor("George Washington", "PhD", "Computer Science");
        Professor prof2 = new Professor("George Washington", "PhD", "Mathematics");
        Professor prof3 = new Professor("Adolf Hitler", "Master", "Physics");

        Course javaCourse = new Course("Java Programming", 5);

        System.out.println(prof1.getInfo());
        System.out.println(prof3.getInfo());
        System.out.println(javaCourse.toString());

        System.out.println("\nComparison of professors");
        if (prof1.equals(prof2)) {
            System.out.println("Professor 1 and Professor 2 are identical.");
        } else {
            System.out.println("Professors are different.");
        }

        if (prof1.equals(prof3)) {
            System.out.println("Professor 1 and Professor 3 are identical.");
        } else {
            System.out.println("Professor 1 and Professor 3 are different people.");
        }
    }
}