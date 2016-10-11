package WeakReferences;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static javax.swing.UIManager.put;

public class WeakReferencesSample {
    //all classes in lang.ref
    PhantomReference phantomReference;
    Reference reference;
    ReferenceQueue referenceQueue;
    SoftReference softReference;
    WeakReference<Map<Integer,String>> weakReference;

    public static void main(String[] args) {
        new WeakReferencesSample().doFunction();
    }

    private void doFunction(){
        Map<Integer, String> map = new HashMap<>();
        WeakReference<Map<Integer,String>> myMap = new WeakReference<Map<Integer,String>>(map);

        map = null;
        int i = 0;
        while (true){
            if(myMap != null && myMap.get() != null){
                myMap.get().put(i++, "test" + i);

                System.out.println("Still working");
            }else {
                //when memory is out
                System.out.println("Finished");
                System.out.println(map);
            }
        }
    }
}
