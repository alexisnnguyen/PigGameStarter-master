package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int playerID;
    private int player0Score;
    private int player1Score;
    private int currentTotal;
    private int currentVal;

    // Game State Constructor
    public PigGameState() {
        playerID = 0;
        player0Score = 0;
        player1Score = 0;
        currentTotal = 0;
        currentVal = 1;
    }

    public PigGameState(PigGameState copy) {
        playerID = copy.playerID;
        player0Score = copy.player0Score;
        player1Score = copy.player1Score;
        currentTotal = copy.currentTotal;
        currentVal = copy.currentVal;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }
    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentVal(int currentVal) {
        this.currentVal = currentVal;
    }

    public int getCurrentVal() {
        return currentVal;
    }
}
