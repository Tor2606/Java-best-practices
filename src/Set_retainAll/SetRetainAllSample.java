package Set_retainAll;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class SetRetainAllSample {
    public static void main(String[] args) {
        Set set1 = newHashSet("a","b","c","d");
        Set set2 = newHashSet("c","d", "e");

        Set set1Unique = newHashSet(set1);
        set1Unique.removeAll(set2);

        Set set1Common = newHashSet(set1);
        set1Common.retainAll(set2);

        System.out.println(set1Unique);//a,b
        System.out.println(set1Common);//c,d
    }
}
