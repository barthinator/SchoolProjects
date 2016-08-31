
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

public class List {
	
	private int size = 0;
	private Node head;

	
	/////////////////////////////////////////////
	//         DEFAULT CONSTRUCTOR            //
	///////////////////////////////////////////
	
	public List(){
		size = 0;
		head = new Node();
		return;
	}
	
	/////////////////////////////////////////////
	//         FUNCTION append                //
	///////////////////////////////////////////
	
	/** Adds an item to the end of the list by using a for loop to reach
	 * the last node, then setting the next as the new node.
	 * **I really tried to reach maximum efficiency in this method**/
	public void append(Node newItem){
		Node temp;
		for(temp = head; temp.getNext() != null; temp = temp.getNext());
		temp.setNext(newItem);
		temp.getNext().setNext(null);
		size++;
	}

	/////////////////////////////////////////////
	//         FUNCTION showStructure         //
	///////////////////////////////////////////
	
	/**Prints out the structure of the list, also by using a for loop to iterate
	 * through each item and output their values.**/
	public void showStructure(){
		if(size == 0){
			System.out.println("Empty List");
		}
		else{
			System.out.println("size = " + size);
			for (Node temp = head.getNext(); temp != null; temp = temp.getNext()){
				System.out.println(temp.toString());
			}
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION erase                 //
	///////////////////////////////////////////
	
	/**Deletes a node from the list according to the name that is entered.
	 * It links the previous node to the one being erased to the following node
	 * after the one being erased, causing it to be "de-linked".
	 * **I wanted to make this method more efficient but was having trouble 
	 * combining if statements, and it would eventually add up to the same 
	 * amount of lines. **/
	public boolean erase(String name){
		for(Node temp = head; temp.getNext() != null; temp = temp.getNext()){
			//Could not use the contains method here because it had to be
			//casted to a List, causing an error(Sam recommended using contains).
			if(temp.getNext().getItemName().equals(name)){
				if(temp.getNext().getNext() == null){
					temp.setNext(null);
				}
				else{
					temp.setNext(temp.getNext().getNext());
				}
				size--;
				return true;
			}
		}
		return false;
	}
	
	
	/////////////////////////////////////////////
	//         	FUNCTION clear                //
	///////////////////////////////////////////
	
	/**Removes all nodes by simply setting the node after the header as null**/
	public void clear(){
		size = 0;
		head.setNext(null);
	}
	
	/////////////////////////////////////////////
	//         FUNCTION contains              //
	///////////////////////////////////////////
	
	/**If the list contains a node with the name entered, then it will return
	 * true. Otherwise, it will return false.**/
	public boolean contains(String name){
		Node temp;
		for(temp = head; temp.getNext() != null; temp = temp.getNext()){
			if(temp.getNext().getItemName().equals(name)) return true;
		}
		return false;
	}
}
