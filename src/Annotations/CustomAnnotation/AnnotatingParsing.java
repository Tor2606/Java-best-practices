package Annotations.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotatingParsing {
    public static void main(String[] args) throws ClassNotFoundException {
        for (Method method : AnnotatingParsing.class.getClassLoader()
                .loadClass(("Annotations.CustomAnnotation.AnnotationExample"))
                .getMethods()){

            if(method.isAnnotationPresent(Annotations.CustomAnnotation.MethodInfo.class))
                try{
                    for(Annotation annotation: method.getDeclaredAnnotations()){
                        System.out.println("Annotation in method " + method + " " + annotation);
                    }

                    MethodInfo methodannotation = method.getAnnotation(MethodInfo.class);
                    if(methodannotation.revision() == 1){
                        System.out.println("Method with revision no 1 = " + method);
                    }
                }catch (Throwable ex){
                    ex.printStackTrace();
                }

        }
    }
}
