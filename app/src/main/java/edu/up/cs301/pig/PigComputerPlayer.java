package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        try {
            Thread.sleep(800);

            PigGameState pig = new PigGameState((PigGameState)info);
            if (pig.getPlayerID() != playerNum) {
                return;
            } else {

                int chance = (int)(Math.random() * 2);

                if (chance == 0) {
                    game.sendAction(new PigHoldAction(this));
                } else {
                    game.sendAction(new PigRollAction(this));
                }

            }
        } catch (InterruptedException e){}

    }//receiveInfo

}
