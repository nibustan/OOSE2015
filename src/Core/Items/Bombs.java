package Core.Items;
import Core.GameState.PlayState;
import Core.Items.Item;

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

	public void init(){
		timerStart = System.currentTimeMillis();
		System.out.println("hej");
	}
	
	public void update(){
		timerBomb();
		System.out.println(timerStart);
	}
	
	public void timerBomb (){
		  	timerDif = System.currentTimeMillis();
				if(timerDif-timerStart > timerAmountBomb){
					explodeBomb ();
					timerStart = 0;
					timerDif = 0;
				}
			  }	

	public void explodeBomb(){ //BOMB EXPLOSION
			
			hitWallRight = false;
			hitWallLeft = false;
			hitWallUp = false;
			hitWallDown = false;
			
			PlayState.map.setTileId(x, y, PlayState.bombLayer, 26);
			
			//Middle
			PlayState.map.setTileId(x, y, PlayState.fireLayer, 123);
			
			//Right
			PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
			
			//Left
			PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
			
			//Up
			PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
			
			//Down
			PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
			
			//Right
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 111) {
				PlayState.map.setTileId(x + 1, y, PlayState.boxLayer, 0);
				//randomDrop();
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
				//randomDrop();
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
				//randomDrop();
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
				//randomDrop();
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
			
	}

	public void removeFire (){
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
