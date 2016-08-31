

/*******************Program Identification ************************************************/
/* COURSE: CS 380		 Data Structures 				                   				  */
/* PROJECT # : 3    				                   			        				  */
/* DUE DATE : March 3, 2016							        					          */
/* SOURCE FILE :  Coord.java, MazeStack.java, MazeQueue.java,                             */
/* CS_380_Project_DavidBartholomew.java                                                   */
/* Instructor: Dr. Samuel Sambasivam                                                      */
/*                                                                                        */
/* Student Name: David Bartholomew                                                        */
/* Student ID: 002510408       					        								  */
/******************************************************************************************/

/**************** Program Description *****************************************************/
/* INPUT : THis is the client class for running the maze                     		      */
/* OUTPUT : It runs the pathExists function which will print out a path 			      */
/* USER-DEFINED MODULES: None				                                              */
/* PROCESS : Stacks                                                                       */
/******************************************************************************************/


/******************************************************************************************/

public class CS380_Project_DavidBartholomew {	
	public static char[][] GenericMaze = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','.','X','.','.','.','X','.','X','X'},
			{'X','X','X','X','.','X','.','.','X','X'},
			{'X','.','X','X','X','X','.','.','.','X'},
			{'X','.','.','.','.','.','.','X','.','X'},
			{'X','X','X','X','X','X','X','.','.','X'},
			{'X','X','X','.','X','.','.','X','.','X'},
			{'X','.','X','X','X','.','X','X','.','X'},
			{'X','.','.','X','X','.','.','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};
	
	public static char[][] Maze1 = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X','.','.','.','.','.','.','.','.','X'},
            {'X','X','.','X','.','X','X','X','X','X'},
            {'X','.','.','X','.','X','.','.','.','X'},
            {'X','.','.','X','.','.','.','X','.','X'},
            {'X','X','X','X','.','X','X','X','.','X'},
            {'X','.','X','.','.','.','.','X','X','X'},
            {'X','.','.','X','X','.','X','X','.','X'},
            {'X','.','.','.','X','.','.','.','.','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
   
    public static char[][] Maze2 = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X','X','.','.','.','.','.','X','.','X'},
            {'X','X','.','X','X','.','X','X','.','X'},
            {'X','X','.','.','X','.','.','.','.','X'},
            {'X','X','.','X','.','X','X','X','X','X'},
            {'X','X','.','X','.','X','X','X','X','X'},
            {'X','.','.','X','X','.','.','X','.','X'},
            {'X','.','X','X','.','X','.','X','.','X'},
            {'X','.','.','.','.','.','.','.','.','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
   
    public static char[][] Maze3 = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X','X','X','X','X','.','.','X','.','X'},
            {'X','X','X','X','.','X','X','X','X','X'},
            {'X','X','.','.','.','.','.','.','.','X'},
            {'X','.','.','X','X','.','.','X','.','X'},
            {'X','X','.','X','X','.','X','X','.','X'},
            {'X','X','X','X','.','.','.','X','.','X'},
            {'X','.','.','X','.','X','.','X','.','X'},
            {'X','X','.','X','.','.','X','X','X','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
	
	
	public static void main(String[] args) {
	    System.out.println();
	    System.out.println ( "David Bartholomew      002510408      CS 380  ");
	    System.out.println ( "  Spring 2016   Project # 3");
	    System.out.println ();
	    System.out.println ();
		
		Coord startCoord = new Coord(7,8);
		Coord endCoord = new Coord(1,7);
		
		Coord startCoord2 = new Coord(7, 1);
		Coord endCoord2 = new Coord(6, 8);
		
		Coord startCoord3 = new Coord(8,4);
		Coord endCoord3 = new Coord(8, 2);
		
		
		//MazeStack stackMaze = new MazeStack();
		//stackMaze.pathExists(Maze1, startCoord, endCoord);
		
		MazeQueue queueMaze = new MazeQueue();		
		queueMaze.pathExists(Maze1, startCoord, endCoord); 
		
		

	}

}
