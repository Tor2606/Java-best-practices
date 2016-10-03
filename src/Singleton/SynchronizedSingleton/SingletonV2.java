package Singleton.SynchronizedSingleton;

/**
 * Created by islabukhin on 28.09.16.
 */
public class SingletonV2 {
    private static final SingletonV2 INSTANCE = new SingletonV2();

    public static SingletonV2 getSingletonV2() {
        return INSTANCE;
    }
}
