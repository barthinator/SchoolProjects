package com.david.core;

public class GameContainer implements Runnable{
	
	private Thread thread;
	private AbstractGame game;
	private Window window;
	private Renderer renderer;
	
	
	private int width = 320, height = 240;
	private float scale = 2.0f;
	private String title = "Not Sure Yet";
	
	
	private double frameCap = 1.0 / 60.0;
	private boolean isRunning = false;
	
	public GameContainer(AbstractGame game){
		this.game = game;
	}
	
	public void start(){
		if (isRunning)
			return;
		
		window = new Window(this);
		renderer = new Renderer(this);

		thread = new Thread(this);
		thread.run();
		
	}
	
	public void stop(){
		if(!isRunning)
			return;
		
		isRunning = false;
	}
	
	public void run(){
		isRunning = true;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0; //
		double passedTime = 0;
		double unprocessedTime = 0;
		double frameTime = 0;
		int frames = 0;
		
		while(isRunning){
			
			boolean render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;

			
			while(unprocessedTime >= frameCap){
				game.update(this, (float)frameCap);
				unprocessedTime -= frameCap;
				render = true;
				
				if(frameTime >= 1){
					frameTime = 0;
					System.out.println(frames);
					frames = 0;
				}
			}
			
			if(render){
				renderer.clear();
				//game.render(this.r);
				window.update();
				frames++;
			}
			else{
				try {
					thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	private void cleanUp(){
		window.cleanUp();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Window getWindow() {
		return window;
	}

}
