import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

enum Status {
    single,
    married,
    divorcee
}

class person{
    int id;
    String firstName, lastName;
    Status status;

    public person(int id, String firstName, String lastName, Status status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                '}';
    }
}

class Teacher extends person{
    int wage;

    public Teacher(int id, String firstName, String lastName, Status status, int wage) {
        super(id, firstName, lastName, status);
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", wage=" + wage +
                '}';
    }
}

class Student extends person{
    ArrayList<Score> scores;

    public Student(int id, String firstName, String lastName, Status status, ArrayList<Score> scores) {
        super(id, firstName, lastName, status);
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", scores=" + scores.toString() +
                ", Average Score=" + getAverageScore() +
                '}';
    }

    public int getAverageScore(){
        int avg = 0, count = 0;
        for (Score score : scores) {
            avg += score.value;
            count++;
        }
        avg = avg / count;
        return avg;
    }
}
class Score{
    String course;
    int value;

    public Score(String course, int value) {
        this.course = course;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Score{" +
                "course='" + course + '\'' +
                ", value=" + value +
                '}';
    }
}
public class program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Teacher> Teachers = new ArrayList<Teacher>();

        Teacher yonatan = new Teacher(3,"yonatan", "idan", Status.married, 15325);
        System.out.println(yonatan);

        ArrayList<Score> array = new ArrayList<Score>();
        array.add(new Score("math", 55));
        array.add(new Score("math", 99));
        Student yaniv = new Student(3,"yaniv", "chen", Status.single, array);
        System.out.println(yaniv);

        while (true) {
            System.out.println(
                    "Menu:\n" +
                            "-----\n" +
                            "1) Add Teacher\n" +
                            "2) Add Student\n" +
                            "3) Show All People\n" +
                            "4) Show All Teachers\n" +
                            "5) Show All Students\n" +
                            "6) Print Teacher By ID\n" +
                            "7) Show Student By ID and check Scores\n" +
                            "8) Show Students By Score Range\n" +
                            "0) Quit\n"
            );
            System.out.print("Enter Option Number:");
            int MenuA = in.nextInt();

            switch (MenuA) {
                case 1: {
                    System.out.println("Enter ID: ");
                    int ID = in.nextInt();
                    System.out.println("Enter first name: ");
                    String firstName = in.next();
                    System.out.println("Enter last name: ");
                    String lastName = in.next();
                    System.out.println(
                            "Status:\n" +
                                    "-----\n" +
                                    "1) single\n" +
                                    "2) married\n" +
                                    "3) divorcee\n"
                    );
                    int statusCase = in.nextInt();
                    Status status;
                    switch (statusCase) {
                        case 1: status = Status.single;
                        case 2: status = Status.married;
                        case 3: status = Status.divorcee;
                        default: status = Status.single;
                    }
                    System.out.println("Enter wage: ");
                    int wage = in.nextInt();
                    Teachers.add(new Teacher(ID,firstName, lastName, status, wage));
                }; break;
                case 2: System.out.println("Action Two"); break;
                case 3: System.out.println("Action Three"); break;
                case 4: System.out.println("Action Three"); break;
                case 5: System.out.println("Action Three"); break;
                case 6: System.out.println("Action Three"); break;
                case 7: {
                    System.out.println(
                            "Menu:\n" +
                                    "-----\n" +
                                    "A) Show All Scores\n" +
                                    "B) Insert a new Score\n" +
                                    "C) Show Average Score\n" +
                                    "D) Remove Score by Index\n" +
                                    "E) Return to the main menu\n"
                    );
                    System.out.print("Enter Option Number:");
                    String MenuB = in.next().toUpperCase(Locale.ROOT);
                    switch (MenuB) {
                        case "A":
                            System.out.println("Action One");
                            break;
                        case "B":
                            System.out.println("Action Two");
                            break;
                        case "C":
                            System.out.println("Action Three");
                            break;
                        case "D":
                            System.out.println("Action Three");
                            break;
                        case "E":
                            System.out.println("Action Three");
                            break;
                        default:
                            System.out.println("Error: Invalid Option Number!");
                            break;
                    }
                } break;
                case 8: System.out.println("Action Three"); break;
                case 0: System.out.println("Quitting...");  return;
                default: System.out.println("Error: Invalid Option Number!");
            }
        }
    }
}
