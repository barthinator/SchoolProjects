
	/*******************Program Identification ************************************************/
	/* COURSE: CS 380		 Data Structures 				                   				  */
	/* PROJECT # : 2    				                   			        				  */
	/* DUE DATE : February 17, 2016							        					      */
	/* SOURCE FILE :  List.java, Node.java, TestList.java                                     */
	/* Instructor: Dr. Samuel Sambasivam                                                      */
	/*                                                                                        */
	/* Student Name: David Bartholomew                                                        */
	/* Student ID: 002510408       					        								  */
	/******************************************************************************************/

	/**************** Program Description *****************************************************/
	/* INPUT : The program requires no input, unless the user would like to change            */
	/* 		the TestList main function and call methods from List                             */
	/* 		This would allow the user to manually create their own credit card list and       */
	/* 		manipulate it how they would desire.                                    		  */
	/* OUTPUT : Manipulation of the Credit Card list, that is printed to the console          */
	/* USER-DEFINED MODULES: All of the methods      						                  */
	/* PROCESS : Run the program and the processes will automatically start                   */
	/******************************************************************************************/


	/******************************************************************************************/

public class Node {
	
	private String name;
	private double balance;
	private Node next, prev;
	
	/////////////////////////////////////////////
	//          Constructors                  //
	///////////////////////////////////////////
	
	public Node(){
		this.name = "";
		this.balance = 0.0;
		this.prev = null;
		this.next = null;
	}
	
	public Node(String name, double balance){
		this.name = name;
		this.balance = balance;
		this.prev = null;
		this.next = null;
	}

	/////////////////////////////////////////////
	//         Getters/Setters                //
	///////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	/////////////////////////////////////////////
	//          FUNCTION toString             //
	///////////////////////////////////////////
	
	public String toString() {
		return "Node [name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}