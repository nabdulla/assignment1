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
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SingleUserMode extends ActionBarActivity {

    private static final String FILENAME = "file1.sav";
    public SinglePlayer player = new SinglePlayer("Player");
    protected FileManager fileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player);
        fileManager = new FileManager(FILENAME,this.getBaseContext());

    }

    @Override
    protected void onStart(){
        super.onStart();
        player.setReactionList(fileManager.loadFromFile(player));
    }

    //Code for this method taken from Anju Eappen on Course
    //discussion, refer to readme (2) for details
    public void getReactionTime(View v){
        final Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        startButton.setClickable(true);
        startButton.requestLayout();

        final Button buzzer = (Button) findViewById(R.id.buzzerButton);
        buzzer.setVisibility(View.GONE);
        buzzer.setClickable(false);
        buzzer.requestLayout();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.setVisibility(View.GONE);
                startButton.setClickable(false);
                startButton.requestLayout();


                final Runnable showButton = new Runnable() {
                    @Override
                    public void run() {
                        buzzer.setVisibility(View.VISIBLE);
                        buzzer.setClickable(true);
                        buzzer.requestLayout();
                    }
                };



                final long startTime = System.currentTimeMillis();
                final long delay = 10 + new Random().nextInt(1990);
                buzzer.postDelayed(showButton, delay);

                buzzer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.requestLayout();
                        player.updateReactionList(System.currentTimeMillis() - startTime - delay);
                        fileManager.saveInFile(player.getReactionList());
                        String rText = "Reaction Time is "+player.reactionList.get(0)+" ms";
                        Toast.makeText(SingleUserMode.this, rText, Toast.LENGTH_SHORT).show();
                        getReactionTime(v);
                    }
                });
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_user_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
