package ca.nabdullaualberta.buzzergame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class FourPlayerMode extends ActionBarActivity {

    private static final String FILENAME = "file4.sav";
    private MultiPlayer player1 = new MultiPlayer("Player 1");
    private MultiPlayer player2 = new MultiPlayer("Player 2");
    private MultiPlayer player3 = new MultiPlayer("Player 3");
    private MultiPlayer player4 = new MultiPlayer("Player 4");
    private ArrayAdapter<MultiPlayer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_player);
    }

    public void play4Player(View v){

        final Button start4Button = (Button) findViewById(R.id.start4Button);
        start4Button.setVisibility(View.VISIBLE);
        start4Button.setClickable(true);
        start4Button.requestLayout();

        final Button firstPlayer = (Button) findViewById(R.id.p1button);
        firstPlayer.setVisibility(View.GONE);
        firstPlayer.setClickable(false);
        firstPlayer.requestLayout();

        final Button secondPlayer = (Button) findViewById(R.id.p2button);
        secondPlayer.setVisibility(View.GONE);
        secondPlayer.setClickable(false);
        secondPlayer.requestLayout();

        final Button thirdPlayer = (Button) findViewById(R.id.p3button);
        thirdPlayer.setVisibility(View.GONE);
        thirdPlayer.setClickable(false);
        thirdPlayer.requestLayout();

        final Button fourthPlayer = (Button) findViewById(R.id.p4button);
        fourthPlayer.setVisibility(View.GONE);
        fourthPlayer.setClickable(false);
        fourthPlayer.requestLayout();

        start4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start4Button.setVisibility(View.GONE);
                start4Button.setClickable(false);
                start4Button.requestLayout();

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

                        fourthPlayer.setVisibility(View.VISIBLE);
                        fourthPlayer.setClickable(true);
                        fourthPlayer.requestLayout();

                    }
                };

                firstPlayer.post(showButton);

                firstPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(FourPlayerMode.this, "Player 1", Toast.LENGTH_SHORT).show();
                        //player1.addBuzz();
                        play4Player(view);
                    }
                });

                secondPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(FourPlayerMode.this, "Player 2", Toast.LENGTH_SHORT).show();
                        //player2.addBuzz();
                        play4Player(view);
                    }
                });

                thirdPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(FourPlayerMode.this, "Player 3", Toast.LENGTH_SHORT).show();
                        //player3.addBuzz();
                        play4Player(view);
                    }
                });

                fourthPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.requestLayout();
                        Toast.makeText(FourPlayerMode.this, "Player 4", Toast.LENGTH_SHORT).show();
                        //player4.addBuzz();
                        play4Player(view);
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player_mode, menu);
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
