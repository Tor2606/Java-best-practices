package Annotations;

public class AnnotationExample {
    @NullValueValidate(paramName = "test1") private String testVar1;
    @NullValueValidate(paramName = "test2") private String testVar2;

    public AnnotationExample(String testVar1, String testVar2) {
        this.testVar1 = testVar1;
        this.testVar2 = testVar2;
        NullValueValidateAnnotationProcessor.processAnnotations(this);
    }

    public static void main(String[] args) {
        AnnotationExample ae = new AnnotationExample("Value 1", null);
    }
}
