import java.util.ArrayList;
import java.util.LinkedHashSet;

//     Author:     David Bartholomew                          		
     //     Date:         3/30/2016                                                              	
     //     Purpose:   To detect any deadlock in the system            


public class Deadlock {
	public String[][] testCase1 = 
		   {{"w","n","x","x","x","n","n"},//R1
		   	{"x","w","n","n","n","x","n"},//R2
			{"n","x","n","n","n","n","n"},//R3
			{"n","n","n","n","n","n","x"},//R4
			{"n","n","n","n","n","n","n"},//R5
			{"n","n","w","n","n","n","w"},//R6
			{"w","w","w","w","w","w","w"}};//R7

	public String[][] testCase2 = 
		   {{"w","n","x","x","x","n","n"},
			{"x","w","n","n","n","x","n"},
			{"n","x","w","n","n","n","n"},
			{"n","n","n","n","n","n","x"},
			{"n","n","n","n","n","n","n"},
			{"n","n","w","n","n","n","w"},
			{"w","w","w","w","w","w","w"}};

	public String[][] testCase3 = 
		   {{"w","n","x","n","n","n","n"},
			{"x","w","n","n","n","n","n"},
			{"n","x","n","n","n","n","n"},
			{"n","n","n","n","n","n","x"},
			{"n","n","n","x","n","w","n"},
			{"n","n","w","n","n","n","w"},
			{"n","n","n","w","w","x","w"}};
	
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
				printDeadlock(hasDeadlock(array, i), array);
				cycles.clear();
				return;
			}
		}
		printDeadlock(false, array);
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
	public void printDeadlock(boolean hasDeadlock, String[][] array){
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
			
			ArrayList<Integer> countTotals = new ArrayList<Integer>();
			int count = 0;
			for(int i = 0; i < cycles.size(); i++){
				for(int j = 0; j < array[cycles.get(i)].length; j++){
					if(array[cycles.get(i)][j].equals("x")){
						count++;
					}
				}
				countTotals.add(count);
				count = 0;
			}
			
			System.out.println();
			
			
			int min = 9999;
			for(int i = 0; i < countTotals.size(); i++){
				if(countTotals.get(i) < min){
					min = countTotals.get(i);
				}
			}
			
			for(int i = 0; i < countTotals.size(); i++){
				if(countTotals.get(i) > min){
					countTotals.set(i, -1);
				}
			}
			
			for(int i = 0; i < countTotals.size(); i++){
				if(countTotals.get(i) != -1){
					System.out.println("Deadlock is resolved by terminating job R" + (cycles.get(i)+1)
							+ " holding " + countTotals.get(i) + " resource(s).");
					break;
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