
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

public class CreditCard {
	private String name;
	private double balance;
	
	/////////////////////////////////////////////
	//          Default Constructor           //
	///////////////////////////////////////////
	
	public CreditCard() {
		this.name = "";
		this.balance = 0.0;
	}
	
	/////////////////////////////////////////////
	//       Overloaded Constructor           //
	///////////////////////////////////////////
	
	public CreditCard(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	/////////////////////////////////////////////
	//          Getters/Setters               //
	///////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	/////////////////////////////////////////////
	//          FUNCTION toString             //
	///////////////////////////////////////////
	
	public String toString() {
		return "CreditCard [name=" + name + ", balance=" + balance + "]";
	}

}
