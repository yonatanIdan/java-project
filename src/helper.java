import java.util.ArrayList;
import java.util.Scanner;

public class helper {
    public static person addPerson(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int ID = in.nextInt();
        System.out.print("Enter first name: ");
        String firstName = in.next();
        System.out.print("Enter last name: ");
        String lastName = in.next();
        System.out.print(
                            "Status:\n" +
                            "-----\n" +
                            "1) single\n" +
                            "2) married\n" +
                            "3) divorcee\n"
                            );
        int statusCase = in.nextInt();
        Status status;
        switch (statusCase) {
            case 2: status = Status.married; break;
            case 3: status = Status.divorcee; break;
            default: status = Status.single; break;
        }
        return new person(ID, firstName, lastName, status);
    }
}
