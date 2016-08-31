
	/*******************Program Identification ************************************************/
	/* COURSE: CS 380		 Data Structures 				                   				  */
	/* PROJECT # : 2    				                   			        				  */
	/* DUE DATE : February 17, 2016							        					      */
	/* SOURCE FILE :  List.java, Node.java, TestList.java                                     */
	/* Instructor: Dr. Samuel Sambasivam                                                      */
	/*                                                                                        */
	/* Student Name: David Bartholomew                                                        */
	/* Student ID: 002510408       					        								  */
	/******************************************************************************************/

	/**************** Program Description *****************************************************/
	/* INPUT : The program requires no input, unless the user would like to change            */
	/* 		the TestList main function and call methods from List                             */
	/* 		This would allow the user to manually create their own credit card list and       */
	/* 		manipulate it how they would desire.                                    		  */
	/* OUTPUT : Manipulation of the Credit Card list, that is printed to the console          */
	/* USER-DEFINED MODULES: All of the methods      						                  */
	/* PROCESS : Run the program and the processes will automatically start                   */
	/******************************************************************************************/


	/******************************************************************************************/

public class TestList {
	public static void main(String[] args) {
		
	    System.out.println();
	    System.out.println ( "David Bartholomew      002510408      CS 380  ");
	    System.out.println ( "  Spring 2016   Project # 2");
	    System.out.println ();
	    System.out.println ();
		
		List testList = new List();
		List emptyList = new List();
		
		System.out.println("**************APPENDING*****************");
		System.out.println("This will show some examples of appending:");
		testList.append(new Node("Alyssa Brown", 1000.45));
		testList.showStructure();
		testList.append(new Node("David Bartholomew", 99999.99));
		testList.showStructure();
		System.out.println();
		
		
		System.out.println("**************CLEAR*****************");
		System.out.println("Here is an example of clearing the testList:");
		testList.clear();
		testList.showStructure();
		System.out.println();
		
		
		System.out.println("**************ISEMPTY*****************");
		System.out.println("Here is an example of checking to see if the testList is empty:");
		System.out.println(testList.isEmpty());
		System.out.println("Let's now append some items then test it:");
		testList.append(new Node("Alyssa Brown", 1000.45));
		testList.append(new Node("David Bartholomew", 99999.99));
		testList.showStructure();
		System.out.println("Now lets test if it is empty");
		System.out.println(testList.isEmpty());
		System.out.println();
		
		
		System.out.println("**************ISFULL*****************");
		System.out.println("There is no way to really test this to see if something is full...");
		System.out.println("But we can test to see if a list is not full!");
		System.out.println(testList.isFull());
		System.out.println();
		
		
		System.out.println("**************INSERTBEGINNING*****************");
		System.out.println("Let's try this out on the testList:");
		testList.insertBeginning(new Node("Shrek Farquad", 1234.67));
		testList.showStructure();
		
		System.out.println("Lets try it out on an empty list");
		emptyList.showStructure();
		emptyList.insertBeginning(new Node("Barry Mongito", 1267.67));
		emptyList.showStructure();
		emptyList.clear();
		System.out.println();
		
		
		System.out.println("**************INSERTAFTER*****************");
		System.out.println("Lets insert Jev after Alyssa Brown");
		System.out.println(testList.insertAfter("Alyssa Brown", new Node("Jev", 60.00)));
		testList.showStructure();
		
		System.out.println("Lets insert after David Bartholomew");
		System.out.println(testList.insertAfter("David Bartholomew", new Node("Pamaj", 100.90)));
		testList.showStructure();
		System.out.println();
		
		System.out.println("**************INSERTBEFORE*****************");
		System.out.println("Lets insert before Alyssa Brown");
		System.out.println(testList.insertBefore("Alyssa Brown", new Node("Hunter Davis", 5000000.00)));
		testList.showStructure();
		
		System.out.println("Lets insert after David Bartholomew");
		System.out.println(testList.insertBefore("David Bartholomew", new Node("Trevor Sparkman", 4.15)));
		testList.showStructure();
		System.out.println();
		
		
		System.out.println("**************UPDATE*****************");
		System.out.println("Let's update David Bartholomew's balance");
		System.out.println(testList.update("David Bartholomew", 50.00));
		testList.showStructure();
		
		System.out.println("Let's try it on an invalid name");
		System.out.println(testList.update("Barry", 7989));
		System.out.println();
		
		System.out.println("**************ERASE*****************");
		System.out.println("Let's erase David Bartholomew from the list, he's not important :)");
		System.out.println(testList.erase("David Bartholomew"));
		testList.showStructure();
		
		System.out.println("Let's erase the last node, which is Pamaj");
		System.out.println(testList.erase("Pamaj"));
		testList.showStructure();
		System.out.println();
		
		System.out.println("**************CONTAINS*****************");
		System.out.println("Lets see if the list contains Jev");
		System.out.println(testList.contains("Jev"));
		
		System.out.println("Let's see if it contains an invalid name");
		System.out.println(testList.contains("Chicken"));
		System.out.println();
		
		System.out.println("**************GET*****************");
		System.out.println("Let's get Jev");
		System.out.println(testList.get("Jev"));
		System.out.println("Let's try a name that isn't in the list");
		System.out.println(testList.get("Cary"));
		
	}

}