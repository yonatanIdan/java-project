public class Teacher extends person{
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
