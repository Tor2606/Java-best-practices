package Cloning.ShallowCloning;

public class ShallowCloningSample {
    public static void main(String[] args) throws CloneNotSupportedException {
        University university1 = new University("kpi");
        Student student = new Student(university1);
        Student studentClone = (Student) student.clone();
        System.out.println(student);
        System.out.println(student.getUniversity());
        System.out.println(studentClone);
        System.out.println(studentClone.getUniversity());
        System.out.println("Same university: " + (student.getUniversity()==studentClone.getUniversity()));
    }
}
