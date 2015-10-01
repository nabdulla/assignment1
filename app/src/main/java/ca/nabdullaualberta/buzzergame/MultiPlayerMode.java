package ca.nabdullaualberta.buzzergame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MultiPlayerMode extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_player);
    }

    public void twoPlayerMode(View v){
        Button twoButton = (Button) findViewById(R.id.two2Button);
        twoButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent intent = new Intent(MultiPlayerMode.this, TwoPlayerMode.class);
                startActivity(intent);
            }
        });
    }

    public void threePlayerMode(View v){
        Button threeButton = (Button) findViewById(R.id.three3button);
        threeButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                setResult(RESULT_OK);
                Intent intent = new Intent(MultiPlayerMode.this, ThreePlayerMode.class);
                startActivity(intent);
            }
        });
    }

    public void fourPlayerMode(View v){
        Button fourButton = (Button) findViewById(R.id.four4button);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                Intent intent = new Intent(MultiPlayerMode.this, FourPlayerMode.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_player_mode, menu);
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
