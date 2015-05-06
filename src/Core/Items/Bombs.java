package Core.Items;
import Core.GameState.PlayState;
//import Core.Items.Item;

public class Bombs {
	//Attributes
	public int x, y, blastRadius;
	
	//Tile detection booleans
	public boolean hitWallRight;
	public boolean hitWallLeft;
	public boolean hitWallUp;
	public boolean hitWallDown;
	public boolean hitWallRight1;
	public boolean hitWallLeft1;
	public boolean hitWallUp1;
	public boolean hitWallDown1;	
	public boolean hitBoxRight;
	public boolean hitBoxLeft;
	public boolean hitBoxUp;
	public boolean hitBoxDown;
	
	//Time variables
	protected long timerStart = 0;
	protected long timerStartFire = 0;
	protected long timerDif = 0;
	protected long timerDifFire = 0;
	protected int timerAmountBomb = 3000; // = 3 second
	protected int timerAmountFire = 1000; // = 1 second
	
	//Timer booleans
	boolean startRemoveFire;
	boolean fireStart;
	public boolean isExploded;	
	
	/**
	 * A bomb which can be placed on the map as an active bomb.
	 * @param x = the x position of the bomb.
	 * @param y = the y position of the bomb.
	 * @param blastRadius = How many tilelenghts the bomb will create 
	 * 						fire in each direction when it explodes.
	 */
	public Bombs(int x, int y, int blastRadius) {
		this.x = x;
		this.y = y;
		this.blastRadius = blastRadius;
	}

	/**
	 * Initializes the bomb explosion variables.
	 */
	public void init(){
		timerStart = System.currentTimeMillis();
		isExploded = false;
		fireStart = true;
		startRemoveFire = false;
	}
	
	/**
	 * Keeps checking the timers on the active bombs, removes fire and
	 * checks if active bombs on the map should explode early due to fireblasts.
	 */
	public void update(){
		timerBomb();
		if(startRemoveFire == true){
		removeFire();
		}
		if (PlayState.map.getTileId(x, y, PlayState.fireLayerH) == 133 || PlayState.map.getTileId(x, y, PlayState.fireLayerV) == 143) {
			explodeBomb();
			PlayState.map.setTileId(x , y, PlayState.fireLayer, 123);
		}
	}
	/**
	 * Checks if time has ran out. If it has, the bomb will explode.
	 */
	public void timerBomb (){
		  	timerDif = System.currentTimeMillis();
				if(timerDif-timerStart > timerAmountBomb){
					explodeBomb ();
				}
			  }	
	
	
	/**
	 * Bomb explosion.
	 * First it sets all wall booleans to false, indicating that it isn't initially blocked.
	 * Then it removes the bomb graphic from its position and exchanges it
	 * with the middle fireblast graphic. 
	 * The method then runs 4 similar directional fireblast codepieces, where it looks out for boxes,
	 * walls and other bombs while it travels the indicated bomblength.
	 */
	public void explodeBomb(){		
		hitWallRight = false;
		hitWallLeft = false;
		hitWallUp = false;
		hitWallDown = false;
		
			//Removes Bomb tile
			PlayState.map.setTileId(x, y, PlayState.bombLayer, 26);
			
			//Middle fireblast
			PlayState.map.setTileId(x, y, PlayState.fireLayer, 123);
			
			//Right fireblast
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 111) {
				PlayState.map.setTileId(x + 1, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				hitBoxRight = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer ) == 98){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallRight != true && hitBoxRight != true){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
				hitBoxRight = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 98){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 111 && blastRadius >= 3 && hitWallRight != true && hitBoxRight != true){
				PlayState.map.setTileId(x + 3, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
				hitBoxRight = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 98){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 111 && blastRadius == 4 && hitWallRight != true && hitBoxRight != true){
				PlayState.map.setTileId(x + 4, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 4, y, PlayState.fireLayerH, 133);
				//itemDrop();
			}
			
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer ) == 98){
				hitWallRight1 = true;
			}
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0 && hitWallRight1 != true) {
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				//itemDrop();
				if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 98){
					hitWallRight1 = true;
					}
				
				if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallRight1 != true){
					PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
					PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);	
					//itemDrop();
					if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 98){
						hitWallRight1 = true;
						}
					
					if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallRight1 != true){
						PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
						//itemDrop();							
						if(PlayState.map.getTileId(x + 4, y, PlayState.wallLayer) == 98){
							hitWallRight1 = true;
							}
					
						if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallRight1 != true){
							PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 4, y, PlayState.fireLayerH, 133);
							//itemDrop();
							}
					}
				}	
			}
			
			//Right bomb check
			if(PlayState.map.getTileId(x + 1, y, PlayState.bombLayer) == 1){
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayer, 123);
			}
			
			//Left fireblast
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 111) {
				PlayState.map.setTileId(x - 1, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				hitBoxLeft = true;
				Core.Items.Item.itemDrop(x -1, y);	
			}
			else if(PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x - 1, y, PlayState.wallLayer ) == 98){
				hitWallLeft = true;
			}
			else if(PlayState.map.getTileId(x - 2, y, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallLeft != true && hitBoxLeft != true){
				PlayState.map.setTileId(x - 2, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
				hitBoxLeft = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x - 2, y, PlayState.wallLayer) == 98){
				hitWallLeft = true;
			}
			else if(PlayState.map.getTileId(x - 3, y, PlayState.boxLayer) == 111 && blastRadius >= 3 && hitWallLeft != true && hitBoxLeft != true){
				PlayState.map.setTileId(x - 3, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
				hitBoxLeft = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x - 3, y, PlayState.wallLayer) == 98){
				hitWallLeft = true;
			}
			else if(PlayState.map.getTileId(x - 4, y, PlayState.boxLayer) == 111 && blastRadius == 4 && hitWallLeft != true && hitBoxLeft != true){
				PlayState.map.setTileId(x - 4, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 4, y, PlayState.fireLayerH, 133);
				//itemDrop();
			}
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x - 1, y, PlayState.wallLayer ) == 98){
				hitWallLeft1 = true;
			}
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0 && hitWallLeft1 != true) {
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				//itemDrop();
				if(PlayState.map.getTileId(x - 2, y, PlayState.wallLayer) == 98){
					hitWallLeft1 = true;
					}
				
				if(PlayState.map.getTileId(x - 2, y, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallLeft1 != true){
					PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
					PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);	
					//itemDrop();
					if(PlayState.map.getTileId(x - 3, y, PlayState.wallLayer) == 98){
						hitWallLeft1 = true;
						}
					
					if(PlayState.map.getTileId(x - 3, y, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallLeft1 != true){
						PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
						//itemDrop();							
						if(PlayState.map.getTileId(x - 4, y, PlayState.wallLayer) == 98){
							hitWallLeft1 = true;
							}
					
						if(PlayState.map.getTileId(x - 4, y, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallLeft1 != true){
							PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 4, y, PlayState.fireLayerH, 133);
							//itemDrop();
							}
					}
				}	
			}

			//Left bomb check
			if(PlayState.map.getTileId(x - 1, y, PlayState.bombLayer) == 1){
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayer, 123);
			}

			
			//Down fireblast
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 111) {
				PlayState.map.setTileId(x, y + 1, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				hitBoxDown = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y + 1, PlayState.wallLayer ) == 98){
				hitWallDown = true;
			}
			else if(PlayState.map.getTileId(x, y + 2, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallDown != true && hitBoxDown != true){
				PlayState.map.setTileId(x, y + 2, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
				hitBoxDown = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y + 2, PlayState.wallLayer) == 98){
				hitWallDown = true;
			}
			else if(PlayState.map.getTileId(x, y + 3, PlayState.boxLayer) == 111 && blastRadius >= 3 && hitWallDown != true && hitBoxDown != true){
				PlayState.map.setTileId(x, y + 3, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
				hitBoxDown = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y + 3, PlayState.wallLayer) == 98){
				hitWallDown = true;
			}
			else if(PlayState.map.getTileId(x, y + 4, PlayState.boxLayer) == 111 && blastRadius == 4 && hitWallDown != true && hitBoxDown != true){
				PlayState.map.setTileId(x, y + 4, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 4, PlayState.fireLayerV, 143);
				//itemDrop();
			}
			//If no boxes within blast radius range		
			if(PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y + 1, PlayState.wallLayer ) == 98){
				hitWallDown1 = true;
			}
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0 && hitWallDown1 != true) {
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				//itemDrop();
				if(PlayState.map.getTileId(x, y + 2, PlayState.wallLayer) == 98){
					hitWallDown1 = true;
					}
				
				if(PlayState.map.getTileId(x, y + 2, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallDown1 != true){
					PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
					PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
					//itemDrop();
					if(PlayState.map.getTileId(x, y + 3, PlayState.wallLayer) == 98){
						hitWallDown1 = true;							
						}
					
					if(PlayState.map.getTileId(x, y + 3, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallDown1 != true){
						PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
						//itemDrop();							
						if(PlayState.map.getTileId(x, y + 4, PlayState.wallLayer) == 98){
							hitWallDown1 = true;					
							}
					
						if(PlayState.map.getTileId(x, y + 4, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallDown1 != true){
							PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 4, PlayState.fireLayerV, 143);
							//itemDrop();
							}
					}
				}	
			}
			
			//Down bomb check
			if(PlayState.map.getTileId(x , y + 1, PlayState.bombLayer) == 1){
				PlayState.map.setTileId(x , y + 1, PlayState.fireLayer, 123);
			}
			
			//Up fireblast
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 111) {
				PlayState.map.setTileId(x, y - 1, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				hitBoxUp = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y - 1, PlayState.wallLayer ) == 98){
				hitWallUp = true;
			}
			else if(PlayState.map.getTileId(x, y - 2, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallUp != true && hitBoxUp != true){
				PlayState.map.setTileId(x, y - 2, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
				hitBoxUp = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y - 2, PlayState.wallLayer) == 98){
				hitWallUp = true;
			}
			else if(PlayState.map.getTileId(x, y - 3, PlayState.boxLayer) == 111 && blastRadius >= 3 && hitWallUp != true && hitBoxUp != true){
				PlayState.map.setTileId(x, y - 3, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
				hitBoxUp = true;
				//itemDrop();
			}
			else if(PlayState.map.getTileId(x, y - 3, PlayState.wallLayer) == 98){
				hitWallUp = true;
			}
			else if(PlayState.map.getTileId(x, y - 4, PlayState.boxLayer) == 111 && blastRadius == 4 && hitWallUp != true && hitBoxUp != true){
				PlayState.map.setTileId(x, y - 4, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 4, PlayState.fireLayerV, 143);
				//itemDrop();
			}
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y - 1, PlayState.wallLayer ) == 98){
				hitWallUp1 = true;
			}
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0 && hitWallUp1 != true) {
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				//itemDrop();
				if(PlayState.map.getTileId(x, y - 2, PlayState.wallLayer) == 98){
					hitWallUp1 = true;
					}
				
				if(PlayState.map.getTileId(x, y - 2, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallUp1 != true){
					PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
					PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
					//itemDrop();
					if(PlayState.map.getTileId(x, y - 3, PlayState.wallLayer) == 98){
						hitWallUp1 = true;							
						}
					
					if(PlayState.map.getTileId(x, y - 3, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallUp1 != true){
						PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
						//itemDrop();							
						if(PlayState.map.getTileId(x, y - 4, PlayState.wallLayer) == 98){
							hitWallUp1 = true;						
							}
					
						if(PlayState.map.getTileId(x, y - 4, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallUp1 != true){
							PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 4, PlayState.fireLayerV, 143);
							//itemDrop();
							}
					}
				}	
			}
			
			//Up bomb check
			if(PlayState.map.getTileId(x , y - 1, PlayState.bombLayer) == 1){
				PlayState.map.setTileId(x , y - 1, PlayState.fireLayer, 123);
			}
			
			//Clean up procedure
			if(fireStart == true){
				fireStart = false;
			timerStartFire = System.currentTimeMillis();
			startRemoveFire = true;
			}
	}
	public void removeFire (){
		timerDifFire = System.currentTimeMillis();
		if(timerDifFire-timerStartFire > timerAmountFire){
			//Removes fire
			for(int i = 0; i<22; i++){
				for(int j = 0; j<13; j++){
					if(PlayState.map.getTileId(i, j, PlayState.fireLayer) == 123){
						PlayState.map.setTileId(i, j, PlayState.fireLayer, 122);
					}
					if(PlayState.map.getTileId(i, j, PlayState.fireLayerV) == 143){
						PlayState.map.setTileId(i, j, PlayState.fireLayerV, 122);
					}
					if(PlayState.map.getTileId(i, j, PlayState.fireLayerH) == 133){
						PlayState.map.setTileId(i, j, PlayState.fireLayerH, 122);
					}
				}
			}
			isExploded = true;
			}		
		}
	
}	
