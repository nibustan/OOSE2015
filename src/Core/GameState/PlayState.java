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
	public static int floorLayer;
	
	public PlayState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		map = new TiledMap("res/map.tmx");
		boxLayer = map.getLayerIndex("Boxes");
		wallLayer = map.getLayerIndex("Wall");
		floorLayer = map.getLayerIndex("Floor");
		Player.x = 1;
		Player.y = 1;
		Player.bombLength1 = 1;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		//GUI
		g.drawString("P1 Blvl = "+ String.valueOf(Player.bombLength1), 540, 50);
		
		
		
		//Render Map
		map.render(0, 0, floorLayer);
		
		map.render(0, 0, wallLayer);
		
		//Render Boxes
		for(int x = 1; x<15; x++){
			for(int y = 1; y<13; y++){
				if(map.getTileId(x, y, boxLayer) != 0){
					map.render(x*32, y*32, 2, 3, 1, 1);
				}
			}
		}
		
		//Render Players
				g.fillRect(Player.x * 32, Player.y * 32, 32, 32);
				g.fillRect(Player.x * 32, Player.y * 32, 32, 32);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {

		//Change State
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			sbg.enterState(2);
		}
		
		Player.movement(gc);
		Player.placeBomb(gc);
	}

	@Override
	public int getID() {
		return 1;
	}
	
}
