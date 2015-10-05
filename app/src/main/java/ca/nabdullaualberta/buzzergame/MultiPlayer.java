package ca.nabdullaualberta.buzzergame;

/**
 * Created by nabdulla on 9/29/15.
 */
public class MultiPlayer extends Player {
    private int nBuzzes;
    private int numPlayers;

    public MultiPlayer(String playerNo) {
        super(playerNo);
        this.setPlayerNo(playerNo);
    }

    public void initializeBuzz() {
        nBuzzes = 0;
    }

    public void addBuzz() {
        nBuzzes += 1;
    }

    public void setnBuzzes(int n){
        nBuzzes = n;
    }

    public int getnBuzzes() {
        return nBuzzes;
    }

    public void setNumPlayers(int num){
        numPlayers = num;
    }

    public int getNumPlayers() {
        return numPlayers;
    }


}
