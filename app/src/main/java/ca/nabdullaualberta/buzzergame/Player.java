package ca.nabdullaualberta.buzzergame;

import java.util.ArrayList;

/**
 * Created by nabdulla on 9/29/15.
 *
 * Abstract Player Class which only contains the player
 * number as a string (etc. "Player 1")
 */
public abstract class Player extends Object{
    protected String playerNo;

    public Player(String playerNo) {
        this.setPlayerNo(playerNo);
    }

    public String getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(String playerNo) {
        this.playerNo = playerNo;
    }
}
