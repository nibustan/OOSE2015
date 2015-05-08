package Core;

public class GameController {
<<<<<<< HEAD
	private byte playersAlive;
=======
	public static byte playersAlive = 2;
>>>>>>> origin/master
	public static boolean player1Alive = true;
	public static boolean player2Alive = true;
	private byte gamesWon1;
	private byte gamesWon2;
	private byte gameTurn;
	public boolean player1Win = false;
	public boolean player2Win = false;

	void init() {
		gameTurn = 1;
	}

	/**
	 * update method: 
	 * Updates the scores for the players and controls if a player has won more
	 * than 2 games, it loads the score screen.
	 */
	void update() {

		if (playersAlive < 2) {
			if (player1Alive == true) {
				gamesWon1++;
			} else if (player2Alive == true) {
<<<<<<< HEAD
				++gamesWon2;
			} else if (player1Alive == false && player2Alive == false
					&& gamesWon1 > 0 && gamesWon2 > 0) {
				--gamesWon1;
				--gamesWon2;
			}
			if (gamesWon1 < 3 && gamesWon2 < 3) {
				loadNextTurn();
=======
				gamesWon2++;
			} 
			if (gamesWon1 < 3 && gamesWon2 < 3) {
				if(startLoadNextTurn == true){
					loadNextTurn();
				}
>>>>>>> origin/master
			} else if (gamesWon1 > 2 && gamesWon1 > gamesWon2) {
				player1Win = true;
				loadScoreScreen();
			} else if (gamesWon2 > 2 && gamesWon2 > gamesWon1) {
				player2Win = true;
				loadScoreScreen();
			}
		}
	}
	/**
	 * loadNextTurn method:
	 * Loads level, sets the players alive to be 2, and increments the game turn.
	 */
	void loadNextTurn() {
		// load level
		playersAlive = 2;
		++gameTurn;
	}
<<<<<<< HEAD

	void loadScoreScreen() {
=======
	static void loadScoreScreen() {
>>>>>>> origin/master

	}
}