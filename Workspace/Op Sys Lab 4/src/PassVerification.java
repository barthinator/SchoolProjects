import java.util.Scanner;

//    Author:    David Bartholomew                                      		
//    Date:        2/17/2016                                                              	
//    Purpose:   To verify password for its security strength         

public class PassVerification {
	
	public boolean checkLength(String pass){
		//Checks if the pass is greater than 8 and less than 16
		if(pass.length() >= 8 && pass.length() <= 16){
			return true;
		}
		return false;
	}
	
	public boolean containsSpace(String pass){
		//Checks to see if the pass contains a space
		if(pass.contains(" ")){
			return true;
		}
		return false;
	}
	
	public boolean containsDigits(String pass){
		String digits[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
		int count = 0;

		//used to check to see if the password contains the digits
		for (int i = 0; i < digits.length; i++){
			//Checks is the pass contains the digit
			if(pass.contains(digits[i]) && count < 2){
				//Sets the index of the digit so the pass doesn't go out of bounds later
				int num = pass.indexOf(digits[i]);
				//makes sure pass wont go out of bounds
				if(num < pass.length()){
					//Creates a substring with the remaining password that checks to see 
					//if there are two of the same number
					String doubleCheck = pass.substring(num + 1);
					//If it contains a duplicate then increments the count
					if(doubleCheck.contains(digits[i])){
						count++;
					}
				}
				count++;
			}
		}
		
		if(count >= 2)
			return true;
		
		return false;
	}
	
	public boolean containsUpperCase(String pass){
		String upperCase = pass.toUpperCase();
		int count = 0;
		
		//A for loop that compares the characters in the upper case string and the original password
		for(int i = 0; i < upperCase.length(); i++){
			//Checks to see if they contain an upper case char and if it is a character(not a number).
			if(pass.charAt(i) == upperCase.charAt(i) && Character.isLetter(pass.charAt(i))){
				count++;
			}
		}
		
		if(count >= 2){
			return true;
		}
		
		return false;
	}
	
	public boolean containsLowerCase(String pass){		
		String lowerCase = pass.toLowerCase();
		int count = 0;
		
		//A for loop that compares the characters in the lower case string and the original password
		for(int i = 0; i < lowerCase.length(); i++){
			//Checks to see if they contain a lower case char and if it is a character(not a number).
			if(pass.charAt(i) == lowerCase.charAt(i) && Character.isLetter(pass.charAt(i))){
				count++;
			}
		}

		if(count >= 2){
			return true;
		}

		return false;
	}

	public boolean containsSpecial(String pass){
		String specialChar[]  = {"$","#","@","&","*","?","!"};
		
		//Uses the special char array and sees if the pass contains any of those chars
		for (int i = 0; i < specialChar.length; i++){
			if(pass.contains(specialChar[i])){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean containsSpecialNumbers(String pass){
		String specialNums[]  = {"2017","2016","2015","2014","2013","2013","2012","2011"};
		
		//Uses the specialNums array and sees if it contains any of those dates
		for (int i = 0; i < specialNums.length; i++)
			if(pass.contains(specialNums[i]))
				return false;
		
		return true;
	}
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a password");
		String pass = scan.nextLine();

		PassVerification password = new PassVerification();

		if(password.checkLength(pass) && !password.containsSpace(pass) && password.containsDigits(pass) && password.containsUpperCase(pass) && password.containsLowerCase(pass) && password.containsSpecial(pass) && password.containsSpecialNumbers(pass)){
			System.out.println("Congratulations!  Your password " + pass + "is very secure!");
		}
		else{
			System.out.println("The password " + pass + " violates the following rule(s):");
			if(!password.checkLength(pass)){
				System.out.println("Rule 1: Valid Length – The length of the password must be 8 to 16 only.");
			}
			if(password.containsSpace(pass)){
				System.out.println("Rule 2: No Space – The password must not contain any space or blank character.");
			}
			if(!password.containsDigits(pass)){
				System.out.println("Rule 3: At least 2 digits – The password must contain at least 2 digits.");
			}
			if(!password.containsUpperCase(pass)){
				System.out.println("Rule 4: At least 2 upper-case letters – The password must contain at least two upper-case letters.");
			}
			if(!password.containsLowerCase(pass)){
				System.out.println("Rule 5: At least 2 lower-case letters – The password must contain at least two lower-case letters.");
			}
			if(!password.containsSpecial(pass)){
				System.out.println("Rule 6: At least 1 special character – The password must contain at least one special character, "
						+ "which can be one of the following 7 choices: ‘$’, ‘#’, ‘@’, ‘&’, ‘*’, ‘?’, or ‘!’.");
			}
			if(!password.containsSpecialNumbers(pass)){
				System.out.println("Rule 7: No special numbers – The password must not contain any of the following 7 numbers: 2017, 2016,"
						+ " 2015, 2014, 2013, 2012, or 2011.");
			}
		}
	}

}
