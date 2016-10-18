package ToStringBuilder;

public class ToStringBuilderRunner {
    public static void main(String[] args) {
        final PersonForToStringBuilder person = new PersonForToStringBuilder("Slabukhin", "Willow");
        System.out.println(person);
        final EmployeeForToStringBuilder employee = new EmployeeForToStringBuilder("Big", "Sam", "39");
        System.out.println(employee);

        final PersonForToStringBuilder person2 = new PersonForToStringBuilder("Bill", "Gates");
        System.out.println(person2);
        System.out.println("\tHash Code (ten): " + person2.hashCode());
        System.out.println("\tHash Code (hex): " + Integer.toHexString(person2.hashCode()));
        System.out.println("\t\tIdentity Hash (ten): " + System.identityHashCode(person2));
        System.out.println("\t\tIdentity Hash (hex): " + Integer.toHexString(System.identityHashCode(person2)));

        final EmployeeForToStringBuilder employee2 = new EmployeeForToStringBuilder("Lazen", "Frank", "56");
        System.out.println(employee2);
        System.out.println("\tHash Code (ten): " + employee2.hashCode());
        System.out.println("\tHash Code (hex): " + Integer.toHexString(employee2.hashCode()));
        System.out.println("\t\tIdentity Hash (ten): " + System.identityHashCode(employee2));
        System.out.println("\t\tIdentity Hash (hex): " + Integer.toHexString(System.identityHashCode(employee2)));

    }
}
