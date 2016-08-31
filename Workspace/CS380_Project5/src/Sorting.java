
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
/* INPUT : None for this specifically	              									  */
/* OUTPUT : The sortingOut.txt file														  */
/* USER-DEFINED MODULES: Still don't know what that means.	     					      */
/* PROCESS : Sorting methods															  */
/******************************************************************************************/


/******************************************************************************************/

public class Sorting {
	
	
	//I made the swap and comparison public so that I could easily access them in the main method
	//For each method I reset swap and comparison to 0, then at the locations I feel appropriate
	//I increment them.

	public int swap = 0;
	public int comparison = 0;
	
	
	/**
	 * This is the selection sort method. It takes in a integer of arrays and doesn't return anything
	 * because it manipulates the original array.
	 */
	public void selectionSort(int[] arr) {
		//Useful variables
		int i, j, minIndex, tmp;
		comparison = 0;
		swap = 0;
		//Set as the arrays length
		int n = arr.length;
		for (i = 0; i < n - 1; i++) {
			//Sets minIndex
			minIndex = i;
			for (j = i + 1; j < n; j++){
				comparison++;
				//To find a new index if needed
				if (arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			if (minIndex != i) {
				//Where swap occurs
				tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
				swap++;
			}
		}
	}
	
	/**
	 * This is the insertion sort method. It takes in a integer of arrays and doesn't return anything
	 * because it manipulates the original array.
	 */
	public void insertionSort(int[] arr) {
		int i, j, newValue;
		comparison = 0;
		swap = 0;
		for (i = 1; i < arr.length; i++) {
			newValue = arr[i];
			j = i;
			comparison++;
			//Sees if value is greater
			while (j > 0 && arr[j - 1] > newValue) {
				//Wasn't sure if I needed to increment comparison on the inside and outside of this loop
				comparison++;
				swap++;
				//Swap happens here
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = newValue;
		}
	}

	/**
	 * This is the bubble sort method. (pretty inefficient) It takes in a integer of arrays and doesn't return anything
	 * because it manipulates the original array.
	 */
	public void BubbleSort(int[] num)
	{
		int j;
		//Initially set this way so the it runs at least once
		boolean flag = true;
		int temp;
		comparison = 0;
		swap = 0;

		while (flag)
		{
			//set flag to false awaiting a possible swap
			flag= false;
			for(j=0; j < num.length -1; j++){
				comparison++;
				if (num[j] > num[j+1]){
					 //swap elements
					temp = num[j];
					swap++;
					num[j] = num[j+1];
					num[j+1] = temp;
					//shows a swap occurred
					flag = true;
				} 
			} 
		} 
	} 


	//These variables are needed for the MergeSort method because they hold values of the array
	//as it splits up in the process.
	private int[] numbers;
	private int[] helper;

	private int number;

	/**
	 * This method just calls the sort method with specified values
	 */
	public void mergeSort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];

		comparison = 0;
		swap = 0;

		sort(0, number - 1);
	}
	
	/**
	 * This method uses recursion and the merge method to sort the array
	 */
	private void sort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		comparison++;
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			sort(low, middle);
			// Sort the right side of the array
			sort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	/**
	 * Used to merge different arrays together
	 */
	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				swap++;
				numbers[k] = helper[i];
				i++;
			} else {
				swap++;
				numbers[k] = helper[j];
				j++;
			}
			k++;
			comparison++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			swap++;
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

	//Used in the quicksort method
	int count = 0;

	/**
	 * Another recursive sort method used to sort the input array split according to the indexes
	 * specified.
	 */
	public void quickSort(int[] arr, int low, int high) {

		//makes sure that it resets the comparison/swap variables only on the first call
		if(count == 0){
			comparison = 0;
			swap = 0;
		}

		count++;

		if (arr == null || arr.length == 0)
			return;
		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			comparison++;
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}

	/**
	 * Used to print an array for debugging purposes
	 */
	public void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
