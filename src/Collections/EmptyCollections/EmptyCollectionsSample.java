package Collections.EmptyCollections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyCollectionsSample {
    public static void main(String[] args) {
        //Type safe
        List<String> list = Collections.emptyList();
        Set<String> set = Collections.emptySet();
        Map<String, String> map = Collections.emptyMap();

        //Not type safe
        List list1 = Collections.EMPTY_LIST;
        Set set1 = Collections.EMPTY_SET;
        Map map1 = Collections.EMPTY_MAP;
    }
}
