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
	public static int fireLayer;
	public static int player1Layer1;
	public static int player1Layer2;
	public static int player1Layer3;
	public static int player1Layer4;
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
		fireLayer = map.getLayerIndex("FireLayer");
		player1Layer1 = map.getLayerIndex("Player1Layer1");
		player1Layer2 = map.getLayerIndex("Player1Layer2");
		player1Layer3 = map.getLayerIndex("Player1Layer3");
		player1Layer4 = map.getLayerIndex("Player1Layer4");
		
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
		
		//Live Render For-loop
		for(int x = 0; x<22; x++){
			for(int y = 0; y<13; y++){
				//Boxes
				if(map.getTileId(x, y, boxLayer) == 94){
					map.render(x*32, y*32, 15, 0, 1, 1);
				}
				//Fire
				if(map.getTileId(x, y, fireLayer) == 123){
					map.render(x*32, y*32, 16, 0, 1, 1);
				}
				//Player
				if(map.getTileId(x, y, player1Layer1) != 241 && map.getTileId(x, y, player1Layer2) != 0){
					map.render(x*32, y*32, 15, 3, 1, 1);
				}
				if(map.getTileId(x, y, player1Layer2) != 242 && map.getTileId(x, y, player1Layer2) != 0){
					map.render(x*32, y*32, 15, 5, 1, 1);
				}
				if(map.getTileId(x, y, player1Layer3) != 243 && map.getTileId(x, y, player1Layer3) != 0){
					map.render(x*32, y*32, 15, 7, 1, 1);
				}
				if(map.getTileId(x, y, player1Layer4) != 244 && map.getTileId(x, y, player1Layer4 ) != 0){
					map.render(x*32, y*32, 15, 9, 1, 1);
				}
				
			}
			
		}

	
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
