package ca.nabdullaualberta.buzzergame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class ThreePlayerMode extends ActionBarActivity {

    private static final String FILENAME = "file3.sav";
    private MultiPlayer player1 = new MultiPlayer("Player 1");
    private MultiPlayer player2 = new MultiPlayer("Player 2");
    private MultiPlayer player3 = new MultiPlayer("Player 3");
    private ArrayAdapter<MultiPlayer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_player);
    }

    public void play3Player(View v){
        final Button start3Button = (Button) findViewById(R.id.start3Button);
        start3Button.setVisibility(View.VISIBLE);
        start3Button.setClickable(true);
        start3Button.requestLayout();

        final Button firstPlayer = (Button) findViewById(R.id.playerOneButton);
        firstPlayer.setVisibility(View.GONE);
        firstPlayer.setClickable(false);
        firstPlayer.requestLayout();

        final Button secondPlayer = (Button) findViewById(R.id.playerTwoButton);
        secondPlayer.setVisibility(View.GONE);
        secondPlayer.setClickable(false);
        secondPlayer.requestLayout();

        final Button thirdPlayer = (Button) findViewById(R.id.playerThreeButton);
        thirdPlayer.setVisibility(View.GONE);
        thirdPlayer.setClickable(false);
        thirdPlayer.requestLayout();

        start3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start3Button.setVisibility(View.GONE);
                start3Button.setClickable(false);
                start3Button.requestLayout();

                final Runnable showButton = new Runnable() {
                    @Override
                    public void run() {
                        firstPlayer.setVisibility(View.VISIBLE);
                        firstPlayer.setClickable(true);
                        firstPlayer.requestLayout();

                        secondPlayer.setVisibility(View.VISIBLE);
                        secondPlayer.setClickable(true);
                        secondPlayer.requestLayout();

                        thirdPlayer.setVisibility(View.VISIBLE);
                        thirdPlayer.setClickable(true);
                        thirdPlayer.requestLayout();
                    }
                };

                firstPlayer.post(showButton);

                firstPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(ThreePlayerMode.this, "Player 1", Toast.LENGTH_SHORT).show();
                        //player1.addBuzz();
                        play3Player(view);
                    }
                });

                secondPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(ThreePlayerMode.this, "Player 2", Toast.LENGTH_SHORT).show();
                        //player2.addBuzz();
                        play3Player(view);
                    }
                });

                thirdPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(ThreePlayerMode.this, "Player 3", Toast.LENGTH_SHORT).show();
                        //player3.addBuzz();
                        play3Player(view);
                    }
                });
            };
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player_mode, menu);
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
