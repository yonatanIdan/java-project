import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<person> people = new ArrayList<>();

//        people.add(new Teacher(333,"yonatan", "idan", Status.married, 15325));
//
//        people.add(new Student(123,"niv", "chen", Status.single, new ArrayList<>()));

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
                    person teacher = helper.addPerson();
                    System.out.print("Enter wage: ");
                    int wage = in.nextInt();
                    System.out.println("add " + new Teacher(teacher.id,teacher.firstName, teacher.lastName, teacher.status, wage));
                    people.add(new Teacher(teacher.id,teacher.firstName, teacher.lastName, teacher.status, wage));
                } break;
                case 2: {
                    person student = helper.addPerson();
                    System.out.println("add " + new Student(student.id, student.firstName, student.lastName, student.status));
                    people.add(new Student(student.id, student.firstName, student.lastName, student.status));
                } break;
                case 3: {
                    for (person person : people) {
                        System.out.println(person.toString());
                    }
                } break;
                case 4: {
                    for (person person : people) {
                        if (person instanceof Teacher){
                            System.out.println((Teacher)person);
                        }
                    }
                } break;
                case 5: {
                    for (person person : people) {
                        if (person instanceof Student){
                            System.out.println((Student)person);
                        }
                    }
                } break;
                case 6: {
                    System.out.print("please write the ID of Teacher: ");
                    int id = in.nextInt();
                    for (int i = 0; i < people.size(); i++) {
                        if (people.get(i).id == id){
                            if (people.get(i) instanceof Teacher) {
                                System.out.println((Teacher) people.get(i));
                            } else {
                                System.out.println("Not a Teacher");
                            } break;
                        }
                        if(i == people.size()-1) {System.out.println("Doesn't exists"); break;}
                    }
                } break;
                case 7: {
                    System.out.print("please write the ID of Student: ");
                    int id = in.nextInt();
                    for (int i = 0; i < people.size(); i++) {
                        person person = people.get(i);
                        if (person.id == id) {
                            if (person instanceof Student) {
                                System.out.println((Student) person);
                                boolean running = true;
                                while (running) {
                                    System.out.println(
                                            "Menu:\n" +
                                                    "-----\n" +
                                                    "A) Show All Scores\n" +
                                                    "B) Insert a new Score\n" +
                                                    "C) Show Average Score\n" +
                                                    "D) Remove Score by Index\n" +
                                                    "E) Return to the main menu\n"
                                    );
                                    System.out.print("Enter Option:");
                                    String MenuB = in.next().toUpperCase(Locale.ROOT);
                                    switch (MenuB) {
                                        case "A": {
                                            if (((Student) person).scores.size() > 0) {
                                                for (int n = 0; n < ((Student) person).scores.size(); n++) {
                                                    System.out.println(n + ") " + ((Student) person).scores.get(n));
                                                }
                                            } else System.out.println("Its a empty list");
                                        }
                                        break;
                                        case "B": {
                                            System.out.println("which course do you want to add? ");
                                            String course = in.next();
                                            System.out.println("what is the score? ");
                                            int score = in.nextInt();
                                            ((Student) person).addScore(course, score);
                                        }
                                        break;
                                        case "C": {
                                            if (((Student) person).scores.size() > 0) {
                                                System.out.println("the Average Score is: " + ((Student) person).getAverageScore());
                                            } else System.out.println("Its a empty list");
                                        }
                                        break;
                                        case "D": {
                                            if (((Student) person).scores.size() > 0){
                                                System.out.println("choose by index to remove score: ");
                                                int index = in.nextInt();
                                                ((Student) person).scores.remove(index);
                                            }
                                        }
                                        break;
                                        case "E":
                                            running = false;
                                            break;
                                        default:
                                            System.out.println("Error: Invalid Option Number!");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Not a Student");
                            } break;
                        }
                        if(i == people.size()-1) {
                            System.out.println("Doesn't exists");
                            break;
                        }
                    }
                } break;
                case 8: {
                    System.out.print("enter min score: ");
                    int minScore = in.nextInt();
                    System.out.print("enter max score: ");
                    int maxScore = in.nextInt();
                    for (person person : people){
                        if (person instanceof Student){
                            for (int i = 0; i < ((Student)person).scores.size(); i++){
                                if (((Student)person).scores.get(i).value >= minScore &&
                                        ((Student)person).scores.get(i).value <= maxScore){
                                    System.out.println(person +" "+ ((Student)person).scores.get(i));
                                }
                            }
                        }
                    }
                } break;
                case 0: System.out.println("Quitting...");  return;
                default: System.out.println("Error: Invalid Option Number!");
            }
        }
    }
}
