package ReflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class VictimRunner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class aClass = Victim.class;
        Method[] ms = aClass.getDeclaredMethods();
        for (Method each : ms) {
            String methodName = each.getName();
            each.setAccessible(true);
            if(Modifier.isPrivate(each.getModifiers())){
                if(Modifier.isStatic(each.getModifiers())){
                    each.invoke(Victim.class, new Object[]{});
                }else{
                    each.invoke(new Victim(), new Object[]{});
                }
            }
        }
    }
}
