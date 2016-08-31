
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
/* INPUT : none																			  */
/* OUTPUT : none	 															          */
/* USER-DEFINED MODULES: none				              							      */
/* PROCESS : none																		  */
/******************************************************************************************/


/******************************************************************************************/
public class Node {
	
	//Creates the left and right node and the String value
	private Node left;
	private Node right;
	private String name;
	
	
	/////////////////////////////////////////////
	//          Constructors                  //
	///////////////////////////////////////////
	Node(){
		this.name = null;
		this.left = null;
		this.right = null;
	}
	
	public Node(String s) {
		this.name = s;
		this.left = null;
		this.right = null;
	}
	
	/////////////////////////////////////////////
	//          Getters/Setters               //
	///////////////////////////////////////////

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
