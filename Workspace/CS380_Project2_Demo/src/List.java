
public class List {
	private int size;
	private Node head;
	
	private void setup(){
		size = 0;
		head = new Node();
		head.setPrev(head);
		head.setNext(head);
		return;
	}
	
	public List(){
		setup();
	}
	
	public void append(Node newNode){
		newNode.setNext(head); //1
		newNode.setPrev(head.getPrev()); //2
		head.getPrev().setNext(newNode); //3
		head.setPrev(newNode); //4
		size++;
	}
	
	public void showStructure(){
		if(size == 0){
			System.out.println("Empty List");
		}
		else{
			System.out.println("size = " + size);
			for (Node temp = head.getNext(); temp != head; temp = temp.getNext())
				System.out.println(temp.toString());
		}
	}
}
