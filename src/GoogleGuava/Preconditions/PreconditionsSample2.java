package GoogleGuava.Preconditions;

import static com.google.common.base.Preconditions.*;
import static com.google.common.collect.Lists.newArrayList;

public class PreconditionsSample2 {
    public static void main(String[] args) {
        checkNotNull(1, "can't be null");
        checkArgument(true, "False statement causes exception");
        System.out.println(checkElementIndex(2, new Integer[]{0, null, 1}.length, "Return first param if array size is > this param"));
        System.out.println(checkPositionIndex(3, newArrayList(0,null ,1).size(), "Return first param if array size is >= this param"));
        checkState(true , "Cannot perform when false");

    }
}
