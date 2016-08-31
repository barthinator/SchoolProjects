package test;

import com.david.core.AbstractGame;
import com.david.core.GameContainer;
import com.david.core.Renderer;

public class Game extends AbstractGame{
	public static void main(String Args[]){
		GameContainer gc = new GameContainer(new Game());
		gc.start();
	}

	@Override
	public void update(GameContainer gc, float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}
}
