
	/*******************Program Identification ************************************************/
	/* COURSE: CS 380		 Data Structures 				                   				  */
	/* HOMEWORK # : 1    				                   			        				  */
	/* DUE DATE : February 11, 2016							        					      */
	/* SOURCE FILE :  List.java, Node.java, main.java                                         */
	/* Instructor: Dr. Samuel Sambasivam                                                      */
	/*                                                                                        */
	/* Student Name: David Bartholomew                                                        */
	/* Student ID: 002510408       					        								  */
	/******************************************************************************************/

	/**************** Program Description *****************************************************/
	/* INPUT : No input is required                                                 		  */
	/* OUTPUT : The output demonstrates the functions created within the List class.          */
	/* USER-DEFINED MODULES: None                                                             */
	/* PROCESS : It creates a singly linked list.                                             */
	/******************************************************************************************/


	/******************************************************************************************/

public class main {
	
	public static void main(String[] args) {
		/***************************************
		 * 1. Create 3 Items
		 * 2. Create 1 list
		 * 3. Add all three items to the list
		 * 4. Show the list
		 * 5. Erase the second item from the list
		 * 6. Show the list
		 * 7. Clear the list
		 * 8. Show the list
		 ***************************************/
		
		System.out.println();
	    System.out.println ( "David Bartholomew      002510408      CS 380  ");
	    System.out.println ( "  Spring 2016   Homework # 1");
	    System.out.println ();
	    System.out.println ();
		
		List davidsList = new List();
		
		Node apple = new Node("Apple");
		Node iceCream = new Node("Ice cream");
		Node cereal = new Node("Cereal");

		davidsList.append(apple);
		davidsList.append(iceCream);
		davidsList.append(cereal);
		davidsList.showStructure();
		System.out.println();
		
		System.out.println(davidsList.erase("Ice cream"));
		davidsList.showStructure();
		System.out.println();
		
		davidsList.clear();
		davidsList.showStructure();
		
	}
}