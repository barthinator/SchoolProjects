
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

public class List {
	private int size;
	private Node head;

	/////////////////////////////////////////////
	//          Constructors                  //
	///////////////////////////////////////////
	
	//I don't like to use unnecessary return statements at the end of my void methods here's why:
	/** http://stackoverflow.com/questions/1909779/should-methods-with-return-type-void-use-a-return-statement **/
	private void setup(){
		size = 0;
		head = new Node();
		head.setPrev(head);
		head.setNext(head);
	}

	public List(){
		setup();
	}

	
	/////////////////////////////////////////////
	//          FUNCTION append               //
	///////////////////////////////////////////
	
	/**
	 * This function appends a new node to the end of the list. It first checks to see if
	 * the list is full or if it already contains node that is going to be appended.
	 */
	public void append(Node newNode){
		if(!isFull() && !contains(newNode.getName())){
			newNode.setNext(head);
			newNode.setPrev(head.getPrev());
			head.getPrev().setNext(newNode);
			head.setPrev(newNode);
			size++;
		}
	}

	/////////////////////////////////////////////
	//          FUNCTION clear                //
	///////////////////////////////////////////
	
	/**
	 * This method clears the list, at first I re-wrote what was in the setup method, but realized
	 * it would be more efficient to just call the setup method again.
	 */
	public void clear(){
		setup();
	}

	/////////////////////////////////////////////
	//          FUNCTION isEmpty              //
	///////////////////////////////////////////
	
	/**
	 * This function checks to see the list is empty, by seeing if the size is 0.
	 */
	public boolean isEmpty(){
		if(size <= 0)
			return true;
		return false;
	}

	/////////////////////////////////////////////
	//          FUNCTION isFull               //
	///////////////////////////////////////////
	
	/**
	 * This function checks to see if creating a new node will cause a null error(meaning that the memory
	 * would theoretically be full).
	 */
	public boolean isFull(){
		Node temp = new Node();
		return (temp == null);
	}

	/////////////////////////////////////////////
	//       FUNCTION showStructure           //
	///////////////////////////////////////////
	
	/**
	 * This function prints out the list. If it is empty it will print Empty List if not, then it prints
	 * out all of the nodes inside.
	 */
	public void showStructure(){
		if(isEmpty())
			System.out.println("Empty List");
		else{
			System.out.println("size = " + size);
			for (Node temp = head.getNext(); temp != head; temp = temp.getNext())
				System.out.println(temp.toString());
		}
	}

	/////////////////////////////////////////////
	//       FUNCTION insertBeginning         //
	///////////////////////////////////////////
	
	/**
	 * This method puts newNode at the beginning of the list by using the nodes built in methods. It checks to make
	 * sure that the node isn't already in the list(by using contains() which is used to retrieve a node by String)
	 */
	public void insertBeginning(Node newNode){
		if(isEmpty()){
			append(newNode);
		}
		else{
			newNode.setNext(head.getNext());
			newNode.setPrev(head);
			head.getNext().setPrev(newNode);
			head.setNext(newNode);
			size++;
		}
	}

	/////////////////////////////////////////////
	//        FUNCTION insertAfter            //
	///////////////////////////////////////////
	
	/**
	 * This function will insert a node after the name that is input. If it does not contain the node associated
	 * with the name and it or if it is full, then it will return false and do nothing. Otherwise, it will
	 * place the node in the right location.
	 */
	public boolean insertAfter(String name, Node newNode){
		if(!contains(name) || isFull())
			return false;
		newNode.setNext(get(name).getNext());
		newNode.setPrev(get(name));
		//Realized using get() would be more efficient then having to use another loop.
		get(name).getNext().setPrev(newNode);
		get(name).setNext(newNode);
		size++;
		return true;
	}

	/////////////////////////////////////////////
	//      FUNCTION insertBefore             //
	///////////////////////////////////////////
	
	/**
	 * This function will insert a node before the name that is input. If it does not contain the node associated
	 * with the name and it or if it is full, then it will return false and do nothing. Otherwise, it will
	 * place the node in the right location.
	 */
	public boolean insertBefore(String name, Node newNode){
		if(!contains(name) || isFull())
			return false;
		newNode.setNext(get(name));
		newNode.setPrev(get(name).getPrev());
		get(name).getPrev().setNext(newNode);
		get(name).setPrev(newNode);
		size++;
		return true;
	}

	/////////////////////////////////////////////
	//          FUNCTION update               //
	///////////////////////////////////////////
	
	/**
	 * This function first checks to make sure that the list isn't empty and that it does contain
	 * a node with the name, then it will update the balance of that node.
	 */
	public boolean update(String name, double balance){
		if(!isEmpty() && contains(name)){
			get(name).setBalance(balance);
			return true;
		}
		return false;
	}

	/////////////////////////////////////////////
	//          FUNCTION erase                //
	///////////////////////////////////////////
	
	/**
	 * This function checks to see if the list is not empty and that the list contains the node with the name input
	 * then it will erase that node by linking its previous to that node's next.
	 */
	public boolean erase (String name){
		if(!isEmpty() && contains(name)){
			get(name).getNext().setPrev(get(name).getPrev());
			get(name).getPrev().setNext(get(name).getNext());
			size--;
			return true;
		}
		return false;
	}

	/////////////////////////////////////////////
	//          FUNCTION contains             //
	///////////////////////////////////////////
	
	/**
	 * Checks to see if the name input corresponds with a node in the list by using a for loop
	 * that iterates through each item, then checks and if so it returns true, if not than false.
	 */
	public boolean contains (String name){
		for(Node temp = head.getNext(); temp != head; temp = temp.getNext())
			if(temp.getName().equals(name))
				return true;
		return false;
	}

	/////////////////////////////////////////////
	//             FUNCTION get               //
	///////////////////////////////////////////

	/**
	 * This function will return the node corresponding to the name input. It first checks to make sure if the list
	 * is not empty, then uses a for loop to iterate through each item, then will return that node if it is found,
	 * if not than it returns an empty node.
	 */
	public Node get(String name){
		if(!isEmpty())
			for(Node temp = head.getNext(); temp != head; temp = temp.getNext())
				if(temp.getName().equals(name))
					return temp;
		return new Node("", 0.0);
	}
}