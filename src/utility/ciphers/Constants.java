package utility.ciphers;


public class Constants {
	
    public static final String PASSWORD_ERROR_LENGTH = "The password must be no more than 16 characters";
    public static final String PASSWORD_ERROR_NULL = "Insert password";
    public static final String PASSWORD_ERROR = "Wrong password";
    public static final String FILE_NOT_FOUND = "File not found";
    public static final String ERROR_LOADING_LAYOUT = "Error during the layout loading";
    public static final String ERROR_TEXT = "Insert text";
    public static final String VIG_ERROR = "- Input text and key should be in UpperCase \n" +
                                    "- No Space is Allowed. ";
    public static final String HELP = "Help";
    public static final String GUIDE = "Guide";
    public static final String CAESER = "Caeser Cipher";
    public static final String RAIL = "RailFence Cipher";
    public static final String VIG = "Vigenere Cipher";
    public static final String DYAN = "Dynamic Encryption";
    public static final String WARNING = "Warning !";
    public static final String MAIN_PROGRAM_HELP = "" +
    		"Instructions :\n"+
    		"- Type your input text to encrypt/decrypt. \n" +
    		"- Type your shift/key. \n" +
    		"- Choose your encryption algorithm \n" +
    		"- Click Encrypt or Decrypt \n";
    
    public static final String CAESER_HELP = "" +
                "Instructions :\n" +
                "- Shift key should be Integer. \n" +
                "- Shift key should be between 0-25. \n";
    
    public static final String RAIL_HELP = "" +
                "Instructions :\n" +
                "- No space is allowed. ";
    
    public static final String VIG_HELP = "" +
                "Instructions :\n" +
                "- Input text should be in CAPITAL letters. \n" +
                "- No space is allowed. \n" +
                "- Key should be CAPITAL letters. \n";
    
    public static final String DYAN_HELP = "" +
                "- Type your input text to encrypt/decrypt. \n" +
                "- Type your password in key input area. \n" +
                "- Click on Encrypt or Decrypt";
                
}
