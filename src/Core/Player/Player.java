package Core.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Core.GameState.PlayState;

public class Player {

	public static int x;
	public static int y;
	public static int bombLength1;
	
	public void init()throws SlickException {
	}

	public void  update() throws SlickException {	
	}

	public static void movement(GameContainer gc)throws SlickException{
		
		
		// Move Player Right
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 0) {
				x++;
			}
		}
		// Move Player Left
		if (gc.getInput().isKeyPressed(Input.KEY_A)) {
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 0) {
				x--;
			}
		}
		// Move Player Up
		if (gc.getInput().isKeyPressed(Input.KEY_W)) {
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 0) {
				y--;
				;
			}
		}
		// Move Player Down
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0
					&& PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 0) {
				y++;
			}
		}
	}

	public static void placeBomb(GameContainer gc)throws SlickException{
		if (gc.getInput().isKeyPressed(Input.KEY_U)) {
			if(bombLength1 <5 ){
			bombLength1++;
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			
			//Right
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x + 1, y, PlayState.boxLayer, 0);
			}
			/*else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 94 && bombLength1 >= 2){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 94 && bombLength1 >= 3){
				PlayState.map.setTileId(x + 3, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 94 && bombLength1 == 4){
				PlayState.map.setTileId(x + 4, y, PlayState.boxLayer, 0);
			}*/
			
			//Left
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x - 1, y, PlayState.boxLayer, 0);
			}
			/*else if(PlayState.map.getTileId(x - 2, y, PlayState.boxLayer) == 94 && bombLength1 >= 2){
				PlayState.map.setTileId(x - 2, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x - 3, y, PlayState.boxLayer) == 94 && bombLength1 >= 3){
				PlayState.map.setTileId(x - 3, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x - 4, y, PlayState.boxLayer) == 94 && bombLength1 == 4){
				PlayState.map.setTileId(x - 4, y, PlayState.boxLayer, 0);
			}*/
			
			//Down
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y + 1, PlayState.boxLayer, 0);
			}
			/*else if(PlayState.map.getTileId(x, y + 2, PlayState.boxLayer) == 94 && bombLength1 >= 2){
				PlayState.map.setTileId(x, y + 2, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x, y + 3, PlayState.boxLayer) == 94 && bombLength1 >= 3){
				PlayState.map.setTileId(x, y + 3, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x, y + 4, PlayState.boxLayer) == 94 && bombLength1 == 4){
				PlayState.map.setTileId(x, y + 4, PlayState.boxLayer, 0);
			}*/
			
			//Up
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y - 1, PlayState.boxLayer, 0);
			}
			/*else if(PlayState.map.getTileId(x, y - 2, PlayState.boxLayer) == 94 && bombLength1 >= 2){
				PlayState.map.setTileId(x, y - 2, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x, y - 3, PlayState.boxLayer) == 94 && bombLength1 >= 3){
				PlayState.map.setTileId(x, y - 3, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x, y - 4, PlayState.boxLayer) == 94 && bombLength1 == 4){
				PlayState.map.setTileId(x, y - 4, PlayState.boxLayer, 0);
			}*/
			
		}
	}

}
