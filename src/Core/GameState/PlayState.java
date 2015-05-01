package Core.GameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Core.Player.Player;

public class PlayState extends BasicGameState{	
	
	public static TiledMap map;
	public static int wallLayer;
	public static int boxLayer;
	int floorLayer;
	
	Player player1 = new Player();
	Player player2 = new Player();
	
	public PlayState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		//TiledMap setup initialization
		map = new TiledMap("res/map.tmx");
		boxLayer = map.getLayerIndex("Boxes");
		wallLayer = map.getLayerIndex("Wall");
		floorLayer = map.getLayerIndex("Floor");
		
		//Player data setup initialization
		//Player 1
		player1.x = 1;
		player1.y = 1;
		
		player1.bombLength = 1;
		
		player1.bombButton = "KEY_ENTER";
		player1.right = "KEY_D";
		player1.left = "KEY_A";
		player1.up = "KEY_W";
		player1.down = "KEY_S";
		
		//Player 2
		player2.x = 13;
		player2.y = 11;
		
		player2.bombLength = 1;
		
		player2.bombButton = "KEY_NUMPAD0";
		player2.right = "KEY_NUMPAD6";
		player2.left = "KEY_NUMPAD4";
		player2.up = "KEY_NUMPAD8";
		player2.down = "KEY_NUMPAD2";
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		//GUI
		g.drawString("P1 Blvl = "+ String.valueOf(player1.bombLength), 540, 50);
		g.drawString("P2 Blvl = "+ String.valueOf(player2.bombLength), 540, 350);
		
		
		
		//Render Map
		map.render(0, 0, floorLayer);
		
		map.render(0, 0, wallLayer);
		
		//Render Boxes
		for(int x = 0; x<22; x++){
			for(int y = 0; y<13; y++){
				if(map.getTileId(x, y, boxLayer) != 0){
					map.render(x*32, y*32, 15, 0, 1, 1);
				}
			}
		}
		
		//Render player1s
				g.fillRect(player1.x * 32, player1.y * 32, 32, 32);
				g.fillRect(player2.x * 32, player2.y * 32, 32, 32);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {

		//Change State
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			sbg.enterState(2);
		}
		
		player1.movement(gc);
		player1.placeBomb(gc);
		player2.movement(gc);
		player2.placeBomb(gc);
		
		if (gc.getInput().isKeyPressed(Input.KEY_U)) {
			if(player1.bombLength <4 ){
			player1.bombLength++;
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_Y)) {
			if(player2.bombLength <4 ){
			player2.bombLength++;
			}
		}
		
	}

	@Override
	public int getID() {
		return 1;
	}
	
}
