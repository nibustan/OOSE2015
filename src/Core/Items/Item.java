package Core.Items;
import java.util.Random;
import Core.GameState.PlayState;


//	Items spawn from destroyed box objects

public class Item {
	
	//public static int x,y,bombAmount, bombLength;

	
		
//		Is the Item inside of a bombBlast?
	//boolean inBlast = false;
	
//	Has a 'Player' moved onto the same tile as the Item?
	//boolean pickedUp = false;
		
	
	
	//public Item(int x, int y, int bombAmount, int bombLength) {
		//this.x = x;
		//this.y = y;
		//this.bombAmount = bombAmount;
		//this.bombLength = bombLength;
	//}
	
	public void update(){
		//itemDrop();
	}
	
	/**
	 * 25% chance of an item spawning.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 */
	public static void itemDrop(int x, int y, int bombAmount, int bombLength){
		int min = 0;
		int max = 4;
		Random rand = new Random();
		int spawn = rand.nextInt((max-min)+1)+min;
		if(spawn == 1){
			randomDrop(x, y, bombAmount, bombLength);
		}
	}
	/**
	 * Determines which item spawns from the 5 available.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 */
	public static void randomDrop(int x, int y, int bombAmount, int bombLength){
		int min = 1;
		int max = 5;
		Random rand = new Random();
		int randomNum = rand.nextInt((max-min)+1)+min;
		if(randomNum == 1){
			bombUp(x,y,bombAmount);
		} else if (randomNum == 2){
			bombDown(x,y,bombAmount);
		} else if (randomNum == 3){
			fireUp(x,y,bombLength);
		} else if (randomNum == 4){
			fireDown(x,y,bombLength);
		} else if (randomNum == 5){
			powerBomb(x,y,bombLength);
		}
	}
	
	/**
	 * Bomb Up - Adds 1 to the players active bomb amount, meaning how many they can
	 * 			 have out on the map the same time.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 * @param bombAmount = number of active bombs a player can have on the map at a time.
	 * @return = changed bombAmount
	 */
	public static int bombUp(int x, int y,int bombAmount){
		PlayState.map.setTileId(x, y, PlayState.bombUpLayer, 155);
		
		if(bombAmount > 4){
			bombAmount++;
		}
		return bombAmount;
	}
	
	/**
	 * Bomb Down - Detracts 1 from the players bomb amount.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 * @param bombAmount = number of active bombs a player can have on the map at a time.
	 * @return = changed bombAmount
	 */
	public static int bombDown(int x, int y,int bombAmount){
		PlayState.map.setTileId(x, y, PlayState.bombDownLayer, 165);
		
		if(bombAmount > 1){
			bombAmount--;
		}
		return bombAmount;
	}
	
	/**
	 * Fire Up - Adds 1 tilelength to the radius of a players bomblength.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 * @param bombLength = number that determines how many tilelengths a fireblast travels.
	 * @return = changed bombLength
	 */
	public static int fireUp(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.fireUpLayer, 175);
		
		if(bombLength < 7){
			bombLength++;
		}
		return bombLength;
	}
	
	/**
	 * Fire Down - Removes 1 tilelength from the radius of a players bomblength.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 * @param bombLength = number that determines how many tilelengths a fireblast travels.
	 * @return = changed bombLength
	 */
	public static int fireDown(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.fireDownLayer, 185);
		
		if(bombLength > 1){
			bombLength--;
		}
		return bombLength;
	}
	
	/**
	 * Power Bomb - Maxes out a players bombLength.
	 * @param x = x position of the item
	 * @param y = y position of the item
	 * @param bombLength = number that determines how many tilelengths a fireblast travels.
	 * @return = changed bombLength
	 */
	public static int powerBomb(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.powerBombLayer, 195);
		
		bombLength = 12;
		
		return bombLength;
	}
}
