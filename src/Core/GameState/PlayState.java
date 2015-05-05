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
	
	public static int fireLayer;
	public static int fireLayerH;
	public static int fireLayerV;
	
	public static int player1Layer1;
	public static int player1Layer2;
	public static int player1Layer3;
	public static int player1Layer4;

	public static int bombLayer;

	public static int player2Layer1;
	public static int player2Layer2;
	public static int player2Layer3;
	public static int player2Layer4;
	
	public static int bombUpLayer;
	public static int bombDownLayer;
	
	public static int fireUpLayer;
	public static int fireDownLayer;
	
	public static int powerBombLayer;
	
	
	Player player1 = new Player();
	Player player2 = new Player();
	
	public PlayState(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		//TiledMap setup initialization
		map = new TiledMap("res/map1.tmx");
		boxLayer = map.getLayerIndex("BoxesLayer");
		wallLayer = map.getLayerIndex("WallLayer");
		floorLayer = map.getLayerIndex("FloorLayer");
	
		//Bomb and Fire sprites initialization
		bombLayer = map.getLayerIndex("BombLayer");
		fireLayer = map.getLayerIndex("FireLayer");
		fireLayerH = map.getLayerIndex("FireLayerH");
		fireLayerV = map.getLayerIndex("FireLayerV");
		
		//Player1 Sprites initialization
		player1Layer1 = map.getLayerIndex("Player1Layer1");
		player1Layer2 = map.getLayerIndex("Player1Layer2");
		player1Layer3 = map.getLayerIndex("Player1Layer3");
		player1Layer4 = map.getLayerIndex("Player1Layer4");
		
		//Player2 Sprites initialization
		player2Layer1 = map.getLayerIndex("Player2Layer1");
		player2Layer2 = map.getLayerIndex("Player2Layer2");
		player2Layer3 = map.getLayerIndex("Player2Layer3");
		player2Layer4 = map.getLayerIndex("Player2Layer4");
		
		//Item sprites initialization
		bombUpLayer = map.getLayerIndex("BombUp");
		bombDownLayer = map.getLayerIndex("BombDown");
		fireUpLayer = map.getLayerIndex("FireUp");
		fireDownLayer = map.getLayerIndex("FireDown");
		powerBombLayer = map.getLayerIndex("PowerBomb");

		
		//Player data setup initialization
		//Player 1
		player1.x = 1;
		player1.y = 1;
		PlayState.map.setTileId(player1.x, player1.y, PlayState.player1Layer4, 1);
		
		player1.bombLength = 1;
		
		//Player 2
		player2.x = 13;
		player2.y = 11;
		PlayState.map.setTileId(player2.x, player2.y, PlayState.player1Layer4, 1);
		
		player2.bombLength = 1;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		//GUI
		g.drawString("P1 Blvl = "+ String.valueOf(player1.bombLength), 540, 50);
		g.drawString("P1 BAct = "+ String.valueOf(player1.bombsActive), 540, 75);
		
		g.drawString("P2 Blvl = "+ String.valueOf(player2.bombLength), 540, 350);
		
		//Render Map
		map.render(0, 0, floorLayer);
		
		map.render(0, 0, wallLayer);
		
		//Live Render For-loop
				for(int x = 0; x<22; x++){
					for(int y = 0; y<13; y++){
						//Boxes
						if(map.getTileId(x, y, boxLayer) == 111){
							map.render(x*32, y*32, 15, 0, 1, 1);
						}
						//Fire
						if(map.getTileId(x, y, fireLayer) == 123){
							map.render(x*32, y*32, 16, 5, 1, 1);
						}
						//FireH
						if(map.getTileId(x, y, fireLayerH) == 133){
							map.render(x*32, y*32, 16, 6, 1, 1);
						}
						//FireV
						if(map.getTileId(x, y, fireLayerV) == 143){
							map.render(x*32, y*32, 16, 7, 1, 1);
						}
						//Bomb
						if(map.getTileId(x, y, bombLayer) == 25){
							map.render(x*32, y*32, 16, 4, 1, 1);
						}
						
						//Player1
						if(map.getTileId(x, y, player1Layer1) != 1 && map.getTileId(x, y, player1Layer2) != 0){
							map.render(x*32, y*32, 15, 2, 1, 1);
						}
						if(map.getTileId(x, y, player1Layer2) != 2 && map.getTileId(x, y, player1Layer2) != 0){
							map.render(x*32, y*32, 15, 4, 1, 1);
						}
						if(map.getTileId(x, y, player1Layer3) != 3 && map.getTileId(x, y, player1Layer3) != 0){
							map.render(x*32, y*32, 15, 6, 1, 1);
						}
						if(map.getTileId(x, y, player1Layer4) != 4 && map.getTileId(x, y, player1Layer4 ) != 0){
							map.render(x*32, y*32, 15, 8, 1, 1);
						}
						
						//Player
					
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
		player1.update(gc);
		
		player2.movement(gc);
		player2.placeBomb(gc);
		player2.update(gc);
		
		
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
