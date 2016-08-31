import java.util.Arrays;

public class Defrag {


	/*
	Author:   David Bartholomew                                   		
	Date:     3/30/2016                                                              	
	Purpose:  To perform defragmentation for memory page 
	 */

	//Test case 1 and 2
	public static String table = 
					"___A___________________B___________________________" + 
					"_______CD__________________________________________" + 
					"G___________________________________X______________" +
					"______________________________IVY__________________" + 
					"____LING___________________________________________" + 
					"___________PAGE____________________________________" + 
					"______________________________________U____________" + 
					"__________S_____________A__________________________" +
					"______________DR___________________________________";

	public static String table2 = 
					"___XRAY____________________________________________" +
					"_______CD__________________________________________" +
					"GAS________________________________________________" + 
					"______________________________I____J_____K_________" + 
					"____LOW____________________________________________" +
					"___________HI______________________________________" +
					"_A_____________________________________P___________" +
					"__________U_____________________________DR_________" +
					"______________U______________C____LA_______________";

	public static String table3 = 
					"____KITTEN_________________________________________" +
					"_R___________________PUPPIES____________R_RG__R_R__" +
					"_______COOL__________________AWESOME_______________" + 
					"___________KARRRRRRRRRRRLLLLLLLL___________________" + 
					"___________________________________________________" +
					"___SHREK__________________H________________________" +
					"___________________________________________________" +
					"___F___________I_______________________G___________" +
					"________L__________________________________________";


	//Used to convert the String you gave us to a 2D array of characters
	public char[][] convertString(String table, int columns){
		//Turns the String into a char array
		char[] c = table.toCharArray();
		//Going to be used later to convert it to a 2D array
		char[][] conversion;

		//Sets the amount of rows
		int rowCount = c.length / columns;
		//Creates the 2D array with the appropriate size
		conversion = new char[rowCount][columns];

		//Adds each element to the 2D array
		for(int i = 0, count = 0; i < conversion.length; i++){
			for(int j = 0; j < conversion[i].length; j++){
				conversion[i][j] = c[count];
				count++;
			}
		}

		return conversion;
	}


	//Used to do the defragmentation process
	public char[][] defragmentation(char[][] elements){
		int row = 0;
		int col = 0;

		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < elements[i].length; j++){
				//Checks to make sure the array won't go out of bounds
				if((j+1) < elements[i].length){
					//Replaces the elements and moves them over to their correct locations
					if(elements[i][j] != '_'){
						elements[row][col] = elements[i][j];
						elements[i][j] = '_';
						if(elements[i][j+1] != '_'){
							col+=1;
						}
						else{
							col+=2;
						}
					}
				}
				else{
					//If two characters are joined together but are at the at the end of a row and the beginning of the next
					if(elements[i][j] != '_'){
						elements[row][col] = elements[i][j];
						elements[i][j] = '_';
						col+=1;
					}
				}
				//Checks to see if the row is filled all of the way up
				if(col >= elements[i].length){
					col = 0;
					row++;
				}
			}
		}

		return elements;
	}

	//Used to easily print the array
	public void printArr(char[][] elements){
		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < elements[i].length; j++){
				System.out.print(elements[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String args[]){
		Defrag d = new Defrag();

		//The first case
		System.out.println("Test Case 1 Before");
		d.printArr(d.convertString(table, 51));
		System.out.println();
		System.out.println("Test Case 1 After");
		d.printArr(d.defragmentation(d.convertString(table, 51)));

		System.out.println("\n");

		//The second case
		System.out.println("Test Case 2 Before");
		d.printArr(d.convertString(table2, 51));
		System.out.println();
		System.out.println("Test Case 2 After");
		d.printArr(d.defragmentation(d.convertString(table2, 51)));

		System.out.println("\n");

		//The third case
		System.out.println("Test Case 3 Before");
		d.printArr(d.convertString(table3, 51));
		System.out.println();
		System.out.println("Test Case 3 After");
		d.printArr(d.defragmentation(d.convertString(table3, 51)));
	}

}