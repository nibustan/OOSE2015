package Core.GameState;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Core.GameController;

import Core.Player.Player;

public class PlayState extends BasicGameState{	
	//Static layers
	public static TiledMap map;
	public static int wallLayer;
	public static int boxLayer;
	public static int floorLayer;
	//Fire layers
	public static int fireLayer;
	public static int fireLayerH;
	public static int fireLayerV;
	//Player layers
	public static int player1Layer1;
	public static int player1Layer2;
	public static int player1Layer3;
	public static int player1Layer4;
	public static int player2Layer1;
	public static int player2Layer2;
	public static int player2Layer3;
	public static int player2Layer4;
	
	//Bomb layer
	public static int bombLayer;
	
	//Item layers
	public static int bombUpLayer;
	public static int bombDownLayer;
	public static int fireUpLayer;
	public static int fireDownLayer;
	public static int powerBombLayer;
	
	public static boolean loadingScores;
	
	ArrayList<Player>player = new ArrayList<Player>();
	
	/**
	 * Initializes two Player: player1 & player2. Each is assigned a number, 
	 * which is used for the variable inControl from the Player class.
	 */
	
	public PlayState(int state){
	}
	
	/**
	 * init method:
	 * This method is the first method that is run. This is a required method 
	 * from Slick2d.
	 * The layers mentioned in the method is from Tiled (map.tmx).
	 */
	
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

		
		//Player initialization
		//Player 1
		player.add(new Player(1,1,1,1));
		PlayState.map.setTileId(player.get(0).x, player.get(0).y, PlayState.player1Layer4, 1);
				
		//Player 2
		player.add(new Player(2,13,11,1));
		PlayState.map.setTileId(player.get(1).x, player.get(1).y, PlayState.player2Layer4, 5);	
	}
	
	/**
	 * render method:
	 * Is used for rendering the graphical parts of the game. This is also a
	 * required method from Slick2d. 
	 * Each layers sprites have their own ID. Their ID can be seen in map.txt. 
	 * For the live rendering: they use pre-rendered sprites as a reference. These 
	 * references are on a tile to the right in the game board.
	 * Each tiles sprite is 32x32 pixels. 
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// GUI
		g.drawString("P1 Blvl = " + String.valueOf(player.get(0).bombLength),
				540, 50);
		g.drawString("P1 BAct = " + String.valueOf(player.get(0).bombsActive),
				540, 75);

		g.drawString("P2 Blvl = " + String.valueOf(player.get(1).bombLength),
				540, 350);

		g.drawString("P2 BAct =" + String.valueOf(player.get(1).bombsActive),
				540, 325);

		if (GameController.drawScores == true) {
			System.out.println("Drawing scores");
			g.drawString(GameController.gamesWon1 + "-"
					+ GameController.gamesWon2, 552, 208);
		}

		// Render Map
		map.render(0, 0, floorLayer);

		map.render(0, 0, wallLayer);

		// Live Render For-loop
		for (int x = 0; x < 22; x++) {
			for (int y = 0; y < 13; y++) {
				// Boxes
				if (map.getTileId(x, y, boxLayer) == 111) {
					map.render(x * 32, y * 32, 15, 0, 1, 1);
				}
				// Fire
				if (map.getTileId(x, y, fireLayer) == 123) {
					map.render(x * 32, y * 32, 16, 5, 1, 1);
				}
				// FireH
				if (map.getTileId(x, y, fireLayerH) == 133) {
					map.render(x * 32, y * 32, 16, 6, 1, 1);
				}
				// FireV
				if (map.getTileId(x, y, fireLayerV) == 143) {
					map.render(x * 32, y * 32, 16, 7, 1, 1);
				}
				// Bomb
				if (map.getTileId(x, y, bombLayer) == 25) {
					map.render(x * 32, y * 32, 16, 4, 1, 1);
				}

				if (player.get(0).renderPlayer == true) {
					// Player1
					if (map.getTileId(x, y, player1Layer1) != 1
							&& map.getTileId(x, y, player1Layer2) != 0) {
						map.render(x * 32, y * 32, 15, 2, 1, 1);
					}
					if (map.getTileId(x, y, player1Layer2) != 2
							&& map.getTileId(x, y, player1Layer2) != 0) {
						map.render(x * 32, y * 32, 15, 4, 1, 1);
					}
					if (map.getTileId(x, y, player1Layer3) != 3
							&& map.getTileId(x, y, player1Layer3) != 0) {
						map.render(x * 32, y * 32, 15, 6, 1, 1);
					}
					if (map.getTileId(x, y, player1Layer4) != 4
							&& map.getTileId(x, y, player1Layer4) != 0) {
						map.render(x * 32, y * 32, 15, 8, 1, 1);
					}
				} 
				if(player.get(1).renderPlayer ==true){
					// Player2
					if (map.getTileId(x, y, player2Layer1) != 5
							&& map.getTileId(x, y, player2Layer2) != 0) {
						map.render(x * 32, y * 32, 15, 3, 1, 1);
					}
					if (map.getTileId(x, y, player2Layer2) != 6
							&& map.getTileId(x, y, player2Layer2) != 0) {
						map.render(x * 32, y * 32, 15, 5, 1, 1);
					}
					if (map.getTileId(x, y, player2Layer3) != 7
							&& map.getTileId(x, y, player2Layer3) != 0) {
						map.render(x * 32, y * 32, 15, 7, 1, 1);
					}
					if (map.getTileId(x, y, player2Layer4) != 8
							&& map.getTileId(x, y, player2Layer4) != 0) {
						map.render(x * 32, y * 32, 15, 9, 1, 1);
					}
				}

			}
		}
	}
	
	/**update method:
	 * Is used for updating the games frames. This is also a
	 * required method from Slick2d. 
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)throws SlickException {

		player.get(0).movement(gc);
		player.get(0).placeBomb(gc);
		player.get(0).update(gc);
		
		player.get(1).movement(gc);
		player.get(1).placeBomb(gc);
		player.get(1).update(gc);
		
		//player death
		if(player.get(0).hitByFire == true){
			player.get(0).renderPlayer= false;
			player.remove(0);
			loadingScores = true;
			if(player.get(1).alive ==true){
				GameController.player2Alive = true;
			}
			--GameController.playersAlive;
			if(loadingScores == true){
				GameController.update();
			}
		}
		if(player.get(1).hitByFire == true){
			player.get(1).renderPlayer= false;
			player.remove(1);
			loadingScores = true;
			if(player.get(0).alive ==true){
				GameController.player1Alive = true;
			}
			--GameController.playersAlive;
			if(loadingScores == true){
				GameController.update();
			}
		}
		/*
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
		*/
	}

	@Override
	public int getID() {
		return 1;
	}
	
}
