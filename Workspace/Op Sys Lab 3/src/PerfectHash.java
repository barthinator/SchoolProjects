/*
          Author:  David Bartholomew                                        		
          Date:      2/17/2016                                                              	
          Purpose:   To perfectly hash 12 social security numbers into 3-digit employee ids with no collision         	
*/

public class PerfectHash {

	int items[];
	int newItems[];
	
	public PerfectHash(int array[]){
		items = array;
	}
	
	public void hash(){
		System.out.println("Old Numbers\tNewNumbers");
		for(int i = 0; i < items.length; i++){
			newItems = new int[items.length];
			newItems[i] = (int) (items[i] * (Math.pow(31, (i - 1))) % 1000) + 35;
			System.out.print(items[i] + "\t" + newItems[i]);
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int numbers[] = {123456789,
				234567890,
				345678912,
				456789012, 
				567896789,
				123456798,
				987654321,
				887766554,
				12345678,
				113456745,
				665544332,
				723456789};
		
		PerfectHash p = new PerfectHash(numbers);
		p.hash();
	}
	
}
