package com.al.microdomorm.app;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.al.microdomorm.app.db.BoxRepository;
import com.al.microdomorm.app.db.DaoSessionManager;
import com.mydao.sample.Box;

import java.util.List;


public class HomeActivity extends ActionBarActivity {

    TextView resultText;
   private BoxRepository boxRepository;
    volatile  boolean done =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        boxRepository = new BoxRepository(this, DaoSessionManager.newInstance(this));
        resultText = (TextView)findViewById(R.id.resultText);
        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        */

        /*
        synchronized (this){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++){
                        boxRepository.addNew(
                                new Box(null,"Item " + i,i,"descr " + i)
                        );
                    }
                }
            }).run();
            done = true;
        }

        */
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Box> boxList = boxRepository.getAll();
                for(Box box : boxList){
                    Log.d("box_name", box.getName());

                }
            }
        }).run();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
