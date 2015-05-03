package Core.Items;

//	The 'Item' class will be the parent class for the 'PowerUp' class and the 'PowerDown' class.
//	Item's spawn from destroyed box objects

public class Item {

	public static void main(String[] args) {
		
	//	Is the Item inside of a bombblast?
	boolean inBlast = false;
	
//	Has a 'Player' moved onto the same tile as the Item?
	boolean pickedUp = false;
	
		
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
