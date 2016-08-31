  /*
          Author:  David Bartholomew                                   		
          Date:      2/24/2016                                                             	
          Purpose:   To create fake processes in an OS simulation          	
 */


import java.util.Scanner;

public class OsSimulation {

	private static int CPUtimer=0;

	private static String [][] pct= {
			{"1000","running\t","0","top","0"},
			{"1001","running\t","0","top","0"},
			{"1002","running\t","0","top","0"},
			{"1003","running\t","0","top","0"},
			{"1004","running\t","0","top","0"},
			{"1005","running\t","0","top","0"},
			{"1006","running\t","0","top","0"}
	};

	public static String [][] pit={
			{"compute-1", "compute-2", "input-1", "finish"},//1000
			{"compute-1","input-1","output-1", "game-1", "game-2", "finish"},//1001
			{"compute-1","input-1","output-1", "finish"},//1002
			{"compute-1","compute-2","compute-3","compute-4","compute-5","finish"},//1003(12 long)
			{"print-1","print-2", "input-1", "output-1"},//1004
			{"input-1", "output-1", "compute-1", "finish"},//1005
			{"output-1","output-2", "output-3", "finish"},//1006

	};
	
	//Just to find the max amount of columns in pit(which is 12), I didn't want to hard code the value in.
	public int pitMaxLength(){
		int max = 0;
		for(int i = 0; i < pit.length; i++){
			if(pit[i].length >= max){
				max = pit[i].length;
			}
		}
		return max;
	}
	
	//The run function
	public void run()
	{
		if(CPUtimer >= pitMaxLength()){
			System.out.println("There is no process to run!");
			return;
		}
		
		for(int i = 0; i < pit.length; i++){
			if(CPUtimer < pit[i].length){
				if(pit[i][CPUtimer].equals("finish") || CPUtimer == pit[i].length - 1){
					pct[i][1] = "terminated";
				}
				pct[i][2] = "" + (int)(Integer.parseInt(pct[i][2]) + 1);
				pct[i][4] = "" + (int)(Integer.parseInt(pct[i][4]) + 1);
				System.out.println("Process 100" + i + ": " + pit[i][CPUtimer]);
			}
		}
		CPUtimer++;
	}

	//Lists all of the commands
	public void help()
	{
		System.out.println("run - to run one CPU time for each active process");
		System.out.println("ps - to show the PCT detail of all active processes");
		System.out.println("show pct - to show the detail of Process Control Table (PCT)");
		System.out.println("show pit - to show the detail of Process Instruction Table (PIT)");
		System.out.println("leave - cancel everything");
	}
	
	//Leaves the processes
	public void leave(){
		System.exit(0);
	}
	
	//Shows the PCT array
	public void showPCT()
	{
		System.out.println("Process Id\tStatus\t  \tCPU Time Used\t    Job Priority   Current Instruction Counter");
		for(int i = 0; i < pct.length; i++){
			for (int j = 0; j < pct[i].length; j++){
				System.out.print(pct[i][j] + "\t\t");
			}
			System.out.println();
		}
	}

	//Shows the PIT array
	public void showPIT()
	{
		for(int i = 0; i < pit.length; i++){
			System.out.print("Process 100" + i + ": ");
			for (int j = 0; j < pit[i].length; j++){
				System.out.print(pit[i][j] + ", ");
			}
			System.out.println();
		}
	}

	//Shows the current running processes
	public void ps()
	{
		if(CPUtimer >= pitMaxLength()){
			System.out.println("There is no active process to list!");
			return;
		}
		
		System.out.println("Process Id\tStatus\t  \tCPU Time Used\t    Job Priority   Current Instruction Counter");
		for(int i = 0; i < pct.length; i++){
			if(CPUtimer < pit[i].length){
				for(int j = 0; j < pct[i].length; j++){
					System.out.print(pct[i][j] + "\t\t");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		//show pct; show pit; run; run; ps; run; show pct; show pit; run; run; run; show pct; show pit; ps; 
		
		OsSimulation newOS = new OsSimulation();
		Scanner scan = new Scanner(System.in);
		
		String scanner = "";
		
		while (true){
			scanner = scan.nextLine();

			if(scanner.equals("ps")){
				newOS.ps();
			}
			if(scanner.equals("run")){
				newOS.run();
			}
			if(scanner.equals("show pit"))
			{
				newOS.showPIT();
			}
			if(scanner.equals("show pct"))
			{
				newOS.showPCT();
			}
			if(scanner.equals("help"))
			{
				newOS.help();
			}
			if(scanner.equals("leave")){
				newOS.leave();
			}
		}
	}
}