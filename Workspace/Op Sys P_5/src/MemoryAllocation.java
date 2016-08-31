    //     Author:     David Bartholomew                     		
     //     Date:         4/06/2016                                                              	
     //     Purpose:   To demonstrate the performance of first-fit, best-fit and worst-fit algorithms.            


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MemoryAllocation {

	public ArrayList<Integer> memory = new ArrayList<Integer>();
	public ArrayList<Integer> inputs = new ArrayList<Integer>();
	public ArrayList<Integer> oldMem = new ArrayList<Integer>();

	public void startProcess(){
		
		//Variables used to store stuff
		
		int firstFitMem = 0;
		int bestFitMem = 0;
		int worstFitMem = 0;

		int firstFitTime = 0;
		int bestFitTime = 0;
		int worstFitTime = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer (between 5 and 20) for # of memory segments in the system>");
		int totalItems = scan.nextInt();

		System.out.println("Please enter " + totalItems + " integers for " + totalItems + " memory segments");
		for(int i = 0; i < totalItems; i++){
			memory.add(scan.nextInt());
		}

		oldMem = new ArrayList<Integer>(memory);

		int count = 0;

		/**
		 * FIRST FIT
		 */

		while(count < 4){

			System.out.print("\nPlease enter an integer for the size of memory segment requested by OS>");
			int inputMemory = scan.nextInt();
			inputs.add(inputMemory);

			for(int i = 0; i < memory.size(); i++){
				if(inputMemory < memory.get(i)){
					int result = memory.get(i) - inputMemory;
					memory.set(i, inputMemory);
					memory.add(i+1, result);
					System.out.print("First-Fit algorithm found the segment " + inputMemory + " using time "
							+ (i+1) + "." + " Result: " + memory.size() + " memory segments: \t");
					firstFitMem = memory.size();
					firstFitTime += (i+1);
					break;
				}
			}

			for(int i = 0; i < memory.size(); i++){
				System.out.print(memory.get(i) + " ");
			}

			count++;
		}

		count = 0;
		memory = new ArrayList<Integer>(oldMem);

		System.out.println("\n");

		/**
		 * BEST FIT
		 */

		while(count < inputs.size()){

			int min = Integer.MAX_VALUE;
			int difference = 0;
			int best = -1;
			for(int i = 0; i < memory.size(); i++){
				if(inputs.get(count) <= memory.get(i)){
					difference = (memory.get(i) - inputs.get(count));
					if(difference == 0){
						break;
					}
					if(difference < min){
						min = difference;
						best = i;
					}
				}
			}

			if(difference == 0){
				System.out.println();
				System.out.print("Best-Fit algorithm found the segment " + inputs.get(count) + " using time "
						+ (memory.size()) + "." + " Result: " + memory.size() + " memory segments: \t");
				for(int i = 0; i < memory.size(); i++){
					System.out.print(memory.get(i) + " ");
				}
				bestFitMem = memory.size();
				bestFitTime += (memory.size());

			}
			else{

				int result = memory.get(best) - inputs.get(count);
				memory.set(best, inputs.get(count));
				memory.add(best+1, result);
				System.out.println();
				System.out.print("Best-Fit algorithm found the segment " + inputs.get(count) + " using time "
						+ (memory.size() - 1) + "." + " Result: " + memory.size() + " memory segments: \t");

				for(int i = 0; i < memory.size(); i++){
					System.out.print(memory.get(i) + " ");
				}
				bestFitMem = memory.size();
				bestFitTime += (memory.size() - 1);
			}
			count++;
		}


		count = 0;
		memory = new ArrayList<Integer>(oldMem);

		System.out.println("\n");

		/**
		 * WORST FIT
		 */

		while(count < inputs.size()){

			int max = -1;
			int difference = 0;
			int best = -1;
			for(int i = 0; i < memory.size(); i++){
				if(inputs.get(count) <= memory.get(i)){
					difference = (memory.get(i) - inputs.get(count));
					if(difference > max){
						max = difference;
						best = i;
					}
				}
			}

			if(best == -1){
				System.out.println("Could not find a proper location.");
				break;
			}

			int result = memory.get(best) - inputs.get(count);
			memory.set(best, inputs.get(count));
			memory.add(best+1, result);
			System.out.println();
			System.out.print("Worst-Fit algorithm found the segment " + inputs.get(count) + " using time "
					+ (memory.size() - 1) + "." + " Result: " + memory.size() + " memory segments: \t");

			for(int i = 0; i < memory.size(); i++){
				System.out.print(memory.get(i) + " ");
			}
			worstFitMem = memory.size();
			worstFitTime += (memory.size() - 1);
			count++;
		}
		
		//Prints out the totals and the best


		System.out.println("\n");
		System.out.println("Final result of these 3 algorithms with V = (T/2 + 3*G):");
		System.out.println("First fit took a total time of " + firstFitTime + " with the result of " + firstFitMem 
				+ " memory segments." + " V=" + ((firstFitTime/2 + (3*firstFitMem))));
		System.out.println("Best fit took a total time of " + bestFitTime + " with the result of " + bestFitMem 
				+ " memory segments." + " V=" + ((bestFitTime/2 + (3*bestFitMem))));
		System.out.println("Worst fit took a total time of " + worstFitTime + " with the result of " + worstFitMem 
				+ " memory segments." + " V=" + ((worstFitTime/2 + (3*worstFitMem))));

		int[] array = {((firstFitTime/2 + (3*firstFitMem))), ((bestFitTime/2 + (3*bestFitMem))), (worstFitTime/2 + (3*worstFitMem))};

		int[] sortedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(sortedArray);

		System.out.print("Conclusion:");

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < sortedArray.length; j++){
				if(sortedArray[i] == array[j]){
					System.out.print(" #" + (i+1) + " is ");
					if(j == 0){
						System.out.print("First-Fit");
					}
					else if(j == 1){
						System.out.print("Best-Fit");
					}
					else if(j == 2){
						System.out.print("Worst-Fit");
					}

					if(i < 2){
						System.out.print(",");
					}
					else{
						System.out.print(".");
					}
				}
			}
		}
	}

	//Runs the process
	public static void main(String args[]){
		MemoryAllocation m = new MemoryAllocation();
		m.startProcess();
	}

}
