package ToStringBuilder;

import java.util.Objects;

public class EmployeeForToStringBuilder extends PersonForToStringBuilder {

    private final String employeeId;

    public EmployeeForToStringBuilder(final String newLastName, final String newFirstName, final String newId) {
        super(newLastName, newFirstName);
        this.employeeId = newId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        final EmployeeForToStringBuilder other = (EmployeeForToStringBuilder) o;
        if(!Objects.equals(this.employeeId, other.employeeId)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19*hash + Objects.hashCode(this.employeeId);
        return hash;
    }
}
