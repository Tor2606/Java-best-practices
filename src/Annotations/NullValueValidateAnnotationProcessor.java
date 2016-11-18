package Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class NullValueValidateAnnotationProcessor {

    public static void processAnnotations(Object obj) {
        try {
            Class c = obj.getClass();

            for (Field f : c.getDeclaredFields()) {
                try {
                    for (Annotation a : f.getAnnotations()) {
                        if (a.annotationType() == NullValueValidate.class) {
                            NullValueValidate nullValueValidate = (NullValueValidate) a;
                            System.out.println("Processing the field : " +
                                    nullValueValidate.paramName());
                            f.setAccessible(true);
                            if (f.get(obj) == null) {
                                throw new NullPointerException("The value of the field " + f.toString() + " can't be NULL");
                            }else{
                                System.out.println("Value of the obj: " + f.get(obj));
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
