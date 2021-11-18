public class Score {
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
