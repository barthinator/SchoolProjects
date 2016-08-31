public class Coord {
	private int s_x, s_y;
	Coord next, previous;
	
	public Coord(int x, int y){
		s_x = x;
		s_y = y;
	}
	public int getX(){
		return s_x;
	}
	public int getY(){
		return s_y;
	}
	
	public void setX(int s_x) {
		this.s_x = s_x;
	}
	public void setY(int s_y) {
		this.s_y = s_y;
	}
	public void setNext(Coord newNode)
	{
		next = newNode;
	}
	public Coord getNext(){
		return next;
	}
	public void setPrevious(Coord newNode){
		previous = newNode;
	}
	public Coord getPrevious(){
		return previous;
	}
	
	//Added this just to make debugging easier
	public String toString() {
		return "Coord [x=" + s_x + ", y=" + s_y + "]";
	}
}