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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by nabdulla on 10/3/15. Class used for loading,saving and clearing game files
 */
public class FileManager {
    final protected String FILENAME;
    protected Context context;

    public FileManager(String FILENAME, Context context) {
        this.FILENAME = FILENAME;
        this.context = context;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public FileManager(String fileName) {
        this.FILENAME = fileName;
    }

    protected ArrayList<Long> loadFromFile(SinglePlayer player) {

        ArrayList<Long> reactionTimes = new ArrayList<Long>();
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Long>>() {
            }.getType();
            reactionTimes = gson.fromJson(in, listType);
            fis.close();
        } catch (FileNotFoundException e) {
            reactionTimes = new ArrayList<Long>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return reactionTimes;
    }


    protected ArrayList<MultiPlayer> loadFromFile(MultiPlayer player){
        ArrayList<MultiPlayer> players = new ArrayList<>();
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<MultiPlayer>>(){}.getType();
            players = gson.fromJson(in, listType);
            fis.close();
        } catch (FileNotFoundException e){
            players = new ArrayList<MultiPlayer>();
            if(player.getNumPlayers() == 2) {
                players.add(0,new MultiPlayer("Player 2"));
                players.add(0,new MultiPlayer("Player 1"));
            } else if(player.getNumPlayers() == 3) {
                players.add(0,new MultiPlayer("Player 3"));
                players.add(0,new MultiPlayer("Player 2"));
                players.add(0,new MultiPlayer("Player 1"));
            } else if(player.getNumPlayers() == 4) {
                players.add(0,new MultiPlayer("Player 4"));
                players.add(0,new MultiPlayer("Player 3"));
                players.add(0,new MultiPlayer("Player 2"));
                players.add(0,new MultiPlayer("Player 1"));
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return players;
    }

    protected void saveInFile(List list){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(list, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

    protected void clearFile(SinglePlayer singlePlayer){
        ArrayList<Long> reactionList = new ArrayList<>();
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(reactionList, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

    protected void clearFile(MultiPlayer multiPlayer){
        ArrayList<MultiPlayer> players = new ArrayList<MultiPlayer>();

        if (multiPlayer.getNumPlayers() == 2) {
            players.add(new MultiPlayer("Player 1"));
            players.add(new MultiPlayer("Player 2"));
        } else if(multiPlayer.getNumPlayers() == 3){
            players.add(new MultiPlayer("Player 1"));
            players.add(new MultiPlayer("Player 2"));
            players.add(new MultiPlayer("Player 3"));
        } else if(multiPlayer.getNumPlayers() == 4){
            players.add(new MultiPlayer("Player 1"));
            players.add(new MultiPlayer("Player 2"));
            players.add(new MultiPlayer("Player 3"));
            players.add(new MultiPlayer("Player 4"));
        }
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(players, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
}
