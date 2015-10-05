package ca.nabdullaualberta.buzzergame;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Stats extends ActionBarActivity {

    private final static String FILENAME1 = "file1.sav";
    private final static String FILENAME2 = "file2.sav";
    private final static String FILENAME3 = "file3.sav";
    private final static String FILENAME4 = "file4.sav";

    public SinglePlayer player1 = new SinglePlayer("Player 1");
    public MultiPlayer player2 = new MultiPlayer("Player 2");
    public MultiPlayer player3 = new MultiPlayer("Player 3");
    public MultiPlayer player4 = new MultiPlayer("Player 4");

    private ArrayList<MultiPlayer> players2;
    private ArrayList<MultiPlayer> players3;
    private ArrayList<MultiPlayer> players4;

    private String onePlayerString;
    private String twoPlayerString;
    private String threePlayerString;
    private String fourPlayerString;
    private String gameStats;

    protected FileManager fileManager1;
    protected FileManager fileManager2;
    protected FileManager fileManager3;
    protected FileManager fileManager4;

    private TextView stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        fileManager1 = new FileManager(FILENAME1,this.getBaseContext());
        fileManager2 = new FileManager(FILENAME2,this.getBaseContext());
        fileManager3 = new FileManager(FILENAME3,this.getBaseContext());
        fileManager4 = new FileManager(FILENAME4,this.getBaseContext());

        player2.setNumPlayers(2);
        player3.setNumPlayers(3);
        player4.setNumPlayers(4);

    }

    protected void onStart(){
        super.onStart();

        player1.setReactionList(fileManager1.loadFromFile(player1));
        players2 = fileManager2.loadFromFile(player2);
        players3 = fileManager3.loadFromFile(player3);
        players4 = fileManager4.loadFromFile(player4);

        onePlayerString = "Single Player: \nMinimum Reaction Time:\nLast 10: " +
                player1.minTime(10) + " ms, Last 100: " + player1.minTime(100) +
                " ms\n\nMaximum Reaction Time:\nLast 10: " + player1.maxTime(10) +
                " ms, Last 100: " + player1.maxTime(100) + " ms\n\nAverage Reaction Time:"
                + "\nLast 10: " + player1.avgTime(10) + " ms, Last 100: " +
                player1.avgTime(100) + " ms\n\nMedian Reaction Time:\nLast 10: " +
                player1.medTime(10) + " ms, Last 100: " +player1.medTime(100) + " ms\n\n";

        twoPlayerString = "2 Player:\nPlayer 1 buzzes: " + players2.get(0).getnBuzzes()
                + ", Player 2 buzzes: " + players2.get(1).getnBuzzes() + "\n\n";
        threePlayerString = "3 Player:\nPlayer 1 buzzes: " + players3.get(0).getnBuzzes()
                + ", Player 2 buzzes: " + players3.get(1).getnBuzzes() + "\n" +
                "Player 3 buzzes: " + players3.get(2).getnBuzzes() + "\n\n";
        fourPlayerString = "4 Player:\nPlayer 1 buzzes: " + players4.get(0).getnBuzzes()
                + ", Player 2 buzzes: " + players4.get(1).getnBuzzes() + "\n"+
                "Player 3 buzzes: " + players4.get(2).getnBuzzes() + ", Player 4 " +
                "buzzes: " + players4.get(3).getnBuzzes() + "\n\n";
        gameStats = onePlayerString+twoPlayerString+threePlayerString+fourPlayerString;

        stats = (TextView) findViewById(R.id.statsTextView);
        stats.setText(gameStats);

    }

    public void clearStats(View v){
        final Button clearButton = (Button) findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileManager1.clearFile(player1);
                fileManager2.clearFile(player2);
                fileManager3.clearFile(player3);
                fileManager4.clearFile(player4);

                player1.setReactionList(fileManager1.loadFromFile(player1));
                players2 = fileManager2.loadFromFile(player2);
                players3 = fileManager3.loadFromFile(player3);
                players4 = fileManager4.loadFromFile(player4);

                onePlayerString = "Single Player: \nMinimum Reaction Time:\nLast 10: " +
                        player1.minTime(10) + " ms, Last 100: " + player1.minTime(100) +
                        " ms\n\nMaximum Reaction Time:\nLast 10: " + player1.maxTime(10) +
                        " ms, Last 100: " + player1.maxTime(100) + " ms\n\nAverage Reaction Time:"
                        + "\nLast 10: " + player1.avgTime(10) + " ms, Last 100: " +
                        player1.avgTime(100) + " ms\n\nMedian Reaction Time:\nLast 10: " +
                        player1.medTime(10) + " ms, Last 100: " + player1.medTime(100) + " ms\n\n";

                twoPlayerString = "2 Player:\nPlayer 1 buzzes: " + players2.get(0).getnBuzzes()
                        + ", Player 2 buzzes: " + players2.get(1).getnBuzzes() + "\n\n";
                threePlayerString = "3 Player:\nPlayer 1 buzzes: " + players3.get(0).getnBuzzes()
                        + ", Player 2 buzzes: " + players3.get(1).getnBuzzes() + "\n" +
                        "Player 3 buzzes: " + players3.get(2).getnBuzzes() + "\n\n";
                fourPlayerString = "4 Player:\nPlayer 1 buzzes: " + players4.get(0).getnBuzzes()
                        + ", Player 2 buzzes: " + players4.get(1).getnBuzzes() + "\n" +
                        "Player 3 buzzes: " + players4.get(2).getnBuzzes() + ", Player 4 " +
                        "buzzes: " + players4.get(3).getnBuzzes() + "\n\n";
                gameStats = onePlayerString + twoPlayerString + threePlayerString + fourPlayerString;

                stats.setText(gameStats);
                view.requestLayout();
            }
        });

    }

    public void emailStats(View v){// code for sending an email taken from android developers webpage
                                   // refer to readme(3) for more info
        final Button emailButton = (Button) findViewById(R.id.emailButton);

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: "));
                intent.putExtra(intent.EXTRA_TEXT,gameStats);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
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
