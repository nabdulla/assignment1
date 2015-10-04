package ca.nabdullaualberta.buzzergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nabdulla on 9/29/15.
 *
 * A Player class for the single-user mode
 * all code related to methods on List objects
 * taken from oracle website, refer to readme (1) for
 * more information
 */
public class SinglePlayer extends Player {
    public ArrayList<Long> reactionList = new ArrayList<Long>();

    public SinglePlayer(String playerNo) {
        super(playerNo);
        this.setPlayerNo(playerNo);
    }

    public ArrayList<Long> getReactionList() {
        return reactionList;
    }

    public void setReactionList(ArrayList<Long> reactionList) {
        this.reactionList = reactionList;
    }

    /*
    //Ensuring the List can hold 100 data points
    public void setReactionList(ArrayList reactionList) {
        reactionList.ensureCapacity(100);
    }
    */

    //Adding the last reaction time to the list for
    //statistical purposes
    public void updateReactionList(long reactionTime){
        reactionList.add(0, reactionTime);

        //ensuring the list does not contain > 100 data points
        //if so, the last data point is removed
        if(reactionList.size() > 100) {
            reactionList.remove(reactionList.size()-1);
        }
    }

    //Returning the minimum reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long minTime(int size) {
        List<Long> rlist;
        int minIndex;

        rlist = reactionList.subList(0, size);
        minIndex = rlist.indexOf(Collections.min(rlist));

        return rlist.get(minIndex);
    }
    //Returning the maximum reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long maxTime(int size){
        List<Long> rlist;
        int maxIndex;

        rlist = reactionList.subList(0, size);
        maxIndex = rlist.indexOf(Collections.max(rlist));

        return rlist.get(maxIndex);
    }

    //Returning the average reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long avgTime(int size){
        List<Long> rlist;
        int sum = 0;

        rlist = reactionList.subList(0, size);
        for (int i = 0; i < rlist.size()-1; i++) {
            sum += rlist.get(i);
        }

        return sum/size;
    }

    //Returning the median reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long medTime(int size){
        List<Long> rlist;
        int medIndex;

        rlist = reactionList.subList(0,size);
        Collections.sort(rlist);
        medIndex = size/2;

        return rlist.get(medIndex);
    }


}
