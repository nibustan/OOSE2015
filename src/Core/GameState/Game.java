package Core.GameState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{
	
	public static final String gamename = "Bomberman";
	public static final int MENUSTATE = 0;
	public static final int PLAYSTATE = 1;
	public static final int SCORESTATE = 2;
	static int maxFPS = 60;
	
	
	public Game(String gamename)
	{
		super(gamename);
		this.addState(new MenuState(MENUSTATE));
		this.addState(new PlayState(PLAYSTATE));
		this.addState(new ScoreState(SCORESTATE));
		enterState(PLAYSTATE);
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENUSTATE).init(gc, this);
		this.getState(PLAYSTATE).init(gc, this);
		this.getState(SCORESTATE).init(gc, this);
	}

	public void update(GameContainer gc, StateBasedGame sbg) throws SlickException {
			
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}
 
        public static void main(String[] args) {
        	
        	AppGameContainer appgc;
        	try
    		{
    			
    			appgc = new AppGameContainer(new Game(gamename),704, 416, false);
    			appgc.start();
    			appgc.setTargetFrameRate(maxFPS);
    		}
        	catch (SlickException ex)
    		{
        		ex.printStackTrace();
    			//Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
    		}
        	          
        }       
}