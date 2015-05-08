package Core;

import Core.GameState.PlayState;

public class GameController {
	private static byte playersAlive = 2;
	public static boolean player1Alive = true;
	public static boolean player2Alive = true;
	public static boolean drawScores;
	public static byte gamesWon1 = 0;
	public static byte gamesWon2 = 0;
	private static byte gameTurn = 1;
	private static long loadTimerDif;
	public static boolean player1Win = false;
	public static boolean player2Win = false;
	
	protected static long loadingStart;
	protected static long loadingTimerDif;
	protected static long loadingTime = 2000;

	public static boolean startLoading;
	private static boolean startLoadNextTurn;
	
	void init() {
		gameTurn = 1;
	}

	/**
	 * update method: 
	 * Updates the scores for the players and controls if a player has won more
	 * than 2 games, it loads the score screen.
	 */
	public static void update() {
		startLoading = true;
		if (playersAlive < 2) {
			if (player1Alive == true) {
				++gamesWon1;
			} else if (player2Alive == true) {
				++gamesWon2;
			} 
			if (gamesWon1 < 3 && gamesWon2 < 3) {
				if(startLoadNextTurn == true){
					loadNextTurn();
				}
			}
			if (gamesWon1 < 3 && gamesWon2 < 3) {
				loadNextTurn();
			} else if (gamesWon1 > 2 && gamesWon1 > gamesWon2) {
				player1Win = true;
				loadScoreScreen();
			} else if (gamesWon2 > 2 && gamesWon2 > gamesWon1) {
				player2Win = true;
				loadScoreScreen();
			}
			if(startLoading == true){
				startLoading = false;
				startLoadNextTurn = true;
			}
		}
	}
	/**
	 * loadNextTurn method:
	 * Loads level, sets the players alive to be 2, and increments the game turn.
	 */
	static void loadNextTurn() {
		loadTimerDif = System.currentTimeMillis();
		drawScores = true;
		if(loadTimerDif-loadingStart > loadingTime){
			drawScores = false;
			PlayState.loadingScores = false;
			playersAlive = 2;
			++gameTurn;
			startLoadNextTurn=false;
		}
		
	}

	static void loadScoreScreen() {

	}
}