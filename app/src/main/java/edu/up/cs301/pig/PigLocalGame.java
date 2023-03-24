package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState game;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        game = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {

        //TODO  You will implement this method

        if (game.getPlayerID() == playerIdx) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method

        //If the action is a hold
        if (action instanceof PigHoldAction) {

            //Changes the score
            if (game.getPlayerID() == 0) {
                game.setPlayer0Score(game.getCurrentTotal() + game.getPlayer0Score());
            } else {
                game.setPlayer1Score(game.getCurrentTotal() + game.getPlayer1Score());
            }
            //Changes current val to 0
            game.setCurrentTotal(0);

            //Changes player ID
            if (game.getPlayerID() == 0) {
                game.setPlayerID(1);
            } else {
                game.setPlayerID(0);
            }
            return true; //legal action return true

        }
        //If the action is a roll
        else if (action instanceof PigRollAction){

            int dice = (int)(Math.random() * 6) + 1;
            game.setCurrentVal(dice);

            if (dice != 1) {
                game.setCurrentTotal(game.getCurrentTotal() + dice);
            } else {
                game.setCurrentTotal(0);
                if (game.getPlayerID() == 0) {
                    game.setPlayerID(1);
                } else {
                    game.setPlayerID(0);
                }
            }
            return true;

        }


        // if action is hold
        if (action instanceof PigHoldAction) {

            // if player is 0, set score to current score + running score
            if (game.getPlayerID() == 0) {
                game.setPlayer0Score(game.getPlayer0Score() + game.getCurrentTotal());
                return true;
            }

            // if player is 1, set score to current score + running score
            else {
                game.setPlayer1Score(game.getPlayer1Score() + game.getCurrentTotal());
                return true;
            }
        }
        // if action is roll
        if (action instanceof PigRollAction) {

            // roll the dice and set variable to value
            int dice = (int)(Math.random() * 6) + 1;
            game.setCurrentVal(dice);

            // if dice is not 1, add rolled value to current running total
            if (game.getCurrentVal() != 1) {
                game.setCurrentTotal(dice + game.getCurrentTotal());
                return true;
            }

            // if dice is 1, set current running total to 0 and switch turns;
            else {
                game.setCurrentTotal(0);
                if (players.length > 1) {
                    game.setPlayerID(1 - game.getPlayerID());
                }
                return true;
            }
        }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copy = new PigGameState(game);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {

        //TODO  You will implement this method
        String toRtn;
        if (game.getPlayer0Score() >= 50) {
            toRtn = "Player 1 won with a score of " + game.getPlayer0Score() + "!";
            return toRtn;
        }
        if (game.getPlayer1Score() >= 50) {
            toRtn = "Player 2 won with a score of " + game.getPlayer1Score() + "!";
            return toRtn;
        }



        // check if any of the scores exceed 50
        if (game.getPlayer1Score() >= 50 || game.getPlayer0Score() >= 50) {

            // if player 1 has a higher score, they win
            if (game.getPlayer1Score() > game.getPlayer0Score()) {
                return "Player 1 has won with a score of " + game.getPlayer1Score();
            }

            // if player 0 has a higher score, they win
            else {
                return "Player 0 has won with a score of " + game.getPlayer0Score();
            }
        }

        return null;
    }

}// class PigLocalGame
