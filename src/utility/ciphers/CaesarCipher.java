package utility.ciphers;

/**
 *
 * @author Lester
 */
import java.util.Scanner;


public class CaesarCipher
{
	// Encrypts text using a shift od s
	public String encrypt(String message, int key)
	{
		String encryptedMessage = "";
		char ch;
 
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else {
	        	encryptedMessage += ch;
	        }
		}
                return encryptedMessage;
	}

}
