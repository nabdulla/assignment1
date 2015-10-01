package ca.nabdullaualberta.buzzergame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singlePlayerMode(View v){
        Button singleButton = (Button) findViewById(R.id.singlePlayerButton);
        singleButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, SingleUserMode.class);
                startActivity(intent);
            }
        });
    }

    public void callStatistics(View v){
        Button statsButton = (Button) findViewById(R.id.statisticsButton);
        statsButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, Stats.class);
                startActivity(intent);
            }
        });
    }

    public void multiPlayerMode(View v){
        Button multiButton = (Button) findViewById(R.id.multiPlayerButton);
        multiButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, MultiPlayerMode.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
