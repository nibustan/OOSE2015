package Core.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState{
	
	

	public MenuState(int state){
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		g.drawString("Menu", 50, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_Z)){
			sbg.enterState(1);
		}
	}

	@Override
	public int getID() {

		return 0;
	}

}
