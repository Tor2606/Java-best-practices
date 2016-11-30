package GoogleGuava.Cache;

import JAXB_SAX_DOM_Performance.Person;
import com.google.common.cache.CacheLoader;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class PersonSearchServiceImpl {

    private CacheLoader<String, List<Person>> cache;

    public List<Person> search(String query){
        return newArrayList();
    }

    /*private void buildCache(){
        cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build(new CacheLoader<String, List>() {

                    @Override
                    public List load(String s) throws Exception {
                        return null;
                    }
                });
    }*/

}
