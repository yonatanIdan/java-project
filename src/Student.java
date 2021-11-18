import java.util.ArrayList;

public class Student extends person {
    ArrayList<Score> scores;

    public Student(int id, String firstName, String lastName, Status status, ArrayList<Score> scores) {
        super(id, firstName, lastName, status);
        this.scores = scores;
    }

    public void addScore(String course, int value){
        this.scores.add(new Score(course, value));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
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
