package GoogleGuava.Throwables;

/**
 * Created by islabukhin on 04.10.16.
 */
public class ApiException extends Exception{

    public ApiException(String stackTraceAsString) {
        super(stackTraceAsString);
    }
}
