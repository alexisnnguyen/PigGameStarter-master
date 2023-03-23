package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int playerid;
    private int player0Score;
    private int player1Score;
    private int currentTotal;
    private int currentVal;

    // Game State Constructor
    public PigGameState() {
        playerid = 0;
        player0Score = 0;
        player1Score = 0;
        currentTotal = 0;
        currentVal = 0;
    }
}
