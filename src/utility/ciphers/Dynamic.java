
package utility.ciphers;

import java.util.Random;
import javax.crypto.Cipher;

/**
 *
 * @author Lester
 */

public class Dynamic {
    public String dynamicEncryptionOrDecryption(int mode, String text, String password) {		
		password = password.replaceAll("\\s", "");
		Random random = new Random(password.hashCode());
		char c;
		String result = "";
		if(!password.equals("")){
		if(mode==Cipher.ENCRYPT_MODE){
			for (int i = 0; i < text.length(); i++) {
					c = (char)(text.charAt(i) + (random.nextInt(687-192)+192) - (random.nextInt(687-192)+192));
				result += c; 
			}
		}
		
		else if(mode==Cipher.DECRYPT_MODE){
			for (int i = 0; i < text.length(); i++) {			
					c = (char)(text.charAt(i) - (random.nextInt(687-192)+192) + (random.nextInt(687-192)+192));	
				result += c; 			
			}			
		}
		}
		return result;	
    }
}
