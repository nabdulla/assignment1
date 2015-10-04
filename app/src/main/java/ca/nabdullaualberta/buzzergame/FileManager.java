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
 * Created by nabdulla on 10/3/15.
 */
public class FileManager {
    final protected String FILENAME;

    public String getFILENAME() {
        return FILENAME;
    }

    public FileManager(String fileName) {
        this.FILENAME = fileName;
    }

    protected ArrayList<Long> loadFromFile(SinglePlayer player, Context context) {

        ArrayList<Long> reactionTimes = new ArrayList<Long>();
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Long>>() {
            }.getType();
            reactionTimes = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            reactionTimes = new ArrayList<Long>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return reactionTimes;
    }


    protected ArrayList<MultiPlayer> loadFromFile(MultiPlayer player, Context context){
        ArrayList<MultiPlayer> players = new ArrayList<>();
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<MultiPlayer>>(){}.getType();
            players = gson.fromJson(in, listType);
        } catch (FileNotFoundException e){
            players = new ArrayList<MultiPlayer>();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return players;
    }

    protected void saveInFile(List list, Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
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
}
