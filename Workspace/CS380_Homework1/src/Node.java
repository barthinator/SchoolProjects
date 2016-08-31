
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

public class Node {
	
	private String name;
	private Node next;
	
	/////////////////////////////////////////////
	//         DEFAULT CONSTRUCTOR            //
	///////////////////////////////////////////
	
	Node(){
		name = "";
		next = null;
	}
	
	/////////////////////////////////////////////
	//      OVERLOADED CONSTRUCTOR            //
	///////////////////////////////////////////
	public Node(String itemname){
		name = itemname;
		next = null;
	}
	
	/////////////////////////////////////////////
	//        GETTERS/SETTERS                 //
	///////////////////////////////////////////
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext(){
		return next;
	}
	
	public String getItemName(){
		return name;
	}

	/////////////////////////////////////////////
	//         FUNCTOIN toString              //
	///////////////////////////////////////////
	public String toString() {
		return "Node [name=" + name + "]";
	} 
	
	
}
