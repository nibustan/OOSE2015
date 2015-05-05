package Core.Items;
import java.util.Random;
import Core.GameState.PlayState;


//	Items spawn from destroyed box objects

public class Item {
	
	public int x,y,bombAmount;

	
	public static void main(String[] args) {
		
	//	Is the Item inside of a bombblast?
	//boolean inBlast = false;
	
//	Has a 'Player' moved onto the same tile as the Item?
	//boolean pickedUp = false;
	}
	
	public Item(int x, int y, int bombAmount) {
		this.x = x;
		this.y = y;
		this.bombAmount = bombAmount;
	}
	
	public void update(){
		itemDrop();
	}
	
	// 25% chance of an item spawning.
	public void itemDrop(){
		int min = 0;
		int max = 4;
		Random rand = new Random();
		int spawn = rand.nextInt((max-min)+1)+min;
		if(spawn == 1){
			randomDrop();
		}
	}
	
	public void randomDrop(){
		int min = 1;
		int max = 5;
		Random rand = new Random();
		int randomNum = rand.nextInt((max-min)+1)+min;
		if(randomNum == 1){
			bombUp(x,y,bombAmount);
		} else if (randomNum == 2){
			bombDown(x,y,bombAmount);
		} else if (randomNum == 3){
			fireUp(x,y,bombAmount);
		} else if (randomNum == 4){
			fireDown(x,y,bombAmount);
		} else if (randomNum == 5){
			powerBomb(x,y,bombAmount);
		}
	}
	
	//Bomb Up - Adds 1 to the players bomb amount.
	public static int bombUp(int x, int y,int bombAmount){
		PlayState.map.setTileId(x, y, PlayState.bombUpLayer, 155);
		
		if(bombAmount > 4){
			bombAmount++;
		}
		return bombAmount;
	}
	
	//Bomb Down - Detracts 1 from the players bomb amount.
	public static int bombDown(int x, int y,int bombAmount){
		PlayState.map.setTileId(x, y, PlayState.bombDownLayer, 165);
		
		if(bombAmount > 1){
			bombAmount--;
		}
		return bombAmount;
	}
	
	//Fire Up - Adds 1 tilelength to the radius of a players bomblength.
	public static int fireUp(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.fireUpLayer, 175);
		
		if(bombLength < 7){
			bombLength++;
		}
		return bombLength;
	}
	
	//Fire Down - Removes 1 tilelength from the radius of a players bomblength.
	public static int fireDown(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.fireDownLayer, 185);
		
		if(bombLength > 1){
			bombLength--;
		}
		return bombLength;
	}
	
	//Power Bomb - Maxes out a players bombLength.
	public static int powerBomb(int x, int y,int bombLength){
		PlayState.map.setTileId(x, y, PlayState.powerBombLayer, 195);
		
		bombLength = 12;
		
		return bombLength;
	}
}
