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

public class SingleUserMode extends ActionBarActivity {

    private static final String FILENAME = "file.sav";
    private SinglePlayer player = new SinglePlayer("Player");
    private ArrayAdapter<Long> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player);
    }

    //Code for this method taken from Anju Eappen on Course
    //discussion, refer to readme (2) for details
    protected void getReactionTime(){
        final Button buzzer = (Button) findViewById(R.id.buzzerButton);
        Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();

        final Runnable showButton = new Runnable() {
            @Override
            public void run() {
                buzzer.setVisibility(View.VISIBLE);
                buzzer.setClickable(true);
                buzzer.requestLayout();
                Toast.makeText(getApplicationContext(),"PRESS BUZZER NOW!!!",Toast.LENGTH_SHORT);
            }
        };

        final Runnable hideButton = new Runnable() {
            @Override
            public void run() {
                buzzer.setVisibility(View.GONE);
                buzzer.setClickable(false);
                buzzer.requestLayout();
            }
        };

        final long startTime = System.currentTimeMillis();
        final long delay = 10 + new Random().nextInt(1990);
        buzzer.postDelayed(showButton,delay);

        buzzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buzzer.post(hideButton);
                v.requestLayout();
                player.updateReactionList(System.currentTimeMillis()-startTime-delay);
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
