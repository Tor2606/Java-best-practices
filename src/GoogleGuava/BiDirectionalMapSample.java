package GoogleGuava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

/**
 * Created by islabukhin on 04.10.16.
 */
public class BiDirectionalMapSample {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("ua", "Ukrainian");
        biMap.put("en", "English");
        System.out.println(biMap.get("ua"));
        System.out.println(biMap.inverse().get("English"));

        //Commons analog
        BidiMap bidiMap = new DualHashBidiMap();
        bidiMap.put("ua","Ukrainian");
        bidiMap.put("en", "English");
        System.out.println(bidiMap.get("ua"));
        System.out.println(bidiMap.inverseBidiMap().get("English"));
    }

}
