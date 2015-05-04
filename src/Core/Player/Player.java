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

	public int bombAmount = 4;
	public int bombsActive = 0;

	Bombs[] bombs = new Bombs[bombAmount];
	
	public void init()throws SlickException {
	}

	public void  update(GameContainer gc) throws SlickException {
		//Bomb Update
		for(int i = 0; i<bombsActive; i++){
			if(bombs[bombsActive].isExploded == true){
				bombsActive--;
			} else {
				bombs[bombsActive].update();
			}
			
		}
		
		//Fire Update
		
	}

	public void movement(GameContainer gc)throws SlickException{
		
		// Move Player Right
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 11);
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				x++;
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 11);
			}
		}
		// Move Player Left
		if (gc.getInput().isKeyPressed(Input.KEY_A)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				x--;
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 1);
			}
		}
		// Move Player Up
		if (gc.getInput().isKeyPressed(Input.KEY_W)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				y--;
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 1);
			}
		}
		// Move Player Down
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
			PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
			PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
			PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 0) {
				PlayState.map.setTileId(x, y, PlayState.player1Layer1, 1);
				PlayState.map.setTileId(x, y, PlayState.player1Layer2, 2);
				PlayState.map.setTileId(x, y, PlayState.player1Layer3, 3);
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 4);
				y++;
				PlayState.map.setTileId(x, y, PlayState.player1Layer4, 1);
			}
		}
		
	}


	public void placeBomb(GameContainer gc)throws SlickException{
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			if(bombsActive < bombAmount-1 && PlayState.map.getTileId(x, y, PlayState.bombLayer) != 25){
				bombsActive++;
			bombs[bombsActive] = new Bombs(x,y,bombLength);
			PlayState.map.setTileId(x, y, PlayState.bombLayer, 25);
			}
		}	
	}
}
