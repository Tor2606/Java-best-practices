package Cloning.ShallowCloning;

public class Student implements Cloneable {
    private University university;

    public Student(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
