package Core.Items;
import Core.GameState.PlayState;

public class Bombs {

	public boolean hitWallRight;
	public boolean hitWallLeft;
	public boolean hitWallUp;
	public boolean hitWallDown;
	boolean isExploded = false;
	int time = 0;
	
	public void timerBomb(int x, int y, int blastRadius){ //COUNTDOWN FOR BOMB EXPLOSION
		int delta = getDelta();
		time += delta; //add the time passed since last update()
	    if(time > 3000){ //3 seconds = 3000 milliseconds
	    	explodeBomb(x, y, blastRadius);
	    	time = 0;
	    } 
	}
	
	public long getTime() {
	    return System.nanoTime() / 1000000000; //The time
	}

	public int getDelta() {
		long lastFrame = 0;
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
	         
	    return delta;
	}
	
	public void explodeBomb(int x, int y, int blastRadius){ //BOMB EXPLOSION
			hitWallRight = false;
			hitWallLeft = false;
			hitWallUp = false;
			hitWallDown = false;
			
			//Right
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x + 1, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayer, 123);
			}
			/*else if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 94 && blastRadius >= 2 && hitWallRight != true){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 94 && blastRadius >= 3 && hitWallRight != true){
				PlayState.map.setTileId(x + 3, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 94 && blastRadius == 4 && hitWallRight != true){
				PlayState.map.setTileId(x + 4, y, PlayState.boxLayer, 0);
			}*/
			
			//Left
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x - 1, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayer, 123);
			}
			/*else if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 94 && blastRadius >= 2 && hitWallRight != true){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 94 && blastRadius >= 3 && hitWallRight != true){
				PlayState.map.setTileId(x + 3, y, PlayState.boxLayer, 0);
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 1 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 81){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 94 && blastRadius == 4 && hitWallRight != true){
				PlayState.map.setTileId(x + 4, y, PlayState.boxLayer, 0);
			}*/
			
			//Down
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y + 1, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayer, 123);
			}
			/*else if(map.getTileId(x, y + 2, boxLayer) == 94 && blastRadius >= 2){
				map.setTileId(x, y + 2, boxLayer, 0);
			}
			else if(map.getTileId(x, y + 3, boxLayer) == 94 && blastRadius >= 3){
				map.setTileId(x, y + 3, boxLayer, 0);
			}
			else if(map.getTileId(x, y + 4, boxLayer) == 94 && blastRadius == 4){
				map.setTileId(x, y + 4, boxLayer, 0);
			}*/
			
			//Up
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 94) {
				PlayState.map.setTileId(x, y - 1, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayer, 123);
			}
			/*else if(map.getTileId(x, y - 2, boxLayer) == 94 && blastRadius >= 2){
				map.setTileId(x, y - 2, boxLayer, 0);
			}
			else if(map.getTileId(x, y - 3, boxLayer) == 94 && blastRadius >= 3){
				map.setTileId(x, y - 3, boxLayer, 0);
			}
			else if(map.getTileId(x, y - 4, boxLayer) == 94 && blastRadius == 4){
				map.setTileId(x, y - 4, boxLayer, 0);
			}*/

		isExploded = true;
		if(isExploded = true)
			removeBomb();
			isExploded = false;
	}
	
	public void removeBomb(){
		//REMOVE BOMB AFTER EXPLOSION
		
			
			
		}
		
	}


