package Core;

public class Bombs {

	boolean isExploded = false;
	int time = 0;
	
	public void timerBomb(){ //COUNTDOWN FOR BOMB EXPLOSION
		time += getDelta(); //add the time passed since last update()
	    if(time > 3000){ //3 seconds = 3000 ms
	    	explodeBomb();
	    	time = 0;
	    }	   
	}
	
	public long getTime() {
	    return System.nanoTime() / 1000000;
	}

	public int getDelta() {
		long lastFrame = 0;
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
	         
	    return delta;
	}
	
	public void explodeBomb(){ //BOMB EXPLOSION
		isExploded = true;
		if(isExploded = true)
			removeBomb();
	}
	
	public void removeBomb(){
		//REMOVE BOMB AFTER EXPLOSION
	}

}
