package GoogleGuava.BloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.math.BigInteger;

public class BloomFilterSample {
    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(Funnels.byteArrayFunnel(), 1000);

        bloomFilter.put(BigInteger.valueOf(10000000l).toByteArray());

        System.out.println(bloomFilter.mightContain(BigInteger.valueOf(10000000l).toByteArray()));
    }
}
