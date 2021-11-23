import java.util.ArrayList;

public class Student extends person {
    ArrayList<Score> scores;

    public Student(int id, String firstName, String lastName, Status status, ArrayList<Score> scores) {
        super(id, firstName, lastName, status);
        this.scores = scores;
    }
    public Student(int id, String firstName, String lastName, Status status) {
        super(id, firstName, lastName, status);
        this.scores = new ArrayList<Score>();
    }

    public void addScore(String course, int value){
        this.scores.add(new Score(course, value));
    }

    @Override
    public String toString() {
        return "Student:" +
                "ID=" + id +
                ", First Name=" + firstName +
                ", Last Name=" + lastName +
                ", Status=" + status + ".";
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
