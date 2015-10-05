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
        List<Long> rlist = new ArrayList<>();
        int minIndex;
        int rlsize = reactionList.size();

        if (size<rlsize){
            rlist = reactionList.subList(0, size);
        } else if (rlsize == 0) {
            return 0;
        }else if (rlsize == 1) {
            return reactionList.get(0);
        }
        else {
            rlist = reactionList.subList(0,rlsize);
        }
        minIndex = rlist.indexOf(Collections.min(rlist));
        return rlist.get(minIndex);

    }
    //Returning the maximum reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long maxTime(int size){
        List<Long> rlist;
        int maxIndex;
        int rlsize = reactionList.size();

        if (size<rlsize){
            rlist = reactionList.subList(0, size);
        } else if (rlsize == 0) {
            return 0;
        }else if (rlsize == 1) {
            return reactionList.get(0);
        } else {
            rlist = reactionList.subList(0, rlsize);
        }
        maxIndex = rlist.indexOf(Collections.max(rlist));
        return rlist.get(maxIndex);
    }

    //Returning the average reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long avgTime(int size){
        List<Long> rlist;
        int sum = 0;
        int count = 0;
        int rlsize = reactionList.size();

        if (size<rlsize){
            rlist = reactionList.subList(0, size);
        } else if (rlsize == 0) {
            return 0;
        }else if (rlsize == 1) {
            return reactionList.get(0);
        } else {
            rlist = reactionList.subList(0,rlsize);
            size = rlsize;
        }
        for (int i = 0; i < rlist.size(); i++) {
            sum += rlist.get(i);
            count += 1;
        }

        return sum/count;
    }

    //Returning the median reaction time from a sublist of
    //"reactionList" containing the first "size" number of
    //elements
    public long medTime(int size){
        List<Long> rlist;
        int medIndex;
        int rlsize = reactionList.size();

        if (size<rlsize){
            rlist = reactionList.subList(0, size);
            medIndex = size/2;
        } else if (rlsize == 0) {
            return 0;
        } else if (rlsize == 1) {
            return reactionList.get(0);
        } else {
            rlist = reactionList.subList(0,rlsize);
            medIndex = rlsize/2;
        }

        Collections.sort(rlist);

        return rlist.get(medIndex);
    }


}
