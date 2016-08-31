
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

public class CreditCardList {
	
	private static final int MAX_SIZE = 100;
	private int size;
	private int cursor;
	private CreditCard[] cardList;
	
	
	/////////////////////////////////////////////
	//            FUNCTION setup              //
	///////////////////////////////////////////
	
	public void setup(int number){
		cardList = new CreditCard[number];
		//How many objects are in the array, not the size of the array
		size = 0;
		cursor = -1;
	}
	
	/////////////////////////////////////////////
	//         DEFAULT CONSTRUCTOR            //
	///////////////////////////////////////////
	
	public CreditCardList() {
		setup(MAX_SIZE);
	}
	
	/////////////////////////////////////////////
	//      OVERLOADED CONSTRUCTOR            //
	///////////////////////////////////////////
	
	public CreditCardList(int maxNumber) {
		setup(maxNumber);
	}
	
	/////////////////////////////////////////////
	//         FUNCTION isEmpty               //
	///////////////////////////////////////////
	
	/**Checks to see if the list is empty or not.**/
	public boolean isEmpty(){
		return size == 0;
	}
	
	/////////////////////////////////////////////
	//         FUNCTION isFull                //
	///////////////////////////////////////////
	
	/**Checks to see if the list is full or not**/
	public boolean isFull(){
		return size >= cardList.length;
	}
	
	
	/////////////////////////////////////////////
	//        FUNCTION showStructure          //
	///////////////////////////////////////////
	
	/**Function used to print out the current structure of the cardList. The list must not be empty
	 * it to work.**/
	public void showStructure(){
		if (isEmpty()){
			System.out.println("Empty list");
		}
		else{
			System.out.println("size = " + size + " cursor = " + cursor + "\n");
			for(int index = 0; index < size; index++){
					System.out.println("(" + cardList[index].getName() + ", " + cardList[index].getBalance() + ")");
			}
			System.out.println();
		}
	}
	
	/////////////////////////////////////////////
	//          FUNCTION append               //
	///////////////////////////////////////////
	
	/** This function adds the card that is input at the end of the list.
	 * The list must not be full for it to work. **/
	public void append(CreditCard newCard){
		if (isFull()){
			System.out.println("The list is full.");
		}
		else{
			cursor = size++;
			cardList[cursor] = newCard;
		}	
	}
	
	/////////////////////////////////////////////
	//          FUNCTION clear                //
	///////////////////////////////////////////
	
	/**This function clears the list **/
	public void clear(){
		cardList = new CreditCard[cardList.length];
		size = 0;
	}
	
	/////////////////////////////////////////////
	//       FUNCTION gotoBeginning           //
	///////////////////////////////////////////
	
	/**This function moves the cursor to the beginning of the list, but the list must not
	 * be empty for it to work**/
	public boolean gotoBeginning(){
		if (!isEmpty()){
			cursor = 0;
			return true;
		}
		else{
			System.out.println("The list is empty");
			return false;
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION gotoEnd               //
	///////////////////////////////////////////
	
	/**This function moves he cursor to the end of the list, but the list must not be empty
	 * for it to run. **/
	public boolean gotoEnd(){
		if(!isEmpty()){
			cursor = size - 1;
			return true;
		}
		else{
			System.out.println("The list is empty.");
			return false;
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION gotoNext              //
	///////////////////////////////////////////
	
	/**This function moves he cursor to the next card in the list, but the list must not be empty
	 * for it to run. **/
	public boolean gotoNext(){
		if(!isEmpty()){
			if (cursor + 1 < size){
				cursor++;
				return true;
			}
			else{
				System.out.println("The cursor is at the end of the list");
				return false;
			}
		}
		else{
			System.out.println("The list is empty");
			return false;
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION gotoPrior             //
	///////////////////////////////////////////
	
	/**This function moves the cursor to the previous item in the list if the list is
	 * empty. **/
	public boolean gotoPrior(){
		if(!isEmpty()){
			cursor -= 1;
			return true;
		}
		else{
			System.out.println("The list is empty");
			return false;
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION getCursor             //
	///////////////////////////////////////////
	
	/**This function returns the CreditCard that is currently at the cursor's position. 
	 * The list must not be empty for it to run. **/
	public CreditCard getCursor(){
		if(!isEmpty()){
			return cardList[cursor];
		}
		else{
			System.out.println("The list is empty");
			return null;
		}
	}
	
	
	/////////////////////////////////////////////
	//       FUNCTION insertBeginng           //
	///////////////////////////////////////////
	
	/**This function inserts the CreditCard that is input at the beginning of the list, and then
	 * moves everything that was in the list over. If the list is empty, then it will insert
	 * the card as the first and only credit card in the list. Also the function will only execute
	 * if the list is not full. **/
	public void insertBeginning (CreditCard newCreditCard){
		if (!isFull()){
			cursor = 0;
			CreditCard[] tempList = new CreditCard[cardList.length];
			tempList[cursor] = newCreditCard;
			//Originally was trying to manually copy data with a for loop, but then I found out about this
			//handy method that can be used to copy arrays.
			System.arraycopy(cardList, 0, tempList, 1, size);
			size++;
			cardList = tempList;
		}
		else{
			System.out.println("The list is full");
		}
	}
	
	/////////////////////////////////////////////
	//         FUNCTION insert                //
	///////////////////////////////////////////
	
	/**This function creates a card with the data that is input, then inserts that card at the
	 * current position of the cursor, then moves everything(if anything) to the right of it over.
	 * In this function the checker variable is used to be able to return a boolean value and is
	 * set as false if the name already exists in the list or if the list is full.**/
	public boolean insert(String name, double balance){
		boolean checker = true;
		//Checks to see if any card has the same name
		for (int index = 0; index < size; index++){
			if(cardList[index].getName().equalsIgnoreCase(name)){
				checker = false;
			}
		}
		
		//Checks to see if the list is full and the checker is true so that the inserting
		//process can begin.
		if (!isFull() && checker){
			//The tempCard variable is where the temporary data from the cardList is stored.
			CreditCard tempCard = new CreditCard(name, balance);
			CreditCard[] tempList = new CreditCard[cardList.length];
			//It must check to see if the list isn't empty.
			if (size > 0){
				tempList[cursor] = tempCard;
				System.arraycopy(cardList, 0, tempList, 0, cursor);
				System.arraycopy(cardList, cursor, tempList, cursor+1, size-cursor);
				cardList = tempList;
			}
			else{
				cardList[0] = tempCard;
			}
			cursor++;
			size++;
		}
		else if(!checker){
			System.out.println("That name is already on a card in this list");
		}
		else{
			System.out.println("The list is full");
			checker = false;
		}
		
		return checker;
	}
	
	
	/////////////////////////////////////////////
	//         FUNCTION update                //
	///////////////////////////////////////////
	
	/**This function takes in a name and balance, and if the name is equal to a name that 
	 * is already in the list then it will replace the balance that is in that current card
	 * with the updated new balance. The function must not be empty for it to run. **/
	public boolean update(String name, double balance){
		boolean checker = false;
		if (!isEmpty()){
			//Checks to find the matching card. And assigns the new balance.
			for(int index = 0; index < size; index++){
				if(cardList[index].getName().equalsIgnoreCase(name)){
					cardList[index].setBalance(balance);
					checker = true;
				}
				else if (checker){
					break;
				}
			}
			return checker;
		}
		else{
			System.out.println("The list is empty");
			return checker;
		}
	}
	
	/////////////////////////////////////////////
	//          FUNCTION erase                //
	///////////////////////////////////////////
	
	/**This function will erase the card with the matching name. Then after erasing the card
	 * it decrease the size by one, and move the cursor to the previous card unless the cursor is
	 * already at the beginning position. The eraseKey variable is used to note the location of
	 * the object that is being erased in he original array. **/
	public boolean erase(String name, double balance){
		boolean checker = true;
		CreditCard[] tempList = new CreditCard[cardList.length];
		int eraseKey = -1;
		
		if(!isEmpty() && checker){
			for (int index = 0; index < size; index++){
				if (cardList[index].getName().equalsIgnoreCase(name)){
					eraseKey = index;
				}
			}
			
			//If the eraseKey is -1 then that means that it could not have found a possible name match
			if(eraseKey == -1){
				System.out.println("That name does not exist in the list");
				checker = false;
			}
			
			//Here is where the erase process happens.
			System.arraycopy(cardList, 0, tempList, 0, eraseKey);
			System.arraycopy(cardList, eraseKey+1, tempList, eraseKey, size-eraseKey-1);
			cardList = tempList;
			size--;
			
			//If the erase key is at the beginning of the list, then it will keep the cursor at 0,
			//else it will set the cursor to the eraseKey-1(the term previous to what was erased).
			if (eraseKey < 1){
				cursor = eraseKey;
			}
			else{
				cursor = eraseKey-1;
			}
		}
		else{
			System.out.println("The list is empty");
			checker = false;
		}
		
		return checker;
	}
	
	/////////////////////////////////////////////
	//         FUNCTION contains              //
	///////////////////////////////////////////
	
	/**This function just checks to see if the name that is input matches the name of any card in
	 * the list, if so, then the function will return true.**/
	public boolean contains(String name, double balance){
		boolean checker = false;
		for(int index = 0; index < size; index++){
			if (cardList[index].getName().equalsIgnoreCase(name)){
				checker = true;
			}
			else if(checker){
				break;
			}
		}
		return checker;
	}
	
	/////////////////////////////////////////////
	//           FUNCTION get                 //
	///////////////////////////////////////////
	
	/**This function will retrieve the card according to the name that is input. It will return
	 * the CreditCard object to the user.**/
	public CreditCard get(String name){
		CreditCard checker = null;
		for(int index = 0; index < size; index++){
			if (cardList[index].getName().equalsIgnoreCase(name)){
				checker = cardList[index];
			}
			else if(checker != null){
				break;
			}
		}
		
		//So that it can return an empty Credit Card, instead of a null value which would cause an error
		if (checker == null){
			checker = new CreditCard();
		}
		
		return checker;
	}
	
}
