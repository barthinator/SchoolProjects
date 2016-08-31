import java.util.Scanner;
/*
Author: David bartholomew                                      		
Date:     3/30/2016                                                            	
Purpose:   Simulation of an operating system     	
*/

public class JoshClient {
	public static void main(String[] args) {
		Josh os = new  Josh();
		Scanner scan = new Scanner(System.in);
		
		os.setOS(1);
		os.numCPUS(4);
		
		while (true)
		{
			String command = scan.nextLine();
			//help
			if(command.equals("help"))
				os.help();
			else if(command.equals("show pct"))
				os.showPCT();
			else if(command.contains("kill "))
			{
				if(command.length()==9)
				{
					String id = command.substring(5, 9);
					os.kill(id);
				}
				else
					System.out.println("not a valid id");
			}
			else if(command.equals("run"))
				os.run();
			else if(command.equals("show pit"))
				os.showPIT();
			else if(command.equals("ps"))
				os.pS();
			else if(command.contains("set OS")){
				command = command.substring(7);
				System.out.println("The OS is set to " + "PCT" + Integer.parseInt(command));
				os.setOS(Integer.parseInt(command));
			}
			else if(command.equals("exit"))
				return;
			else
				System.out.println("'" + command + "'" + " is not recognized as a command.");
		}


	}

}
