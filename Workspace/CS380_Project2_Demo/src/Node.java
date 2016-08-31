public class Node {
	
	private String name;
	private double balance;
	private Node next, prev;
	
	public Node(){
		this.name = "";
		this.balance = 0.0;
		this.prev = null;
		this.next = null;
	}
	
	public Node(String name, double balance){
		this.name = name;
		this.balance = balance;
		this.prev = null;
		this.next = null;
	}

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

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public String toString() {
		return "Node [name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}
