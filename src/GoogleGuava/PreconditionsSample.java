package GoogleGuava;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Created by islabukhin on 04.10.16.
 */
public class PreconditionsSample {
    //Most classes have restrictions on values given them in constructor and methods.
    // Invalid values should be escalated as soon as possible by doing explicit validity
    // checks before execution. It is a lot better to fail-fast than to fail later with an
    // unexpected exception or worse, silently compute the wrong result.
    private String id;
    private String name;

    @Override
    public String toString() {
        return Objects.toStringHelper(PreconditionsSample.class).add("id", id).add("name", name).toString();
    }

    public PreconditionsSample(String id, String name) {
        this.id = Preconditions.checkNotNull(id, "id must not be null");
        this.name = Preconditions.checkNotNull(name, "name must not be null");
        Preconditions.checkArgument(name.length() > 6, "name must be longer than 6 chars");


    }

    public static void main(String[] args) {
        PreconditionsSample preconditionsSample = new PreconditionsSample(null, "nameeee");
        System.out.println(preconditionsSample.toString());
    }
}
