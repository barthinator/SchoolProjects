import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener{
	int x = 0;
	int y = 0;

	public boolean right = true;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	
	public boolean gameOver;
	
	public final static int SPEED = 50;
	public int score = 0;
	
	public Coord mouseLocation;

	public ArrayList<Coord> coords = new ArrayList<Coord>();

	public Game(){
		gameOver = false;
		score = 0;
		mouseLocation = spawnMouse();
		coords.add(new Coord(0, 0));
		coords.add(new Coord(-10, 0));
		coords.add(new Coord(-20, 0));
		coords.add(new Coord(-30, 0));
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) && (!right)) {
			left = true;
			up = false;
			down= false;
		}

		if ((key == KeyEvent.VK_RIGHT) && (!left)) {
			right = true;
			up = false;
			down = false;
		}

		if ((key == KeyEvent.VK_UP) && (!down)) {
			up = true;
			right = false;
			left = false;
		}

		if ((key == KeyEvent.VK_DOWN) && (!up)) {
			down = true;
			right = false;
			left = false;
		}
	}

	public boolean getDir(){
		if(right){
			return right;
		}
		else if(left){
			return left;
		}
		else if(up){
			return up;
		}
		else{
			return down;
		}
	}
	
	private Coord spawnMouse(){
		Random rand = new Random();
		int factor = 10;
		int  x = factor*(rand.nextInt(29) + 1);
		int  y = factor*(rand.nextInt(38) + 1);
		
		System.out.println(x + " " + y);
		
		return new Coord(x, y);
	}
	
	public void checkCollision(){
		if(coords.get(0).getX() == mouseLocation.getX() && coords.get(0).getY() == mouseLocation.getY()){
			mouseLocation = spawnMouse();
			coords.add(new Coord(-10, -10));
			score++;
		}
		
		
		 for (int z = coords.size() - 1; z > 0; z--) {

	            if ((z > 3) && (coords.get(0).getX() == coords.get(z).getX()) && (coords.get(0).getY() == coords.get(z).getY())) {
	                System.out.println("Game Over");
	                gameOver = true;
	            }
	        }
		
		if (coords.get(0).getY() >= 390) {
            System.out.println("Game over");
            gameOver = true;
        }

        if (coords.get(0).getY() < 0) {
        	System.out.println("Game over");
        	gameOver = true;
        }

        if (coords.get(0).getX() >= 300) {
        	System.out.println("Game over");
        	gameOver = true;
        }

        if (coords.get(0).getX() < 0) {
        	System.out.println("Game over");
        	gameOver = true;
        }
        
	}


	private void moveSnake() {

		for(int i = coords.size() - 1; i > 0; i--){
			coords.get(i).setX(coords.get(i - 1).getX());
			coords.get(i).setY(coords.get(i - 1).getY());
		}
		
		if(getDir() == right){
				coords.get(0).setX(coords.get(0).getX() + 10);
		}

		if(getDir() == left){
			coords.get(0).setX(coords.get(0).getX() - 10);
		}

		if(getDir() == down){
			coords.get(0).setY(coords.get(0).getY() + 10);
		}

		if(getDir() == up){
			coords.get(0).setY(coords.get(0).getY() - 10);
		}
		
		checkCollision();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Font font = new Font("Serif", Font.BOLD, 15);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(mouseLocation.getX(), mouseLocation.getY(), 10, 10);
		
		
		for(int i = 0; i < coords.size(); i++){
			g2d.fillRect(coords.get(i).getX(), coords.get(i).getY(), 10, 10);
		}
		
		
		g.setFont(font);
		String disScore = "" + (100*score);
		g.drawString(disScore, 0, 10);
		
		if(gameOver){
			font = new Font("Serif", Font.BOLD, 18);
			g.setFont(font);
			String name = "GAME OVER";
			g.drawString(name, 80, 200);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Sample Frame");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 410);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true && !game.gameOver) {
			game.moveSnake();
			game.repaint();
			Thread.sleep(SPEED);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
