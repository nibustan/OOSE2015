package Core;

public class Bombs {

	boolean isExploded = false;
	int time = 0;
	
	public void timerBomb(GameController gc, int delta){ //COUNTDOWN FOR BOMB EXPLOSION
		time += delta; //add the time passed since last update()
	    if(time > 3000){ //3 seconds = 3000 ms
	    	explodeBomb();
	    	time = 0;
	    }	   
	}
	
	public void explodeBomb(){
		//EXPLOSION FOR BOMB
	}
	
	public void removeBomb(){
		//REMOVE BOMB AFTER EXPLOSION
	}

}
