
/*******************Program Identification ************************************************/
/* COURSE: CS 380		 Data Structures 				                   				  */
/* PROJECT # : 4    				                   			        				  */
/* DUE DATE : April 18, 2016							        						  */
/* SOURCE FILE :  Nodejava, BST.java, program6Out.txt, program6In.txt
 * CS_380_Project_DavidBartholomew.java                                    				  */
/* Instructor: Dr. Samuel Sambasivam                                                      */
/*                                                                                        */
/* Student Name: David Bartholomew                                                        */
/* Student ID: 002510408       					        								  */
/******************************************************************************************/

/**************** Program Description *****************************************************/
/* INPUT : This class just runs the binary search tree process, input from the input file */
/* OUTPUT : In the output file it will go through different traversals with the data give
 * in the input file		 															  */
/* USER-DEFINED MODULES: None				              							      */
/* PROCESS : Recursive traversals														  */
/******************************************************************************************/


/******************************************************************************************/


public class CS380_Project_DavidBartholomew {
	public static void main(String args[]){
		BST b = new BST();
		
		//Reads in the individual words to the String array
		String[] s = b.readIn("program6In.txt");
		
		//Creates the binary search tree
		b.creatBST(s);
		
		//Will write to the file in with the different traversals
		b.writeToFile("program6Out.txt");
	}
}
