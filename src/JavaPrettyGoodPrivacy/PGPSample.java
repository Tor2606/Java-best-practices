package JavaPrettyGoodPrivacy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;

/**
 * Created by islabukhin on 28.09.16.
 */
public class PGPSample {
    /*public static void encrypt()  {

        Security.addProvider(new BouncyCastleProvider());

        //Load Public Key File
        FileInputStream key = new FileInputStream("res/keys/public.bpg");
        PGPPublicKey pubKey = KeyBasedFileProcessorUtil.readPublicKey(key);

        //Output file
        FileOutputStream out = new FileOutputStream("target/enc.bpg");

        //Input file
        String inputFilename = "src/main/resources/plaintext.txt";

        //Other settings
        boolean armor = false;
        boolean integrityCheck = false;
        KeyBasedFileProcessorUtil.encryptFile(out, inputFilename,
                pubKey, armor, integrityCheck);
    }*/
}
