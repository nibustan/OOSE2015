package Core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
//import org.newdawn.slick.tiled.TiledMap;

public class Game extends StateBasedGame{
	
	public static final String gamename = "Bomberman";
	public static final int MENUSTATE = 0;
	public static final int PLAYSTATE = 1;
	public static final int SCORESTATE = 2;
	
	public Game(String gamename)
	{
		super(gamename);
		this.addState(new MenuState(MENUSTATE));
		this.addState(new PlayState(PLAYSTATE));
		this.addState(new ScoreState(SCORESTATE));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENUSTATE).init(gc, this);
		this.getState(PLAYSTATE).init(gc, this);
		this.getState(SCORESTATE).init(gc, this);
		this.enterState(MENUSTATE);
	}

	/*@Override
	public void update(GameContainer gc, int i) throws SlickException {
			
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("hundreth change to program", 300, 200);
	}*/
 
        public static void main(String[] args) {
        	
        	AppGameContainer appgc;
        	try
    		{
    			
    			appgc = new AppGameContainer(new Game(gamename), 800, 600, false);
    			appgc.start();
    		}
        	catch (SlickException ex)
    		{
        		ex.printStackTrace();
    			//Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
    		}
        	          
        }       
}