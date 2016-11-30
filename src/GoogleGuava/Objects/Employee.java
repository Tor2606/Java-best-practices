package GoogleGuava.Objects;

import com.google.common.base.Objects;

public class Employee {
    public enum Gender {FEMALE, MALE}

    ;
    private final String lastName;
    private final String firstName;
    private final String employerName;
    private final Gender gender;

    public Employee(String lastName, String firstName, String employerName, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.employerName = employerName;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.employerName, this.firstName, this.lastName, this.gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Employee other = (Employee) obj;
        return Objects.equal(this.lastName, other.lastName)&&Objects.equal(this.firstName, other.firstName)&&Objects.equal(this.employerName, other.employerName)
                &&Objects.equal(this.gender, other.gender);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).addValue(this.lastName).addValue(this.firstName).addValue(this.gender).toString();
    }
}
