package ToStringBuilder;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonForToStringBuilder {
    protected final String lastName;
    protected final String firstName;

    public PersonForToStringBuilder(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("First Name", this.firstName);
        builder.append("Last Name", this.lastName);
        return builder.toString();
    }
}
