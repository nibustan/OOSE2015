package Core.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ScoreState extends BasicGameState{

	//Image i;
	
	public ScoreState(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		//i = new Image(res/smth.png)
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		g.drawString("Scoreboard", 50, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_Z)){
			sbg.enterState(0);
		}
	}

	@Override
	public int getID() {

		return 2;
	}
	
}
