package Core.Player;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Core.GameState.PlayState;
import Core.Items.Bombs;

public class Player {

	// Player Vector (location)
	public int x;
	public int y;

	// Player Attributes

	public int bombLength; // Determines how big of a blastradius the players
							// bomb will travel in each direction.
	public int bombsActive = 0; // Indicates how many bombs a player has on the
								// field at a time.
	public int inControl; // The number selects the player: 1 = Player 1, 2 =
							// Player 2.

	ArrayList<Bombs> bombs = new ArrayList<Bombs>(); // Player 1's bombs on the
														// map.
	ArrayList<Bombs> bombs2 = new ArrayList<Bombs>(); // Player 2's bombs on the
														// map.
	public boolean renderPlayer = true;
	public boolean hitByFire;
	public boolean alive = true;

	/**
	 * Determines which player the code will defer to.
	 * 
	 * @param inControl
	 *            = The number selects the player: 1 = Player 1, 2 = Player 2.
	 */
	public Player(int inControl, int x, int y, int bombLength) {
		this.inControl = inControl;
		this.x = x;
		this.y = y;
		this.bombLength = bombLength;
	}

	public void init() throws SlickException {
	}

	/**
	 * The update method keeps track of both players active bombs on the map.
	 * 
	 * @param gc
	 *            = The gamecontainer.
	 * @throws SlickException
	 *             = A generic exception thrown by everything in the Slick2D
	 *             library
	 */
	public void update(GameContainer gc) throws SlickException {
		//Bombs Update
		for(int i = 0; i<=bombs.size()-1; i++){
			if(bombs.get(i).isExploded == true){
				bombs.remove(i);
				bombsActive--;
			} else {
				bombs.get(i).update(this);
			}
		}
		for(int i = 0; i<=bombs2.size()-1; i++){
			if(bombs2.get(i).isExploded == true){
				bombs2.remove(i);
				bombsActive--;
			} else {
				bombs2.get(i).update(this);
			}
		}
		//Fire update
		if (PlayState.map.getTileId(x, y, PlayState.fireLayer) == 123
				|| PlayState.map.getTileId(x, y, PlayState.fireLayerH) == 133
				|| PlayState.map.getTileId(x, y, PlayState.fireLayerV) == 143) {
			hitByFire = true;
		}
	}

	/**
	 * The movement method controls the movements of player 1 and player 2.
	 * 
	 * @param gc
	 *            = The gamecontainer.
	 * @throws SlickException
	 *             = A generic exception thrown by everything in the Slick2D
	 *             library.
	 */
	public void movement(GameContainer gc) throws SlickException {

		// Player 1
		if (inControl == 1) {
			// Move Player Right
			if (gc.getInput().isKeyPressed(Input.KEY_D)) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 50);
				if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x + 1, y,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
					PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
					PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
					PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
					x++;
					PlayState.map.setTileId(x, y, PlayState.player1Layer1, 50);
				}
			}
			// Move Player1 Left
			if (gc.getInput().isKeyPressed(Input.KEY_A)) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
				if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x - 1, y,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
					PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
					PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
					PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
					x--;
					PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
				}
			}
			// Move Player1 Up
			if (gc.getInput().isKeyPressed(Input.KEY_W)) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
				if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x, y - 1,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
					PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
					PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
					PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
					y--;
					PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
				}
			}
			// Move Player1 Down
			if (gc.getInput().isKeyPressed(Input.KEY_S)) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
				if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x, y + 1,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
					PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
					PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
					PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
					y++;
					PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
				}
			}
			// Check if player1 is inside of a blast
			if (PlayState.map.getTileId(x, y, PlayState.fireLayerH) == 133
					|| PlayState.map.getTileId(x, y, PlayState.fireLayerV) == 143
					|| PlayState.map.getTileId(x, y, PlayState.fireLayer) == 123) {
				init();
				Core.GameController.player1Alive = false;
			}
		}

		// player2
		if (inControl == 2) {
			// Move player2 right
			if (gc.getInput().isKeyPressed(Input.KEY_L)) {
				PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
				PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
				PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
				PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
				PlayState.map.setTileId(x, y, PlayState.player2Layer1, 51);
				if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x + 1, y,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
					PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
					PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
					PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
					x++;
					PlayState.map.setTileId(x, y, PlayState.player2Layer1, 51);
				}
			}

			// Move Player2 Left
			if (gc.getInput().isKeyPressed(Input.KEY_J)) {
				PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
				PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
				PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
				PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
				PlayState.map.setTileId(x, y, PlayState.player2Layer2, 1);
				if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x - 1, y,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
					PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
					PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
					PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
					x--;
					PlayState.map.setTileId(x, y, PlayState.player2Layer2, 5);
				}
			}

			// Move Player2 Up
			if (gc.getInput().isKeyPressed(Input.KEY_I)) {
				PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
				PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
				PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
				PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
				PlayState.map.setTileId(x, y, PlayState.player2Layer3, 5);
				if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x, y - 1,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
					PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
					PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
					PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
					y--;
					PlayState.map.setTileId(x, y, PlayState.player2Layer3, 5);
				}
			}

			// Move Player2 Down
			if (gc.getInput().isKeyPressed(Input.KEY_K)) {
				PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
				PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
				PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
				PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
				PlayState.map.setTileId(x, y, PlayState.player2Layer4, 5);
				if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0
						&& PlayState.map.getTileId(x, y + 1,
								PlayState.wallLayer) == 0) {
					PlayState.map.setTileId(x, y, PlayState.player2Layer1, 5);
					PlayState.map.setTileId(x, y, PlayState.player2Layer2, 6);
					PlayState.map.setTileId(x, y, PlayState.player2Layer3, 7);
					PlayState.map.setTileId(x, y, PlayState.player2Layer4, 8);
					y++;
					PlayState.map.setTileId(x, y, PlayState.player2Layer4, 5);
				}
			}
			// Check if player2 is inside of a blast
			if (PlayState.map.getTileId(x, y, PlayState.fireLayerH) == 133
					|| PlayState.map.getTileId(x, y, PlayState.fireLayerV) == 143
					|| PlayState.map.getTileId(x, y, PlayState.fireLayer) == 123) {
				init();
				Core.GameController.player2Alive = false;
			}
		}

	}

	/**
	 * This method places a bomb on the specified players x & y coordinates upon
	 * player input.
	 * 
	 * @param gc
	 *            = The gamecontainer.
	 * @throws SlickException
	 *             = A generic exception thrown by everything in the Slick2D
	 *             library.
	 */
	public void placeBomb(GameContainer gc) throws SlickException {
		if (inControl == 1) {
			if (gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
				if (bombs.size() < 3
						&& PlayState.map.getTileId(x, y, PlayState.bombLayer) != 25) {
					bombs.add(new Bombs(x, y, bombLength));
					bombs.get(bombs.size() - 1).init();
					PlayState.map.setTileId(x, y, PlayState.bombLayer, 25);
					bombsActive++;
				}
			}
		}
		if (inControl == 2) {
			if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				if (bombs2.size() < 3
						&& PlayState.map.getTileId(x, y, PlayState.bombLayer) != 25) {
					bombs2.add(new Bombs(x, y, bombLength));
					bombs2.get(bombs2.size() - 1).init();
					PlayState.map.setTileId(x, y, PlayState.bombLayer, 25);
					bombsActive++;
				}
			}
		}
	}
}
