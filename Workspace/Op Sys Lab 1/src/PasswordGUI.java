 /*
          Author:  David Bartholomew                                     		
          Date:      2/3/2016                                                              	
          Purpose:  To encrypt a password that is entered and then decrypt that password so that you
          to see it again. The program uses AES as its encryption method and has an encryption key that
          is used to encrypt and decrypt the password.    
          
          ****This specific class just runs the method and creates a simple GUI to enter a password        
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordGUI {

    public static void main(String[] args) throws Exception {

    	
    	//Creates the JLabel where the password is entered
    	JLabel label = new JLabel("Please enter your password:");
    	JPasswordField jpf = new JPasswordField();
    	JOptionPane.showConfirmDialog(null,
    	  new Object[]{label, jpf}, "Password:",
    	  JOptionPane.OK_CANCEL_OPTION);
    	
    	//Converts the password into a String
    	String password = new String(jpf.getPassword());
    	
    	//Calls the methods from the AESencrp class to encrypt and decrypt the password.
        String passwordEnc = AESencrp.encrypt(password);
        String passwordDec = AESencrp.decrypt(passwordEnc);

        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }
}
