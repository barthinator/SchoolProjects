
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

public class CS380_Project4_DavidBartholomew {
	public static void main(String args[]){
	    System.out.println();
	    System.out.println ( "David Bartholomew      002510408      CS 380  ");
	    System.out.println ( "  Spring 2016   Project # 3");
	    System.out.println ();
	    System.out.println ();
		
		RecursiveFunction fun = new RecursiveFunction();
		fun.solveGCD("gcdin.txt", "gcdout.txt");
		fun.solvePalindrome("palin.txt","palout.txt");
	}
}
