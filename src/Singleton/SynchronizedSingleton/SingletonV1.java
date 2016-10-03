package Singleton.SynchronizedSingleton;

/**
 * Created by islabukhin on 28.09.16.
 */
public class SingletonV1 {
    private static SingletonV1 singletonV1;

    public static synchronized SingletonV1 getSingletonV1() {
        if(singletonV1 == null) singletonV1 = new SingletonV1();
        return singletonV1;
    }
}
