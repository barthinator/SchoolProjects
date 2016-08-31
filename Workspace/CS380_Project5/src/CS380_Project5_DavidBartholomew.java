import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*******************Program Identification ************************************************/
/* COURSE: CS 380		 Data Structures 				                   				  */
/* PROJECT # : 5    				                   			        				  */
/* DUE DATE : April 4, 2016							        						 	  */
/* SOURCE FILE :  Sorting.java, CS380_Project_DavidBartholomew.java, sortingIn.txt
 * sortingOut.txt																     	  */
/* Instructor: Dr. Samuel Sambasivam                                                      */
/*                                                                                        */
/* Student Name: David Bartholomew                                                        */
/* Student ID: 002510408       					        								  */
/******************************************************************************************/

/**************** Program Description *****************************************************/
/* INPUT : This is the main method for the Sorting.java file. It utilizes file and printwriter
 * in order to manipulate the files and read/print the data to the files.	              */
/* OUTPUT : The sortingOut.txt file												  		  */
/* USER-DEFINED MODULES: Still don't know what that means.	     					      */
/* PROCESS : Sorting methods															  */
/******************************************************************************************/


/******************************************************************************************/

public class CS380_Project5_DavidBartholomew {
	public static void main(String args[]){

		System.out.println();
		System.out.println ( "David Bartholomew      002510408      CS 380  ");
		System.out.println ( "  Spring 2016   Project # 5");
		System.out.println ();
		System.out.println ();

		//Sets the names of the files being used
		String inputFile = "sortingIn.txt";
		String outputFile = "sortingOut.txt";

		File file = new File(inputFile);

		Sorting s = new Sorting();

		Scanner scan = null;
		PrintWriter print = null;
		try{
			scan = new Scanner(file);
			print = new PrintWriter(outputFile);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}

		//The array that is input into each function
		int[] arr;

		while(scan.hasNext()){
			//Scans the size of the array
			arr = new int[scan.nextInt()];

			//Prints the size of the array
			print.println("Sorted Array of length " + arr.length);

			//Skips a line
			scan.nextLine();
			//Scans the next line of integers into a String to be parsed
			String line = scan.nextLine();
			//Splits the String into an array of Strings at each space
			String[] numbers = line.split("\\s");
			for(int i = 0; i < arr.length; i++){
				//Parses each integer string into the arr used to pass into the functions
				arr[i] = Integer.parseInt(numbers[i]);
			}

			//Makes a copy of the original array because each time a function is called it overwrites the array
			int[] origArr = Arrays.copyOf(arr, arr.length);

			//To print out the sorted array(I used merge sort because it's cool)
			s.mergeSort(arr);
			for(int i = 0; i < arr.length; i++){
				//Prints each sorted element
				print.print(arr[i] + " ");
			}

			//For storing the totals to find the best method. [0] = selection, [1] = bubble, [2] = insertion
			//[3] = quick, [4] = merge
			int[] totals = new int[5];

			//Gets the original unsorted array back
			arr = Arrays.copyOf(origArr, origArr.length);

			//Prints out the header of the table
			print.println("\nSorting Method\t\tSwaps\t\tComparisons");

			/**
			 * For some reason the eclipse editor wouldn't format the text file
			 * how I wanted, so I formatted it according to how the eclipse editor
			 * handles it, BUT when I just open the file in my system using textEdit
			 * the columns can be tabbed a little weird but it is still readable.
			 */
			
			//Starts selection sort, then prints the amount of swaps and comparisons
			s.selectionSort(arr);
			print.println("Selection Sort\t\t" + s.swap + "\t\t\t" + s.comparison);
			arr = Arrays.copyOf(origArr, origArr.length);
			totals[0] = s.swap + s.comparison;

			//Starts bubble sort, then prints the amount of swaps and comparisons
			s.BubbleSort(arr);
			print.println("Bubble Sort\t\t\t" + s.swap + "\t\t\t" + s.comparison);
			arr = Arrays.copyOf(origArr, origArr.length);
			totals[1] = s.swap + s.comparison;

			//Starts insertion sort, then prints the amount of swaps and comparisons
			s.insertionSort(arr);
			print.println("Insertion Sort\t\t" + s.swap + "\t\t\t" + s.comparison);
			arr = Arrays.copyOf(origArr, origArr.length);
			totals[2] = s.swap + s.comparison;

			//Starts quick sort, then prints the amount of swaps and comparisons
			s.quickSort(arr, 0, arr.length-1);
			print.println("Quick Sort\t\t\t" + s.swap + "\t\t\t" + s.comparison);
			arr = Arrays.copyOf(origArr, origArr.length);
			totals[3] = s.swap + s.comparison;

			//Starts merge sort, then prints the amount of swaps and comparisons
			s.mergeSort(arr);
			print.println("Merge Sort\t\t\t" + s.swap + "\t\t\t" + s.comparison);
			totals[4] = s.swap + s.comparison;

			//To calculate the best sort method

			//Wasn't sure how this process was suppose to be calculated so I added the swaps
			//and comparisons together and the smallest one is chosen
			String best = null;
			int smallest = totals[0];
			//Finds the smallest element
			for(int i = 1; i < totals.length; i++){
				if (totals[i] < smallest)
					smallest = totals[i];
			}

			//Creates appropriate string
			if(totals[0] == smallest){
				best = "Selection Sort";
			}
			if(totals[1] == smallest){
				best = "Bubble Sort";
			}
			if(totals[2] == smallest){
				best = "Insertion Sort";
			}
			if(totals[3] == smallest){
				best = "Quick Sort";
			}
			if(totals[4] == smallest){
				best = "Merge Sort";
			}

			//Prints the best one choosen
			print.println("Best Sorting Method: " + best);
			print.println("\n");

		}

		scan.close();
		print.close();
	}
}
