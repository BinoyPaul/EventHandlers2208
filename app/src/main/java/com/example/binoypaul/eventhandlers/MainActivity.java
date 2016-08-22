package com.example.binoypaul.eventhandlers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    public static String TAG = "testB";
    int CountNumber = 0;

    TextView BinoTextGes;
    GestureDetectorCompat gestureCatch;
    CoordinatorLayout BinoCanvas;

///// Gesture begins
    @Override
    public boolean onDown(MotionEvent e) {
        BinoTextGes.setText("On Down");
        BinoCanvas.setBackgroundColor(Color.RED);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        BinoTextGes.setText("On Show press");
        BinoCanvas.setBackgroundColor(Color.CYAN);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        BinoTextGes.setText("On Single Tap Up ");
        BinoCanvas.setBackgroundColor(Color.MAGENTA);
        return false;
  }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        BinoTextGes.setText("on Scroll");
        BinoCanvas.setBackgroundColor(Color.GREEN);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        BinoTextGes.setText("on Long Press");
        BinoCanvas.setBackgroundColor(Color.RED);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        BinoTextGes.setText("On Fling Binoy");
      //  BinoCanvas.setBackgroundColor(Color.rgb(0,99,99));
        return false;
    }
///// Gesture ends


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureCatch.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BinoTextGes = (TextView) findViewById(R.id.BinoText);
        this.gestureCatch = new GestureDetectorCompat(this, this);
        BinoCanvas = (CoordinatorLayout) findViewById(R.id.BinoCanvas);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button BinoButton = (Button)findViewById(R.id.BinoButton);
        BinoButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView BinoText = (TextView) findViewById(R.id.BinoText);
                        BinoText.setText("Hi Bino, This is your own");
                    }

                }
        );

        BinoButton.setOnLongClickListener(
                new Button.OnLongClickListener()
                {
                    public boolean onLongClick(View v)
                    {
                        TextView BinoText = (TextView)  findViewById(R.id.BinoText);
                        BinoText.setText("This is a long click");
                        return false;
                    }
                }

        );




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
