package Core.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Core.GameState.PlayState;
import Core.Items.Bombs;

public class Player {
	
	//Key bindings
	public String right;
	public String left;
	public String up;
	public String down;
	public String bombButton;
	
	//Vector
	public int x;
	public int y;
	
	//Player Attributes
	public int bombLength;
	int bombAmount = 1;
	Bombs[] bombs = new Bombs[bombAmount];
	
	//Booleans
	
	public void init()throws SlickException {
	}

	public void  update(GameContainer gc) throws SlickException {	

	}

	public void movement(GameContainer gc)throws SlickException{
		
		// Move Player Right
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
				x++;
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			}
		}
		// Move Player Left
		if (gc.getInput().isKeyPressed(Input.KEY_A)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
				x--;
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
			}
		}
		// Move Player Up
		if (gc.getInput().isKeyPressed(Input.KEY_W)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
				y--;
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
			}
		}
		// Move Player Down
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 241);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 242);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 243);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 244);
				y++;
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
			}
		}
		
	}

	public void placeBomb(GameContainer gc)throws SlickException{
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			bombs[0] = new Bombs();
			bombs[0].timerBomb(x, y, bombLength);
		}
	}
	
	
}
