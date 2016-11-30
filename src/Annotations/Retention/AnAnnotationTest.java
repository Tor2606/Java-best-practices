package Annotations.Retention;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnAnnotationTest {
    @Test
    public void testAnAnnotation(){
        AnAnnotatedClass anAnnotatedClass = new AnAnnotatedClass();
        Annotation[] annotations = AnAnnotatedClass.class.getAnnotations();
        assertThat(annotations.length, is(1));
    }
}
