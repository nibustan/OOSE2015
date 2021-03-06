package Core.Items;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

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
	
	Sound bombS;

	
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
	 * @throws SlickException 
	 */
	public void init() throws SlickException{
		timerStart = System.currentTimeMillis();
		isExploded = false;
		fireStart = true;
		startRemoveFire = false;
		bombS = new Sound("res/bomb.wav");
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
	public void timerBomb() {
		timerDif = System.currentTimeMillis();
		if (timerDif - timerStart > timerAmountBomb) {
			explodeBomb();
			if(!bombS.playing()) 
				bombS.play();
		}
	}
	

	/**
	 * Bomb explosion. First it sets all wall booleans to false, indicating that
	 * it isn't initially blocked. Then it removes the bomb graphic from its
	 * position and exchanges it with the middle fireblast graphic. The method
	 * then runs 4 similar directional fireblast codepieces, where it looks out
	 * for boxes, walls and other bombs while it travels the indicated
	 * bomblength.
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
				Core.Items.Item.itemDrop(x + 1,y);
			}
			else if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer ) == 98){
				hitWallRight = true;
			}
			else if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallRight != true && hitBoxRight != true){
				PlayState.map.setTileId(x + 2, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
				hitBoxRight = true;
				Core.Items.Item.itemDrop(x + 2,y);
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
				Core.Items.Item.itemDrop(x + 3,y);
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
				Core.Items.Item.itemDrop(x + 4,y);
			}
			
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x + 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x + 1, y, PlayState.wallLayer ) == 98){
				hitWallRight1 = true;
			}
			if (PlayState.map.getTileId(x + 1, y, PlayState.boxLayer) == 0 && hitWallRight1 != true) {
				PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
				//Core.Items.Item.itemDrop(x + 1,y);
				if(PlayState.map.getTileId(x + 2, y, PlayState.wallLayer) == 98){
					hitWallRight1 = true;
					}
				
				if(PlayState.map.getTileId(x + 2, y, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallRight1 != true){
					PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
					PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);	
					//Core.Items.Item.itemDrop(x + 2,y);
					if(PlayState.map.getTileId(x + 3, y, PlayState.wallLayer) == 98){
						hitWallRight1 = true;
						}
					
					if(PlayState.map.getTileId(x + 3, y, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallRight1 != true){
						PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
						//Core.Items.Item.itemDrop(x + 3,y);						
						if(PlayState.map.getTileId(x + 4, y, PlayState.wallLayer) == 98){
							hitWallRight1 = true;
							}
					
						if(PlayState.map.getTileId(x + 4, y, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallRight1 != true){
							PlayState.map.setTileId(x + 1, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 2, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 3, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x + 4, y, PlayState.fireLayerH, 133);
							//Core.Items.Item.itemDrop(x + 4,y);
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
				Item.itemDrop(x -1, y);	
			}
			else if(PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x - 1, y, PlayState.wallLayer ) == 98){
				hitWallLeft = true;
			}
			else if(PlayState.map.getTileId(x - 2, y, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallLeft != true && hitBoxLeft != true){
				PlayState.map.setTileId(x - 2, y, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
				hitBoxLeft = true;
				Core.Items.Item.itemDrop(x - 2,y);
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
				Core.Items.Item.itemDrop(x - 3,y);
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
				Core.Items.Item.itemDrop(x - 4,y);
			}
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x - 1, y, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x - 1, y, PlayState.wallLayer ) == 98){
				hitWallLeft1 = true;
			}
			if (PlayState.map.getTileId(x - 1, y, PlayState.boxLayer) == 0 && hitWallLeft1 != true) {
				PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
				//Core.Items.Item.itemDrop(x - 1,y);
				if(PlayState.map.getTileId(x - 2, y, PlayState.wallLayer) == 98){
					hitWallLeft1 = true;
					}
				
				if(PlayState.map.getTileId(x - 2, y, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallLeft1 != true){
					PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
					PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);	
					//Core.Items.Item.itemDrop(x - 2,y);
					if(PlayState.map.getTileId(x - 3, y, PlayState.wallLayer) == 98){
						hitWallLeft1 = true;
						}
					
					if(PlayState.map.getTileId(x - 3, y, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallLeft1 != true){
						PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
						PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
						//Core.Items.Item.itemDrop(x - 3,y);							
						if(PlayState.map.getTileId(x - 4, y, PlayState.wallLayer) == 98){
							hitWallLeft1 = true;
							}
					
						if(PlayState.map.getTileId(x - 4, y, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallLeft1 != true){
							PlayState.map.setTileId(x - 1, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 2, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 3, y, PlayState.fireLayerH, 133);
							PlayState.map.setTileId(x - 4, y, PlayState.fireLayerH, 133);
							//Core.Items.Item.itemDrop(x - 4,y);
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
				Core.Items.Item.itemDrop(x ,y + 1);
			}
			else if(PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y + 1, PlayState.wallLayer ) == 98){
				hitWallDown = true;
			}
			else if(PlayState.map.getTileId(x, y + 2, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallDown != true && hitBoxDown != true){
				PlayState.map.setTileId(x, y + 2, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
				hitBoxDown = true;
				Core.Items.Item.itemDrop(x ,y + 2);
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
				Core.Items.Item.itemDrop(x ,y + 3);
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
				Core.Items.Item.itemDrop(x ,y + 4);
			}
			//If no boxes within blast radius range		
			if(PlayState.map.getTileId(x, y + 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y + 1, PlayState.wallLayer ) == 98){
				hitWallDown1 = true;
			}
			if (PlayState.map.getTileId(x, y + 1, PlayState.boxLayer) == 0 && hitWallDown1 != true) {
				PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
				//Core.Items.Item.itemDrop(x ,y + 1);
				if(PlayState.map.getTileId(x, y + 2, PlayState.wallLayer) == 98){
					hitWallDown1 = true;
					}
				
				if(PlayState.map.getTileId(x, y + 2, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallDown1 != true){
					PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
					PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
					//Core.Items.Item.itemDrop(x ,y + 2);
					if(PlayState.map.getTileId(x, y + 3, PlayState.wallLayer) == 98){
						hitWallDown1 = true;							
						}
					
					if(PlayState.map.getTileId(x, y + 3, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallDown1 != true){
						PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
						//Core.Items.Item.itemDrop(x ,y + 3);							
						if(PlayState.map.getTileId(x, y + 4, PlayState.wallLayer) == 98){
							hitWallDown1 = true;					
							}
					
						if(PlayState.map.getTileId(x, y + 4, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallDown1 != true){
							PlayState.map.setTileId(x, y + 1, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 2, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 3, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y + 4, PlayState.fireLayerV, 143);
							//Core.Items.Item.itemDrop(x ,y + 4);
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
				Core.Items.Item.itemDrop(x ,y - 1);
			}
			else if(PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y - 1, PlayState.wallLayer ) == 98){
				hitWallUp = true;
			}
			else if(PlayState.map.getTileId(x, y - 2, PlayState.boxLayer) == 111 && blastRadius >= 2 && hitWallUp != true && hitBoxUp != true){
				PlayState.map.setTileId(x, y - 2, PlayState.boxLayer, 0);
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
				hitBoxUp = true;
				Core.Items.Item.itemDrop(x ,y - 2);
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
				Core.Items.Item.itemDrop(x ,y - 3);
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
				Core.Items.Item.itemDrop(x ,y - 4);
			}
			//If no boxes within blast radius range
			if(PlayState.map.getTileId(x, y - 1, PlayState.wallLayer) == 18 || PlayState.map.getTileId(x, y - 1, PlayState.wallLayer ) == 98){
				hitWallUp1 = true;
			}
			if (PlayState.map.getTileId(x, y - 1, PlayState.boxLayer) == 0 && hitWallUp1 != true) {
				PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
				//Core.Items.Item.itemDrop(x ,y - 1);
				if(PlayState.map.getTileId(x, y - 2, PlayState.wallLayer) == 98){
					hitWallUp1 = true;
					}
				
				if(PlayState.map.getTileId(x, y - 2, PlayState.boxLayer) == 0 && blastRadius >= 2 && hitWallUp1 != true){
					PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
					PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
					//Core.Items.Item.itemDrop(x ,y - 2);
					if(PlayState.map.getTileId(x, y - 3, PlayState.wallLayer) == 98){
						hitWallUp1 = true;							
						}
					
					if(PlayState.map.getTileId(x, y - 3, PlayState.boxLayer) == 0 && blastRadius >= 3 && hitWallUp1 != true){
						PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
						PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
						//Core.Items.Item.itemDrop(x ,y - 3);							
						if(PlayState.map.getTileId(x, y - 4, PlayState.wallLayer) == 98){
							hitWallUp1 = true;						
							}
					
						if(PlayState.map.getTileId(x, y - 4, PlayState.boxLayer) == 0 && blastRadius == 4 && hitWallUp1 != true){
							PlayState.map.setTileId(x, y - 1, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 2, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 3, PlayState.fireLayerV, 143);
							PlayState.map.setTileId(x, y - 4, PlayState.fireLayerV, 143);
							//Core.Items.Item.itemDrop(x ,y - 3);
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
	
	/**
	 * Remove Fire method:
	 * Removes the fire blast in the image (game board) 1 second after it has been applied.
	 * It is called in explodeBomb() method.
	 * The timer uses the same algorithm as in timerBomb() though it has its own
	 * timerDifFire variable which is the current time, when the method is called.
	 * If the 1 second passes the method runs two for-loops, which goes goes through
	 * the image in the length of 22x13. It checks for each tile if its ID fits either
	 * 123 (four-way fire), 143 (vertical fire), and/or 133 (horizontal fire), and set 
	 * its ID to 122 (a value not used) to remove them. 
	 * 
	 */
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
