/*Copyright 2015 Nabil Abdulla

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/

package ca.nabdullaualberta.buzzergame;

/**
 * Created by nabdulla on 9/29/15. A class for players in the multiplayer mode
 */
public class MultiPlayer extends Player {
    private int nBuzzes = 0;
    private int numPlayers;

    public MultiPlayer(String playerNo) {
        super(playerNo);
        this.setPlayerNo(playerNo);
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
