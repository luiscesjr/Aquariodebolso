package com.luiscesjr.aquariodebolso.aquariodebolso;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.luiscesjr.aquariodebolso.aquariodebolso.helper.GifDecoderView;

import java.io.IOException;
import java.io.InputStream;


public class aquamain extends Activity {

    private GestureDetector gestureDetector;private GestureDetector gesturedetector = null;

    private Intent i;

    private FrameLayout flContainer;
    private LinearLayout ivLayer1 , ivLayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquamain);

/*
        //Código para desenhar GIFs na tela, trabalho pela frente...

        InputStream stream = null;
        try {
            stream = getAssets().open("betta.gif");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        GifDecoderView view = new GifDecoderView(this, stream);
        setContentView(view);

/*
        //Código para abrir uma nova janela usando SWIPE.
        //ainda não faz exatamente o que quero...

        flContainer = (FrameLayout) findViewById(R.id.flContainer);
        ivLayer1 = (LinearLayout) findViewById(R.id.layTopUp);

        gesturedetector = new GestureDetector(new MyGestureListener());

        flContainer.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gesturedetector.onTouchEvent(event);

                return true;

            }

        });
    }



    public boolean dispatchTouchEvent(MotionEvent ev) {

        super.dispatchTouchEvent(ev);

        return gesturedetector.onTouchEvent(ev);

    }

class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_MIN_DISTANCE = 120;

    private static final int SWIPE_MAX_OFF_PATH = 100;

    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,

                           float velocityY) {

        float dX = e2.getX() - e1.getX();

        float dY = e1.getY() - e2.getY();

        if (Math.abs(dY) < SWIPE_MAX_OFF_PATH &&

                Math.abs(velocityX) >= SWIPE_THRESHOLD_VELOCITY &&

                Math.abs(dX) >= SWIPE_MIN_DISTANCE) {

            if (dX > 0) {

                Toast.makeText(getApplicationContext(), "Bem vindo!",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(aquamain.this, infomenu.class);
                startActivity(i);

            }

            return true;

        }

        return false;

    }

}

*/

    }

private static final boolean ALWAYS_SIMPLE_PREFS = false;

    public void sendMessage(View view) {

        Intent i = new Intent(aquamain.this, aquamenu.class);
        startActivity(i);
    }

    public void sendMessage2(View view) {

        Intent i = new Intent(aquamain.this, infomenu.class);
        startActivity(i);
    }

    public boolean onIsMultiPane() {
        return isXLargeTablet(this) && !isSimplePreferences(this);
    }

    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    private static boolean isSimplePreferences(Context context) {
        return ALWAYS_SIMPLE_PREFS
                || Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB
                || !isXLargeTablet(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.infomenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}