
//Write the function header
//Define the magic function
//add your base code
//solve the problem using the magic function
//remove the magic
//validate the function

public class Recursion {

	
	public void eatCandy(int layer){
		if(layer == 0){
			return;
		}
		
		System.out.println("Layer " + layer);
		eatCandy(layer - 1);
	}
	
	public int factorial(int n){
		if(n == 0)
			return 1; //base case
		
		return (n * factorial(n-1));
	}
	
	public int fib(int n){
		if(n == 0){
			return 1;
		}
		else if(n == 1){
			return 1;
		}
		
		return fib(n - 1) + fib(n-2);
	}
	
	public void printArr(int[] arr, int size){
		if(size == 0){
			return;
		}
		
		printArr(arr, size-1);
		System.out.println(arr[size - 1]);
	}
	
	public int recSum(int n){
		if(n <= 0){
			return 0;
		}
	
		return n + recSum(n-1);
	}
	
	public int powerof2(int n){
		if(n <= 0){
			return 1;
		}
		if(n ==1){
			return 2;
		}
		
		return powerof2(n-1) + powerof2(n-1);
	}
	
	public int recMax(int[] array, int size){
		if(size <= 0){
			return Integer.MIN_VALUE;
		}
		if(size == 1){
			return array[0];
		}
		
		int part1 = array[size -1];
		int part2 = recMax(array, size-1);
		
		return part1 > part2 ? part1 : part2;
	}
	
	
	
	public static void main(String[] args){
		Recursion r = new Recursion();
		int[] arr = {5,4,3,2,1,30,12,32,78,1,2,3,2,1,15};
		
		r.printArr(arr, 10);
		System.out.println(r.fib(50));
		System.out.println(r.recSum(100));
		
		System.out.println(r.recMax(arr, arr.length));
		
	}
	
}
