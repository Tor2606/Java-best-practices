package Singleton.SerialisableSingleton;

import java.io.Serializable;

/**
 * Created by islabukhin on 30.09.16.
 */

//Good when you need to serialise singleton
public enum  SerialisableSingleton implements Serializable{
    INSTANCE;
}
