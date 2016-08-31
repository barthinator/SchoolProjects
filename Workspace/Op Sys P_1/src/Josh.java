import java.util.Arrays;

public class Josh {
	
	/*
	Author:   David Bartholomew                                   		
	Date:      3/30/2016                                                              	
	Purpose:   Simulation of an operating system     	
	 */
	
	
	public static int CPUtimer=0;
	public String [][] dataPCT = new String [17][7];		
	public String[][] dataPIT= new String [17][13];
	public int numberOfCPU=0;
	public String [][] pct= {
			{"1001","1","waiting   ","0","1","0"},
			{"1001","2","waiting   ","0","1","0"},
			{"1002","1","waiting   ","0","1","0"},
			{"1002","2","waiting   ","0","2","0"},
			{"1002","3","waiting   ","0","3","0"},
			{"1003","1","waiting   ","0","1","0"},
			{"1004","1","waiting   ","0","1","0"},
			{"1005","1","waiting   ","0","4","0"},
			{"1006","1","waiting   ","0","1","0"},
			{"1007","1","waiting   ","0","3","0"},
			{"1007","2","waiting   ","0","2","0"},
			{"1008","1","waiting   ","0","4","0"},
			{"1008","2","waiting   ","0","4","0"},
			{"1008","3","waiting   ","0","3","0"},
			{"1009","1","waiting   ","0","2","0"},
			{"1009","2","waiting   ","0","2","0"}};	
	public String [][] pct2= {
			{"1001","1","waiting   ","0","1","0"},
			{"1001","2","waiting   ","0","2","0"},
			{"1001","3","waiting   ","0","1","0"},
			{"1001","4","waiting   ","0","2","0"},
			{"1001","5","waiting   ","0","2","0"},
			{"1002","1","waiting   ","0","1","0"},
			{"1003","1","waiting   ","0","1","0"},
			{"1004","1","waiting   ","0","4","0"},
			{"1005","1","waiting   ","0","1","0"},
			{"1006","1","waiting   ","0","3","0"},
			{"1006","2","waiting   ","0","4","0"},
			{"1007","1","waiting   ","0","4","0"},
			{"1007","2","waiting   ","0","4","0"},
			{"1007","3","waiting   ","0","3","0"},
			{"1008","1","waiting   ","0","2","0"},
			{"1008","2","waiting   ","0","2","0"}};	
	private String [][] pct3= {
			{"1001","1","waiting   ","0","1","0"},
			{"1002","1","waiting   ","0","2","0"},
			{"1002","2","waiting   ","0","1","0"},
			{"1002","3","waiting   ","0","3","0"},
			{"1002","4","waiting   ","0","4","0"},
			{"1003","1","waiting   ","0","1","0"},
			{"1004","1","waiting   ","0","2","0"},
			{"1004","2","waiting   ","0","3","0"},
			{"1004","3","waiting   ","0","1","0"},
			{"1005","1","waiting   ","0","3","0"},
			{"1005","2","waiting   ","0","2","0"},
			{"1006","1","waiting   ","0","2","0"},
			{"1007","2","waiting   ","0","1","0"},
			{"1008","3","waiting   ","0","1","0"},
			{"1009","1","waiting   ","0","2","0"},
			{"1009","2","waiting   ","0","2","0"}};	

	private String [][] pit={
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"},
			{"compute-1","input-1","output-1","finish"},
			{"compute-1","input-1","compute-2","output-1","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","compute-2","compute-3","compute-1","compute-2","finish"},
			{"compute-1","input-1","compute-2","compute-3","finish"},
			{"finish"},
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"},
			{"compute-1","compute-2","input-1","output-1","finish"},
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"},
			{"compute-1","compute-2","input-1","output-1","finish"},
			{"compute-1","compute-3","input-1","output-1","finish"},
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"},
			{"compute-1","input-1","output-1","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"}};

	private String [][] pit2={
			{"compute-1","input-1","output-1","finish"},
			{"compute-1","input-1","output-1","finish"},
			{"compute-1","input-1","compute-2","output-1","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","compute-2","compute-3","compute-1","compute-2","finish"},
			{"compute-1","input-1","compute-2","compute-3","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-2","compute-1","compute-3","input-1","output-1","finish"},
			{"compute-1","compute-2","input-1","output-1","finish"},
			{"compute-1","compute-2","compute-1","compute-3","input-1","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","compute-3","finish"},
			{"compute-1","compute-2","compute-3","finish"},
			{"compute-1","output-1","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-2","compute-3","input-1","output-1","finish"}};

	private String [][] pit3={
			{"compute-1","finish"},
			{"input-1","output-1","finish"},
			{"compute-1","input-1","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","input-1","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-2","finish"},
			{"compute-1","finish"},
			{"compute-1","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-3","finish"},
			{"compute-1","compute-2","compute-3","finish"},
			{"compute-1","input-1","finish"},
			{"compute-1","finish"},
			{"compute-1","compute-2","finish"}};
	
	public void setOS(int number)
	{
		if(number==1)
		{
			//clears pct and pit
			for (int i=0; i<dataPCT.length; i++)
				for (int j=0; j<dataPCT[i].length; j++)
					dataPCT[i][j]=null;
			for (int i=0; i<dataPIT.length; i++)
				for (int j=0; j<dataPIT[i].length; j++)
					dataPIT[i][j]=null;
			//writes in values for pct and pit
			for(int i=0; i<pct.length; i++)
			{
				for (int j=0; j<pct[i].length; j++)
				{
					dataPCT[i+1][j+1]=pct[i][j];
				}
			}
			for(int i=0; i<pit.length; i++)
			{
				for (int j=0; j<pit[i].length; j++)
				{
					dataPIT[i+1][j+1]=pit[i][j];
				}
			}
		}
		else if(number==2)
		{
			//clears pct and pit
			for (int i=0; i<dataPCT.length; i++)
				for (int j=0; j<dataPCT[i].length; j++)
					dataPCT[i][j]=null;
			for (int i=0; i<dataPIT.length; i++)
				for (int j=0; j<dataPIT[i].length; j++)
					dataPIT[i][j]=null;
			//writes in values for pct and pit
			for(int i=0; i<pct2.length; i++)
			{
				for (int j=0; j<pct2[i].length; j++)
				{
					dataPCT[i+1][j+1]=pct2[i][j];
				}
			}
			for(int i=0; i<pit2.length; i++)
			{
				for (int j=0; j<pit2[i].length; j++)
				{
					dataPIT[i+1][j+1]=pit2[i][j];
				}
			}
		}
		else if(number==3)
		{
			//clears pct and pit
			for (int i=0; i<dataPCT.length; i++)
				for (int j=0; j<dataPCT[i].length; j++)
					dataPCT[i][j]=null;
			for (int i=0; i<dataPIT.length; i++)
				for (int j=0; j<dataPIT[i].length; j++)
					dataPIT[i][j]=null;
			//writes in values  for pcr and pit
			for(int i=0; i<pct3.length; i++)
			{
				for (int j=0; j<pct3[i].length; j++)
				{
					dataPCT[i+1][j+1]=pct3[i][j];
				}
			}
			for(int i=0; i<pit3.length; i++)
			{
				for (int j=0; j<pit3[i].length; j++)
				{
					dataPIT[i+1][j+1]=pit3[i][j];
				}
			}
		}
	}
	//tells the number of cpus can run
	public void numCPUS(int cpus)
	{
		numberOfCPU=cpus;
	}

	//show pit
	public void showPIT()
	{
		//prints out the processes that can be run
		for (int i=1; i<dataPIT.length; i++)
		{
			// to get the id to print correctly starting at 1
			System.out.print("Process "+dataPCT[i][1]  + " Thread "+dataPCT[i][2]+": ");
			for (int j=1; j<dataPIT[i].length; j++)
			{
				if(dataPIT[i][j]!=null)
					System.out.print(dataPIT[i][j]+", ");
			}
			System.out.println();
		}
	}

	//shows the current os that is running.
	public void showPCT()
	{
		//prints out the table
		System.out.println("Process-id\tThread\t\tStatus\t  \tCPU-time-used\t    Job-priority   Current-instruction-count");
		for (int i=1; i<dataPCT.length; i++)
		{
			for (int j=1; j<dataPCT[i].length; j++)
			{
				System.out.print(dataPCT[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	
	public void pS()
	{
		
		int count=0;
		for (int i=1; i<dataPCT.length; i++)
		{
			if (dataPCT[i][3].equals("terminated"))
			{
				count++;
			}
		}
		if (count>=dataPCT.length)
		{
			System.out.println("There is no active process to list!");
		}
		else
		{
			System.out.println("Process-id\tThread\t\tStatus\t  \tCPU-time-used\t    Job-priority   Current-instruction-count");
			for (int i=1; i<dataPCT.length; i++)
			{
				if(dataPCT[i][3].equals("running   ")||dataPCT[i][3].equals("waiting   ")||dataPCT[i][3].equals("ready     "))
				{
					for (int j=1;j<dataPCT[i].length;j++)
					{
						System.out.print(dataPCT[i][j]+"\t\t");
					}
					System.out.println();
				}

			}
		}
	}
	
	public void help()
	{
		System.out.println("show pct- to show the complete contents of the process control table(PCT)");
		System.out.println("show pit- to ishow the complete contents of the process instruction table (PIT)");
		System.out.println("set numCPUs (K)- To set the system variable numCPUS to value k");
		System.out.println("ps- to show the complete contents of PCT for only active processes. A process is active\nif any of its threads is not terminated yet");
		System.out.println("kill (pid) - to kill and terminate the process pit and all its threads at the same time");
		System.out.println("exit- will terminate the program");
		System.out.println("set OS (N)- To load PCT and PIT of of OS (N) where (N) is a number set of PCT and PIT dataPCT");
	}
	
	public void kill(String id)
	{
		int num=0;
		for (int i=1; i<dataPCT.length; i++)
		{
			if(id.equals(dataPCT[i][1]) && dataPCT[i][3] != "terminated")
			{
				dataPCT[i][3]="terminated";
				num++;
			}
		}
		if(num==0)
		{
			System.out.println("id not valid");
		}
	}

	public void run ()
	{
			{
				//useful variables
				int temporary=0, count = 0, p1 = 0, p2 = 0, p3 = 0, tCount = 0;
				//check to see if how many are terminated
				
				for (int i=1; i<dataPCT.length; i++)
					if(dataPCT[i][3]=="terminated")
						tCount++;
				
				//The process begins
				if(tCount==dataPCT.length-1)
					System.out.println("There are no more processes to run");
				else
				{
					//checks to see what is waiting and running
					for (int i=1; i<dataPCT.length; i++)
					{
						if (dataPCT[i][5]=="1"&&dataPCT[i][3]!="terminated")
							p1++;
						if (dataPCT[i][5]=="2"&&dataPCT[i][3]!="terminated")
							p2++;
						if (dataPCT[i][5]=="3"&&dataPCT[i][3]!="terminated")
							p3++;
					}
					
					for (int i=1; i<dataPCT.length; i++)
					{
						//will run the first priority
						if (dataPCT[i][5].equals("1")&&dataPCT[i][3]!="terminated"&&count<numberOfCPU)
						{
							dataPCT[i][3]="running   ";
							temporary = Integer.parseInt(dataPCT[i][4]);
							temporary++;
							//increment the cpu time used and the current instruction count
							dataPCT[i][4]=temporary+"";
							dataPCT[i][6]=temporary+"";
							System.out.println("Process:"+dataPCT[i][1]+" Thread:"+dataPCT[i][2]+" "+dataPIT[i][temporary]);
							
							if(dataPIT[i][temporary].equals("finish"))
							{
								dataPCT[i][3]="terminated";
							}
							count++;
						}
						if (dataPCT[i][5].equals("2") && dataPCT[i][3]!="terminated" && count<numberOfCPU && p1<numberOfCPU)
						{
							//does not run this if statement until num CPU and the num of running/waiting first priority is lass than num of CPU
							dataPCT[i][3]="running   ";
							temporary = Integer.parseInt(dataPCT[i][4]);
							temporary++;
							//increment the cpu time used and the current instruction count
							dataPCT[i][4]=temporary+"";
							dataPCT[i][6]=temporary+"";
							System.out.println("Process:"+dataPCT[i][1]+" Thread:"+dataPCT[i][2]+" "+dataPIT[i][temporary]);
							if(dataPIT[i][temporary].equals("finish"))
							{
								dataPCT[i][3]="terminated";
							}
							count++;
						}
						if (dataPCT[i][5].equals("3") && dataPCT[i][3]!="terminated" && count<numberOfCPU && p2<numberOfCPU)
						{
							//will not run until second priority running/waiting is less than number of CPU
							dataPCT[i][3]="running   ";
							temporary = Integer.parseInt(dataPCT[i][4]);
							temporary++;
							//increment the cpu time used and the current instruction count
							dataPCT[i][4]=temporary+"";
							dataPCT[i][6]=temporary+"";
							System.out.println("Process:"+dataPCT[i][1]+" Thread:"+dataPCT[i][2]+" "+dataPIT[i][temporary]);
							if(dataPIT[i][temporary].equals("finish"))
							{
								dataPCT[i][3]="terminated";
							}
							count++;
						}
						if (dataPCT[i][5].equals("4") && dataPCT[i][3]!="terminated" && count<numberOfCPU && p3<numberOfCPU)
						{
							dataPCT[i][3]="running   ";
							temporary = Integer.parseInt(dataPCT[i][4]);
							temporary++;
							dataPCT[i][4]=temporary+"";
							dataPCT[i][6]=temporary+"";
							System.out.println("Process:"+dataPCT[i][1]+" Thread:"+dataPCT[i][2]+" "+dataPIT[i][temporary]);
							if(dataPIT[i][temporary].equals("finish"))
							{
								dataPCT[i][3]="terminated";
							}
							count++;
						}
						
					}
					
				}
		
			}
		
		
		
		
		
		
	}







}