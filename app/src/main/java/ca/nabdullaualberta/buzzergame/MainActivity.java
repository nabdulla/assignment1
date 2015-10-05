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

            public void onClick(View v) {//to go to reaction time game
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, SingleDialog.class);
                startActivity(intent);
            }
        });
    }

    public void callStatistics(View v){
        Button statsButton = (Button) findViewById(R.id.statisticsButton);
        statsButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){//to go to statistics page
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, Stats.class);
                startActivity(intent);
            }
        });
    }

    public void multiPlayerMode(View v){
        Button multiButton = (Button) findViewById(R.id.multiPlayerButton);
        multiButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){//to go to multiplayer mode
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
