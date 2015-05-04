package Core.Items;
import Core.Player.Player;
import Core.GameState.PlayState;
//Sup
public class Bombs {
	public int x,y,blastRadius;

	public boolean hitWallRight;
	public boolean hitWallLeft;
	public boolean hitWallUp;
	public boolean hitWallDown;
	protected long timerStart = 0;
	protected long timerDif = 0;
	protected int timerAmountBomb = 3000; // = 3 second
	protected int timerAmountFire = 1000; // = 1 second
	public boolean isExploded = false;
	
	public Bombs(int x, int y, int blastRadius) {
		this.x = x;
		this.y = y;
		this.blastRadius = blastRadius;
	}

	public void timerBomb (){
		
		System.out.println("TEST");
		
		if(timerStart == 0){
			timerStart = System.currentTimeMillis();
		}else{
		  	timerDif = System.currentTimeMillis();
		  	
				if(timerDif-timerStart > timerAmountBomb){
					explodeBomb (x,y,blastRadius);
					
					timerStart = 0;
					timerDif = 0;
				}
			  }
			}
	
	public void update(){
		timerBomb();
	}

	public void explodeBomb(int x, int y, int blastRadius){ //BOMB EXPLOSION
			
			hitWallRight = false;
			hitWallLeft = false;
			hitWallUp = false;
			hitWallDown = false;
			
			PlayState.map.setTileId(x, y, PlayState.bombLayer, 26);
			
			//Right
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 111) {
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
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 111) {
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
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 111) {
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
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 111) {
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
		removeFire();
	}

	public void removeFire (){
		if(timerStart == 0){
			timerStart = System.currentTimeMillis();
		}else{
		  	timerDif = System.currentTimeMillis();
				if(timerDif-timerStart > timerAmountFire){
					for(int i = 0; i<22; i++){
						for(int j = 0; j<13; j++){
							if(PlayState.map.getTileId(i, j, PlayState.fireLayer) == 123){
								PlayState.map.setTileId(i, j, PlayState.fireLayer, 122);
							}
						}
					}
					timerStart = 0;
					timerDif = 0;
				}
		 }
	}	
}
