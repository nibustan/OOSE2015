package Core.GameState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static final String gamename = "Bomberman";
	public static final int MENUSTATE = 0;
	public static final int PLAYSTATE = 1;
	public static final int SCORESTATE = 2;
	static int maxFPS = 60;

	// Time variables
	protected long timerStart = 0;
	protected long timerDif = 0;
	protected int timerAmountBomb = 3000; // = 3 second
	public Music music;
	public Sound powerdownS;
	public Sound powerupS;

	public Game(String gamename) {
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
		
		music = new Music("res/battle1.wav"); 
		music.setVolume(0.4f);
		music.loop();
		
		powerdownS = new Sound("res/powerdown.wav");
		powerupS = new Sound("res/powerup.wav");
	}
	
	
	public void update(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

	}

	public static void main(String[] args) {

		AppGameContainer appgc;
		try {

			appgc = new AppGameContainer(new Game(gamename), 704, 416, false);
			appgc.start();
			appgc.setTargetFrameRate(maxFPS);
		} catch (SlickException ex) {
			ex.printStackTrace();
			// Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null,
			// ex);
		}

	}
}