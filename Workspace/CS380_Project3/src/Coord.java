
	/*******************Program Identification ************************************************/
	/* COURSE: CS 380		 Data Structures 				                   				  */
	/* PROJECT # : 3    				                   			        				  */
	/* DUE DATE : March 3, 2016							        					          */
	/* SOURCE FILE :  Coord.java, MazeStack.java, MazeQueue.java, 
	 * CS_380_Project_DavidBartholomew.java                                   				  */
	/* Instructor: Dr. Samuel Sambasivam                                                      */
	/*                                                                                        */
	/* Student Name: David Bartholomew                                                        */
	/* Student ID: 002510408       					        								  */
	/******************************************************************************************/

	/**************** Program Description *****************************************************/
	/* INPUT : No input for this class                     		 							  */
	/* OUTPUT : No output for this class													  */
	/* USER-DEFINED MODULES: None				                  							  */
	/* PROCESS : None    																	  */
	/******************************************************************************************/


	/******************************************************************************************/
public class Coord {
	private int m_row, m_col;
	Coord next, previous;
	
	public Coord(int rrow, int ccol){
		m_row = rrow;
		m_col = ccol;
		next = null;
		previous = null;
	}
	public int getRow(){
		return m_row;
	}
	public int getCol(){
		return m_col;
	}
	public void setNext(Coord newNode)
	{
		next = newNode;
	}
	public Coord getNext(){
		return next;
	}
	public void setPrevious(Coord newNode){
		previous = newNode;
	}
	public Coord getPrevious(){
		return previous;
	}
	
	//Added this just to make debugging easier
	public String toString() {
		return "Coord [m_row=" + m_row + ", m_col=" + m_col + "]";
	}
}
