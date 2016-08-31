
/*******************Program Identification ************************************************/
/* COURSE: CS 380		 Data Structures 				                   				  */
/* PROJECT # : 4    				                   			        				  */
/* DUE DATE : March 15, 2016							        						  */
/* SOURCE FILE :  RecursiveFunction.java, CS380_Project_DavidBartholomew.java,      	  */
/* Instructor: Dr. Samuel Sambasivam                                                      */
/*                                                                                        */
/* Student Name: David Bartholomew                                                        */
/* Student ID: 002510408       					        								  */
/******************************************************************************************/

/**************** Program Description *****************************************************/
/* INPUT : This class takes files for input, one that is the input for a palindrome
 * checker and one that is the input for a GCM/LCM creator for two integers               */
/* OUTPUT : It will output the results to the output files that are entered by the user
 * in the main																			  */
/* USER-DEFINED MODULES: Still don't know what that means.	     					      */
/* PROCESS : Recursive methods															  */
/******************************************************************************************/


/******************************************************************************************/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecursiveFunction {

	/////////////////////////////////////////////
	//          Recursive Methods             //
	///////////////////////////////////////////

	/**
	 * This method will check to see if a string is a palindrome. It does so by using recursion!
	 * The base cases check to see if the length is one, if so it is a palindrome, because "m" is
	 * technically a plaindrome! The second base case sees if the last character in the String is NOT
	 * equal to the first character in the string, if so then it will return false.
	 * 
	 * The recursion part will basically pass in a String that doesn't contain its original first
	 * character and last character, so it removes the first and last character that was already checked to
	 * see if they are not equal to each other.
	 */
	
	public boolean isPalindrome(String s){
		//Originally replaced the spaces and switched to lowercase here but realized
		//it would run multiple times, so I moved it to the file handling method.
		//s = s.replaceAll("[^a-zA-Z]+","").toLowerCase();

		if(s.length() <= 1)
			return true;
		if(s.charAt(s.length() - 1) != s.charAt(0))
			return false;

		return isPalindrome(s.substring(1, s.length() - 1));
	}
	
	/**
	 * This method will return an integer value of the Greatest Common Divisor of the two integers entered.
	 * The base case checks to see if b is equal to 0 if so then it will return a. 
	 * 
	 * The recursion part passes in b as the first parameter and then a % b as the second parameter which
	 * was described and explained in the document.
	 */

	public int getGCD(int a, int b) {
		if(b == 0)
			return a;
		return Math.abs(getGCD(b, (a % b)));
	}


	/////////////////////////////////////////////
	//         File Handling Methods          //
	///////////////////////////////////////////
	
	/**
	 * This uses Scanner, File, and PrintWriter to read in from the file that is used as input
	 * and then output to the output file. I used printf() in order to have a more formatted
	 * output for bigger numbers so that it is better spaced out. The "%7s" and "%7d" denotes that 
	 * (s for string and d for int) it should be at least 7 characters and formats 
	 * accordingly to the right.
	 * 
	 * When reading the file it scans the first int on the line, sets it as a, then scans the next
	 * int and sets it as b. In the while loop it gets the GCD of those two values, then calculates
	 * the LCM and outputs it to output file with PrintWriter.
	 */

	public void solveGCD(String inputFile, String outputFile) {
		File gcdin = new File(inputFile);

		Scanner scan = null;
		PrintWriter gcdout = null;
		try {
			scan = new Scanner(gcdin);
			gcdout = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		gcdout.printf("%7s\t%7s\t%7s\t%7s%n", "a", "b", "GCD", "LCM");
		gcdout.printf("%7s\t%7s\t%7s\t%7s%n", "----", "----", "----", "----");
		while(scan.hasNext()){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int gcd = getGCD(a, b);
			int lcm;

			if(gcd == 0)
				lcm = 0;
			else
				lcm = Math.abs((a * b) / gcd);
			
			gcdout.printf("%7d\t%7d\t%7d\t%7d%n", a, b, gcd, lcm);
		}
		gcdout.close();
	}

	/**
	 * This function reads in from the input file and outputs a palindrome to the output file if
	 * it is one. It uses Scanner, File, and PrintWriter to read in from the file and output to the
	 * files.
	 * 
	 * It uses a while loop to go through each line of the .txt file and then checks the String to see
	 * if it is a palindrome, if so then it will output that string to the output file.
	 * 
	 * I used s.replaceAll("[^a-zA-Z]+","").toLowerCase() when I pass it into the function that checks the 
	 * palindrome in order to eliminate everything that is not a character and sets it to lowercase 
	 * so that it ignores case as well.
	 */
	public void solvePalindrome(String inputFile, String outputFile) {
		File palin = new File(inputFile);

		Scanner scan = null;
		PrintWriter palout = null;
		try{
			scan = new Scanner(palin);
			palout = new PrintWriter(outputFile);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}

		palout.printf("%30s\t%8s%n", "String", "isPalindrome");
		palout.printf("%30s\t%8s%n", "------", "------------");
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			boolean isPalindrome = isPalindrome(s.replaceAll("[^a-zA-Z]+","").toLowerCase());
			palout.printf("%30s\t%8b%n", s, isPalindrome);
		}
		palout.close();
	}
}
