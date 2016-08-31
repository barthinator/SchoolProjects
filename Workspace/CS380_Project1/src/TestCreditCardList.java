
	/*******************Program Identification ************************************************/
	/* COURSE: CS 380		 Data Structures 				                   				  */
	/* PROJECT # : 1    				                   			        				  */
	/* DUE DATE : February 3, 2016							        					      */
	/* SOURCE FILE :  CreditCard.java, TestCreditCardList.java, CreditCardList.java           */
	/* Instructor: Dr. Samuel Sambasivam                                                      */
	/*                                                                                        */
	/* Student Name: David Bartholomew                                                        */
	/* Student ID: 002510408       					        								  */
	/******************************************************************************************/

	/**************** Program Description *****************************************************/
	/* INPUT : The program requires no input, unless the user would like to change            */
	/* 		the TestCreditCardList main function and call methods from CreditCardList.        */
	/* 		This would allow the user to manually create their own credit card list and       */
	/* 		manipulate it how they would desire.                                    		  */
	/* OUTPUT : Manipulation of the Credit Card list, that is printed to the console          */
	/* USER-DEFINED MODULES: All of the methods **Not sure what this means**                  */
	/* PROCESS : Run the program and the processes will automatically start                   */
	/******************************************************************************************/


	/******************************************************************************************/

public class TestCreditCardList {
	public static void main(String[] args){
		
	    System.out.println();
	    System.out.println ( "David Bartholomew      002510408      CS 380  ");
	    System.out.println ( "  Spring 2016   Project # 1");
	    System.out.println ();
	    System.out.println ();

		CreditCardList samsList = new CreditCardList();
		CreditCardList dansList = new CreditCardList(8);
		CreditCardList emptyList = new CreditCardList();
		CreditCardList fullList = new CreditCardList(2);
		
		CreditCard card1 = new CreditCard("Ali", 123.45);
		CreditCard card2 = new CreditCard("Joe", 11123.45);
		CreditCard card3 = new CreditCard("Mary", 111123.45);
		CreditCard card4 = new CreditCard("Chick", 1244123.45);
		CreditCard card5 = new CreditCard("Barry", 989123.45);
		
		fullList.append(card3);
		fullList.append(card4);
		
		
		System.out.println("**************APPENDING*****************");
		System.out.println("Shows that cards can be appended too a list:\n");
		System.out.println("The lists prior to being appended:\n");
		samsList.showStructure();
		dansList.showStructure();
		System.out.println("");
		
		samsList.append(card1);
		samsList.append(card2);
		
		dansList.append(card3);
		dansList.append(card4);
		dansList.append(card5);
		
		System.out.println("The lists after being appended too:");
		samsList.showStructure();
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("**************CLEARING*****************");
		System.out.println("An example of clearing samsList:");
		System.out.println("Prior to clearing:");
		samsList.showStructure();
		samsList.clear();
		System.out.println("After being cleared:");
		samsList.showStructure();
		System.out.println("");
		
		System.out.println("**************CURSOR MANIPULATION*****************");
		System.out.println("Moving the cursor in dansList:");
		System.out.println("Prior to moving the cursor:");
		dansList.showStructure();
		System.out.println("After calling gotoBeginning:");
		dansList.gotoBeginning();
		dansList.showStructure();
		System.out.println("After calling gotoEnd:");
		dansList.gotoEnd();
		dansList.showStructure();
		System.out.println("After calling gotoPrior:");
		dansList.gotoPrior();
		dansList.showStructure();
		System.out.println("After calling gotoNext:");
		dansList.gotoNext();
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("**************INSERTBEGINNING*****************");
		System.out.println("This will show exmples of using the insertBeginning method and"
				+ "\ntesting it with different situations and cases that can occur");
		System.out.println("An example of insertBeginning with samsList:");
		System.out.println("Prior to being manipulated:");
		samsList.showStructure();
		samsList.insertBeginning(card5);
		System.out.println("After being manipulated:");
		samsList.showStructure();
		System.out.println("\nAn example of trying to call insertBeginning if the list is full:");
		fullList.insertBeginning(card5);
		System.out.println("\nAn example of calling insertBeginning when the list is empty:");
		System.out.println("Prior to being manipulated:");
		emptyList.showStructure();
		emptyList.insertBeginning(card1);
		System.out.println("After adding a card to emptyList:");
		emptyList.showStructure();
		emptyList.clear();
		
		System.out.println("**************INSERT*****************");
		System.out.println("This will show exmaples of using the insert method and"
				+ "\ntesting it with different situations and cases that can occur");
		System.out.println("An classic example of insert on dansList:");
		System.out.println("Prior to inserting:");
		dansList.showStructure();
		System.out.println(dansList.insert("Trevor", 34567.87));
		dansList.showStructure();
		
		System.out.println("Trying to insert when someone in the list already has the name:");
		System.out.println(dansList.insert("Barry", 989123.45));
		System.out.println("\n");
		
		System.out.println("Inserting to a list that is full:");
		System.out.println(fullList.insert("Monica", 223.45));
		System.out.println("");
		
		System.out.println("Inserting at the beginning of a list:");
		System.out.println("First must set the cursor to the beginning:");
		dansList.gotoBeginning();
		dansList.showStructure();
		System.out.println(dansList.insert("Yvette", 5000.00));
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("Inserting near the end of a list:");
		System.out.println("First must set the cursor to the end:");
		dansList.gotoEnd();
		dansList.showStructure();
		System.out.println(dansList.insert("Hunter", 7500.25));
		dansList.showStructure();
		System.out.println("");
		
		
		System.out.println("**************UPDATE*****************");
		System.out.println("This will demonstrate updating a card in various manners, this function"
				+ "\nallows for the user to change the balance of a card in the list.");
		System.out.println("This will demonstrate changing the balance of Barry in samsList:");
		samsList.showStructure();
		System.out.println(samsList.update("Barry", 345.98));
		samsList.showStructure();
		System.out.println("");
		
		System.out.println("Here is an example of trying with an empty list");
		emptyList.clear();
		emptyList.showStructure();
		System.out.println(emptyList.update("Ali", 1000));
		System.out.println("");
		
		System.out.println("Here is an example of updating a list but giving an invalid name:");
		System.out.println(samsList.update("Hugo", 1000));
		
		
		System.out.println("**************ERASE*****************");
		System.out.println("This will demonstrate the erase function and different examples"
				+ "\nshowcasing it.");
		System.out.println("A classic example erasing Chick from dansList");
		dansList.showStructure();
		System.out.println(dansList.erase("Chick", 1244123.45));
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("Erasing Yvette from the beginning of the list");
		dansList.showStructure();
		System.out.println(dansList.erase("Yvette", 5000.00));
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("Erasing Barry from the end of dansList");
		dansList.showStructure();
		System.out.println(dansList.erase("Barry", 345.98));
		dansList.showStructure();
		System.out.println("");
		
		System.out.println("Trying to erase from an empty list:");
		System.out.println(emptyList.erase("Gary", 1000));
		System.out.println("");
		
		
		System.out.println("**************CONTAINS/GET*****************");
		System.out.println("First lets demonstrate the contains method with dansList:");
		System.out.println("Here is an example with Hunter");
		dansList.showStructure();
		System.out.println(dansList.contains("Hunter", 7500.25));
		System.out.println("");
		
		System.out.println("Here is an example with Shrek who is not in the list");
		dansList.showStructure();
		System.out.println(dansList.contains("Shrek", 1000));
		System.out.println("");
		
		System.out.println("Now lets demonstrate the get method with Barry from samsList:");
		samsList.showStructure();
		System.out.println(samsList.get("Barry"));
		System.out.println("");
		
		System.out.println("Lets try this Farquad, who doesn't exist in samsList:");
		samsList.showStructure();
		System.out.println(samsList.get("Farquad"));
		
		System.out.println ();
		System.out.println ();
		System.out.println ( "END OF OUTPUT");
		System.out.println ();

	
	}
}
