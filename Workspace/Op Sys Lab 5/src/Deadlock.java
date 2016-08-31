     //     Author:     David Bartholomew                          		
     //     Date:         3/30/2016                                                              	
     //     Purpose:   To detect any deadlock in the system            


import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Deadlock {

	public String[][] testCase1 = 
		   {{"w","n","x"},//R1
			{"x","w","n"},//R2
			{"n","x","w"}};//R3

	public String[][] testCase2 = 
		   {{"w","n","x"},//R1
			{"x","w","n"},//R2
			{"n","x","n"}};//R3

	public String[][] testCase3 = 
		   {{"n","x","w"},//R1
			{"x","n","w"},//R2
			{"n","w","x"}};//R3
	
	public ArrayList<Integer> cycles = new ArrayList<Integer>();

	/**
	 * Recursive method that checks if there is continual deadlock in the rows
	 * @param array
	 * @param row
	 * @return
	 */
	public boolean hasDeadlock(String[][] array, int row){
		int col = findW(array, row);

		if(col == -1){
			return false;
		}

		cycles.add(row);
		row = findX(col, array);

		if(cycles.size() > array.length){
			return true;
		}

		return hasDeadlock(array, row);
	}
	
	/**
	 * Runs the recursive method for each row
	 * @param array
	 */
	
	public void deadlockTest(String[][] array){
		for(int i = 0; i < array.length; i++){
			if(hasDeadlock(array, i)){
				cycles.clear();
				printDeadlock(hasDeadlock(array, i));
				cycles.clear();
				return;
			}
		}
		printDeadlock(false);
	}
	
	/**
	 * Finds the location of the W in each row
	 * @param array
	 * @param row
	 * @return
	 */

	public int findW(String[][] array, int row){
		for(int i = 0; i < array.length; i++){
			if(array[row][i].equals("w")){
				//returns the col
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Finds the location of the X value in each column
	 * @param column
	 * @param array
	 * @return
	 */
	
	public int findX(int column, String[][] array){
		for(int i = 0; i < array.length; i++){
			if(array[i][column].equals("x")){
				//returns the row
				return i;
			}
		}

		return -1;
	}

	/**This is the method that prints the cycles where the deadlock is located
	 * 
	 * @param hasDeadlock
	 */
	public void printDeadlock(boolean hasDeadlock){
		cycles = new ArrayList<Integer>(new LinkedHashSet<Integer>(cycles));
		if(hasDeadlock){
			System.out.print("Deadlock is detected among jobs ");
			for(int i = 0; i < cycles.size(); i++){
				if(i == cycles.size() - 1){
					System.out.print("R" + (cycles.get(i) + 1) + ".");
				}
				else{
					System.out.print("R" + (cycles.get(i) + 1) + ", ");
				}
			}
		}
		else{
			System.out.print("Congratualations! There is no deadlock detected");
		}
		System.out.println();
	}
	
	/**
	 * Prints the array that we are detecting deadlock with
	 * @param arr
	 */
	public void printArr(String[][] arr){
		System.out.print("  ");
		for(int i = 0; i < arr.length; i++){
			System.out.print("C" + (i+1) + " ");
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++){
			System.out.print("R" + (i+1) + " ");
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]){
		Deadlock d = new Deadlock();
		System.out.println("Test Case 1:");
		d.printArr(d.testCase1);
		d.deadlockTest(d.testCase1);
		System.out.println();
		System.out.println("Test Case 2:");
		d.printArr(d.testCase2);
		d.deadlockTest(d.testCase2);
		System.out.println();
		System.out.println("Test Case 3:");
		d.printArr(d.testCase3);
		d.deadlockTest(d.testCase3);
		System.out.println();
	}
}
