package Core.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Core.GameState.PlayState;

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
	
	//Player stats
	public int bombLength;
	
	
	//Booleans
	public boolean hitWallRight;
	public boolean hitWallLeft;
	public boolean hitWallUp;
	public boolean hitWallDown;
	
	
	public void init()throws SlickException {
	}

	public void  update(GameContainer gc) throws SlickException {	
		
	}

	public void movement(GameContainer gc)throws SlickException{
		
		// Move Player Right
				if (gc.getInput().isKeyPressed(Input.KEY_D)) {
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
			hitWallRight = false;
			hitWallLeft = false;
			hitWallUp = false;
			hitWallDown = false;
			//Right
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x + 1, y, PlayState.boxLayer, 0);
		
			}
			else if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 1){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 94 && bombLength >= 2){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 1){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 94 && bombLength >= 3){
				PlayState.map.setTileId(x + 3, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 1){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 94 && bombLength == 4){
				PlayState.map.setTileId(x + 4, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.wallLayer) == 1){
				hitWallRight = true;
			}
			
			//Left
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x - 1, y, PlayState.boxLayer, 0);
			}
			/*else if(map.getTileId(x - 2, y, boxLayer) == 94 && bombLength >= 2){
				map.setTileId(x - 2, y, boxLayer, 0);
			}
			else if(map.getTileId(x - 3, y, boxLayer) == 94 && bombLength >= 3){
				map.setTileId(x - 3, y, boxLayer, 0);
			}
			else if(map.getTileId(x - 4, y, boxLayer) == 94 && bombLength == 4){
				map.setTileId(x - 4, y, boxLayer, 0);
			}*/
			
			//Down
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y + 1, PlayState.boxLayer, 0);
			}
			/*else if(map.getTileId(x, y + 2, boxLayer) == 94 && bombLength >= 2){
				map.setTileId(x, y + 2, boxLayer, 0);
			}
			else if(map.getTileId(x, y + 3, boxLayer) == 94 && bombLength >= 3){
				map.setTileId(x, y + 3, boxLayer, 0);
			}
			else if(map.getTileId(x, y + 4, boxLayer) == 94 && bombLength == 4){
				map.setTileId(x, y + 4, boxLayer, 0);
			}*/
			
			//Up
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y - 1, PlayState.boxLayer, 0);
			}
			/*else if(map.getTileId(x, y - 2, boxLayer) == 94 && bombLength >= 2){
				map.setTileId(x, y - 2, boxLayer, 0);
			}
			else if(map.getTileId(x, y - 3, boxLayer) == 94 && bombLength >= 3){
				map.setTileId(x, y - 3, boxLayer, 0);
			}
			else if(map.getTileId(x, y - 4, boxLayer) == 94 && bombLength == 4){
				map.setTileId(x, y - 4, boxLayer, 0);
			}*/
			
		}
	}

}
