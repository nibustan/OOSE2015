package Core.Items;

import java.util.Random;


//	Items spawn from destroyed box objects

public class Item {
	
	Random rand;

	public static void main(String[] args) {
		
	//	Is the Item inside of a bombblast?
	boolean inBlast = false;
	
//	Has a 'Player' moved onto the same tile as the Item?
	boolean pickedUp = false;
	
	
		
	}
	
	public void randomChance(int bombAmount){
		int min = 0;
		int max = 5;
		rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		if(randomNum == 1){
			bombUp(bombAmount);
		} else if (randomNum == 2){
			bombDown(bombAmount);
		} else if (randomNum == 3){
			fireUp(bombAmount);
		} else if (randomNum == 4){
			fireDown(bombAmount);
		} else if (randomNum == 5){
			powerBomb(bombAmount);
		}
	}
	
	//Bomb Up - Adds 1 to the players bomb amount.
	public static int bombUp(int bombAmount){
		if(bombAmount > 4){
			bombAmount++;
		}
		return bombAmount;
	}
	
	//Bomb Down - Detracts 1 from the players bomb amount.
	public static int bombDown(int bombAmount){
		if(bombAmount > 1){
			bombAmount--;
		}
		return bombAmount;
	}
	
	//Fire Up - Adds 1 tilelength to the radius of a players bomblength.
	public static int fireUp(int bombLength){
		if(bombLength < 7){
			bombLength++;
		}
		return bombLength;
	}
	
	//Fire Down - Removes 1 tilelength from the radius of a players bomblength.
	public static int fireDown(int bombLength){
		if(bombLength > 1){
			bombLength--;
		}
		return bombLength;
	}
	
	//Power Bomb - Maxes out a players bombLength.
	public static int powerBomb(int bombLength){
		bombLength = 12;
		
		return bombLength;
	}
}
