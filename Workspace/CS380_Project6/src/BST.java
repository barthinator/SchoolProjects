
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
/* INPUT : Not for this file, these are just the methods.								  */
/* OUTPUT : In the output file it will go through different traversals with the data give
 * in the input file		 															  */
/* USER-DEFINED MODULES: None				              							      */
/* PROCESS : Recursive traversals														  */
/******************************************************************************************/


/******************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BST {

	public Node root = null;
	//Contains the processed words in order
	private ArrayList<String> traversals = new ArrayList<String>();

	/////////////////////////////////////////////
	//              readIn		              //
	///////////////////////////////////////////
	
	/**
	 * This function takes in String for the name of the input file and will
	 * process the words that are in the file by splitting them by spaces. It
	 * returns a String array that is all of the individual words
	 */
	public String[] readIn(String inputFile){

		File file = new File(inputFile);
		Scanner scan = null;
		try{
			scan = new Scanner(file);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}


		//Scans the whole line in as a String
		String s = scan.nextLine();

		//Removes anything that is not an alphabetic character or a space
		s = s.replaceAll("[^a-zA-Z\\s]", "");

		//Splits the String into String of words for future processing
		String[] words = s.split("\\s");

		return words;

	}

	/////////////////////////////////////////////
	//          writeToFile                   //
	///////////////////////////////////////////
	
	/**
	 * Takes in an outputFile String which denotes what the file being written to is.
	 * It then processes the BST with all three traversal methods and then prints them
	 * to the file using PrintWriter.
	 */
	public void writeToFile(String outputFile){

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Header info
		pw.println();
		pw.println ( "David Bartholomew      002510408      CS 380  ");
		pw.println ( "  Spring 2016   Project # 6");
		pw.println ();
		pw.println ();


		//Processes it InOrder
		InOrder(root);

		//Prints a little heading
		pw.println("In-Order Traversal:\r");

		//Prints the traversal ArrayList
		for(int i = 0; i < traversals.size(); i++){
			//The '-' denotes left shifted, the 16 is the amount of characters, the 's'
			//means it is a String, and the "\t" represents the tab between words
			pw.printf("%-16s\t", traversals.get(i));

			//If it has been five words then it will new line.
			if((i+1) % 5 == 0){
				pw.println();
			}
		}

		//Prints out the count by getting the ArrayLists size
		pw.println("\r");
		pw.println("Word Count: " + traversals.size());
		pw.println("\r");

		//Clears the arrayList so we can go on to the next traversal method.
		traversals.clear();

		//Switches to Pre-Order
		PreOrder(root);
		pw.println("Pre-Order Traversal:\r");

		//Prints the traversal ArrayList
		for(int i = 0; i < traversals.size(); i++){
			//The '-' denotes left shifted, the 16 is the amount of characters, the 's'
			//means it is a String, and the "\t" represents the tab between words
			pw.printf("%-16s\t", traversals.get(i));

			//If it has been five words then it will new line.
			if((i+1) % 5 == 0){
				pw.println();
			}
		}

		//Prints out the count by getting the ArrayLists size
		pw.println("\r");
		pw.println("Word Count: " + traversals.size());
		pw.println("\r");

		//Clears the arrayList so we can go on to the next traversal method.
		traversals.clear();

		//Switches to PostOrder
		PostOrder(root);
		pw.println("Post-Order Traversal:\r");

		//Prints the traversal ArrayList
		for(int i = 0; i < traversals.size(); i++){
			//The '-' denotes left shifted, the 16 is the amount of characters, the 's'
			//means it is a String, and the "\t" represents the tab between words
			pw.printf("%-16s\t", traversals.get(i));

			//If it has been five words then it will new line.
			if((i+1) % 5 == 0){
				pw.println();
			}
		}

		//Prints out the count by getting the ArrayLists size
		pw.println("\r");
		pw.println("Word Count: " + traversals.size());
		pw.println("\r");

		//Clears the arrayList so we can go on to the next traversal method.
		traversals.clear();


		pw.close();
	}


	/////////////////////////////////////////////
	//           createBST                    //
	///////////////////////////////////////////
	
	/**
	 * This is basically the processing method that takes in the String[] of unprocessed words.
	 * It then will call the insert function to put them into the array. I printed the total
	 * to the console for debugging purposes.
	 */
	public void creatBST(String[] array){
		//Holds the total amount of successfully added words
		int total = 0;
		for(int i = 0; i < array.length; i++){
			//inserts the given item
			if(insert(array[i])){
				//If it inserted then it adds to the total.
				total++;
			}
		}

		//Just for debugging
		//System.out.println(total);
	}
	
	/////////////////////////////////////////////
	//          insert                        //
	///////////////////////////////////////////

	/**
	 * This is the insert function that we were given in class. I changed it so that it returns
	 * a boolean so that we can know if the insert was successful or not.
	 */
	public boolean insert(String s){
		//If there is nothing in it then make it the root
		if (root == null)  {   
			root = new Node(s);
			return true; 
		}

		//Sets the cur as the root
		Node cur = root;

		//Infinitely loops till something returns
		for (;;){
			//Compares the String to the cur name value(the word), if it is 0, then we know that
			//they are the same String so it will return false and exit
			if (s.compareTo(cur.getName()) == 0)
				return false; 

			//If the value is less than 0, meaning the Strings alphabetical value is less then
			//the current node, then it will put it on the left side of the tree
			if (s.compareTo(cur.getName()) < 0){
				if (cur.getLeft() != null)      
					cur = cur.getLeft();
				else{
					cur.setLeft(new Node(s));
					return true;
				}
			}

			//If the value is greater than 0, meaning the Strings alphabetical value is greater then
			//the current node, then it will put it on the right side of the tree
			else if (s.compareTo(cur.getName()) > 0){
				if (cur.getRight() != null)      
					cur = cur.getRight();
				else{
					cur.setRight(new Node(s));
					return true;
				}
			}
		}
	}
	
	/////////////////////////////////////////////
	//          PostOrder                     //
	///////////////////////////////////////////

	/**
	 * Post-Order traversal, does not return anything but will add the values in order to the
	 * traversal ArrayList. The code was given in class
	 */
	void PostOrder(Node cur){
		if (cur == null)
			return;

		PostOrder(cur.getLeft());
		PostOrder(cur.getRight());
		traversals.add(cur.getName());
	}
	
	/////////////////////////////////////////////
	//          InOrder                       //
	///////////////////////////////////////////

	/**
	 * In-Order traversal, does not return anything but will add the values in order to the
	 * traversal ArrayList. The code was given in class
	 */
	void InOrder(Node cur){
		if (cur == null)
			return;

		InOrder(cur.getLeft());
		traversals.add(cur.getName());
		InOrder(cur.getRight());
	}
	
	/////////////////////////////////////////////
	//          Pre-Order                     //
	///////////////////////////////////////////

	/**
	 * Pre-Order traversal, does not return anything but will add the values in order to the
	 * traversal ArrayList. The code was given in class
	 */
	void PreOrder(Node cur){

		if (cur == null)
			return;

		traversals.add(cur.getName());
		PreOrder(cur.getLeft());
		PreOrder(cur.getRight());
	}

}
