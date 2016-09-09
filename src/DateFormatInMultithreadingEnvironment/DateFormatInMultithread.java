package DateFormatInMultithreadingEnvironment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by islabukhin on 09.09.16.
 */
public class DateFormatInMultithread {


    //slowly for multithreading
    public Date convertStringToDateInOneThread(String dateString) throws ParseException {
        return SimpleDateFormat.getDateInstance(DateFormat.MEDIUM).parse(dateString);
    }


    private ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        @Override
        public DateFormat get() {
            return super.get();
        }

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy MM dd");
        }

        @Override
        public void remove() {
            super.remove();
        }

        @Override
        public void set(DateFormat value) {
            super.set(value);
        }


    };

    public Date convertStringToDateMultithread(String dateString) throws ParseException {
        return  df.get().parse(dateString);
    };

}
