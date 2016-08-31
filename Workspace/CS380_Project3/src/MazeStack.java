
/*******************Program Identification ************************************************/
/* COURSE: CS 380		 Data Structures 				                   				  */
/* PROJECT # : 3    				                   			        				  */
/* DUE DATE : March 3, 2016							        					          */
/* SOURCE FILE :  Coord.java, MazeStack.java, MazeQueue.java,  
 * CS_380_Project_DavidBartholomew.java                                                   */
/* Instructor: Dr. Samuel Sambasivam                                                      */
/*                                                                                        */
/* Student Name: David Bartholomew                                                        */
/* Student ID: 002510408       					        								  */
/******************************************************************************************/

/**************** Program Description *****************************************************/
/* INPUT : THis is the class that solves the maze using stacks                     		  */
/* OUTPUT : It will output the maze using a wait function for user friendliness			  */
/* USER-DEFINED MODULES: None				                                              */
/* PROCESS : Stacks            															  */
/******************************************************************************************/


/******************************************************************************************/


public class MazeStack {
	private int size;
	private Coord head;
	
	char path = 'O';
	char walkway = '.';
	
	/////////////////////////////////////////////
	//         Constructors                   //
	///////////////////////////////////////////
	
	private void setup(){
		size = 0;
		//Initialized it to an invalid value so that I would know if something went wrong
		head = new Coord(-1, -1);
		head.setPrevious(head);
		head.setNext(head);
	}
	
	public MazeStack(){
		setup();
	}
	
	
	/////////////////////////////////////////////
	//               pop                      //
	///////////////////////////////////////////
	
	public Coord pop(){	
		if(!isEmpty()){
			Coord temp = head.getPrevious();
			temp.getNext().setPrevious(temp.getPrevious());
			temp.getPrevious().setNext(temp.getNext());
			size--;
			return temp;
		}
		else{
			System.out.println("The list was empty.");
			return new Coord(-1,-1);
		}
	}
	
	/////////////////////////////////////////////
	//        showStructure()                 //
	///////////////////////////////////////////
	
	public void showStructure(){
		if(isEmpty())
			System.out.println("Empty List");
		else{
			System.out.println("size = " + size);
			for (Coord temp = head.getNext(); temp != head; temp = temp.getNext())
				System.out.println(temp.toString());
		}
	}
	
	/////////////////////////////////////////////
	//             push                       //
	///////////////////////////////////////////
	
	public void push(Coord newCoord){
		newCoord.setNext(head); //1
		newCoord.setPrevious(head.getPrevious()); //2
		head.getPrevious().setNext(newCoord); //3
		head.setPrevious(newCoord); //4
		size++;
	}
	
	/////////////////////////////////////////////
	//         isEmpty()                      //
	///////////////////////////////////////////
	
	public boolean isEmpty(){
		if(size <= 0)
			return true;
		return false;
	}
	
	/////////////////////////////////////////////
	//         isFull()                       //
	///////////////////////////////////////////
	
	public boolean isFull(){
		Coord temp = new Coord(-1, -1);
		return (temp == null);
	}
	
	/////////////////////////////////////////////
	//         printMaze()                    //
	///////////////////////////////////////////
	
	//Prints the maze, and the boolean is just to tell if you want to add a delay to the print or not.
	public void printMaze(char[][] genericMaze, boolean allowDelay){
		for(int i = 0; i < genericMaze.length; i++){
			for(int j = 0; j < genericMaze[i].length; j++){
				System.out.print(genericMaze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		if(allowDelay){
			delay();
		}
	}
	
	/////////////////////////////////////////////
	//             peek()                     //
	///////////////////////////////////////////
	
	public Coord peek(){
		return head.getPrevious();
	}
	
	/////////////////////////////////////////////
	//         delay()                        //
	///////////////////////////////////////////
	
	//I use a separate function of the sleep method just so that it makes it easier to use
	public void delay(){
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	/////////////////////////////////////////////
	//         pathExists()                   //
	///////////////////////////////////////////

	public boolean pathExists(char[][] genericMaze, Coord startCoord, Coord endCoord) {
		System.out.println("This is the stack maze");
		
		//Variable to store the amount of times a cell is visited
		int cellsVisited = 0;
		push(startCoord);
		genericMaze[startCoord.getRow()][startCoord.getCol()] = path;
		cellsVisited++;
		printMaze(genericMaze, true);
		
		while(!isEmpty()){
			
			Coord temp = pop();
			
			//Checks to see if we are at the endCoord
			if(temp.getRow() == endCoord.getRow() && temp.getCol() == endCoord.getCol()){
				System.out.println("The number of cells visited was: " + cellsVisited);
				return true;
			}
			
			//Path is 'O' while walkway is '.'
			//This checks the up direction
			if(genericMaze[temp.getRow()-1][temp.getCol()] == walkway){
				genericMaze[temp.getRow()-1][temp.getCol()] = path;
				push(new Coord(temp.getRow()-1, temp.getCol()));
				printMaze(genericMaze, true);
				cellsVisited++;
			}
			
			//This checks the right direction
			if(genericMaze[temp.getRow()][temp.getCol()+1] == walkway){
				genericMaze[temp.getRow()][temp.getCol()+1] = path;
				push(new Coord(temp.getRow(), temp.getCol()+ 1));
				printMaze(genericMaze, true);
				cellsVisited++;
			}
			
			//This checks the down direction
			if(genericMaze[temp.getRow()+1][temp.getCol()] == walkway){
				genericMaze[temp.getRow()+1][temp.getCol()] = path;
				push(new Coord(temp.getRow() + 1, temp.getCol()));
				printMaze(genericMaze, true);
				cellsVisited++;
			}
			
			//This checks the left direction
			if(genericMaze[temp.getRow()][temp.getCol()-1] == walkway){
				genericMaze[temp.getRow()][temp.getCol()-1] = path;
				push(new Coord(temp.getRow(), temp.getCol()- 1));
				printMaze(genericMaze, true);
				cellsVisited++;
			}
		}
		
		//If it breaks out of the while loop, then that means that there was no solution.
		System.out.println("There was no solution.");
		System.out.println("The number of cells visited was: " + cellsVisited);
		return false;
	}

}
