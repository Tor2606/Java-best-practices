package GoogleGuava.Throwables;

import com.google.common.base.Throwables;

import java.io.File;

/**
 * Created by islabukhin on 04.10.16.
 */
public class ThrowablesSample {
    // Wrapping the original exception object is not always appropriate, because it can cause
    // ClassNotFoundException in the client code if communication occur between unrelated class
    // loaders or if they are serialized on the wire. Throwables can decouple this dependency,
    // still allowing remote clients to see the stack trace by converting it to a string.
    public static void main(String[] args) throws ApiException {

        try{
            File file = new File("nonExistFile");
        }catch (Exception e){

            throw new ApiException(Throwables.getStackTraceAsString(e));
        }
    }
}
