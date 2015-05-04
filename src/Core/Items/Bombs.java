package Core.Items;

import Core.GameState.PlayState;

public class Bombs {

	public boolean hitWallRight;
	public boolean hitWallLeft;
	public boolean hitWallUp;
	public boolean hitWallDown;
<<<<<<< Updated upstream
	public boolean isExploded = false;
	int time = 0;
	
	public void timerBomb(int x, int y, int blastRadius){ //COUNTDOWN FOR BOMB EXPLOSION
		int delta = getDelta();
		time += delta; //add the time passed since last update()
	    if(time > 3000){ //3 seconds = 3000 milliseconds
	    	explodeBomb(x, y, blastRadius);
	    	time = 0;
	    } 
	}
=======
	boolean isExploded = false;
	int time = 3;
	int delay = 3000;
	int pastTime = 0;
	long test = System.currentTimeMillis();
	protected long timerStart = 0;
	protected long timerDif = 0;
	protected int timerAmount = 3000; // = 3 second
>>>>>>> Stashed changes
	
	public void timerBomb (int x, int y, int blastRadius){
		if(isExploded == false){
			isExploded = true;
			timerStart = System.currentTimeMillis();
			explodeBomb(x,y,blastRadius);
			}
			else{
			timerDif = System.currentTimeMillis();
				if(timerDif > timerAmount){
					timerStart = 0;
					timerDif = 0;
					isExploded = true;
			}
		}
	}

	public void explodeBomb(int x, int y, int blastRadius){ //BOMB EXPLOSION
			
			hitWallRight = false;
			hitWallLeft = false;
			hitWallUp = false;
			hitWallDown = false;
<<<<<<< Updated upstream
			//Removes bomb
			PlayState.map.setTileId(x, y, PlayState.bombLayer, 26);
=======
	
>>>>>>> Stashed changes
			
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

	}
	
	public void removeBomb(){
<<<<<<< Updated upstream
		//REMOVE BOMB AFTER EXPLOSION			
			removeFire();
		
		}

	void removeFire(){
		int delta = getDelta();
		time += delta; //add the time passed since last update()
	    if(time > 1000){ //1 seconds = 1000 milliseconds
	    	for(int i = 0; i<22; i++){
				for(int j = 0; j<13; j++){
					if(PlayState.map.getTileId(i, j, PlayState.fireLayer) == 123){
						PlayState.map.setTileId(i, j, PlayState.fireLayer, 122);
						}
					}
				}
	    	time = 0;
	}
		
=======
		//REMOVE BOMB AFTER EXPLOSION
			
>>>>>>> Stashed changes
	}
		
}

}
