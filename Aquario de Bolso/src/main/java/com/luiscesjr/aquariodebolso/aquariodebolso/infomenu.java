package com.luiscesjr.aquariodebolso.aquariodebolso;

import com.luiscesjr.aquariodebolso.aquariodebolso.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;

public class infomenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomenu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.infomenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendMessage0(View view) {

        Intent i = new Intent(infomenu.this, calendario.class);
        startActivity(i);
    }

    public void sendMessage(View view) {

        Intent i = new Intent(infomenu.this, aquadoce.class);
        startActivity(i);
    }

    public void sendMessage2(View view) {

        Intent i = new Intent(infomenu.this, aquamarinho.class);
        startActivity(i);
    }

    public void sendMessage3(View view) {

        Intent i = new Intent(infomenu.this, ferramentas.class);
        startActivity(i);
    }

    public void sendMessage4(View view) {

        Intent i = new Intent(infomenu.this, guia.class);
        startActivity(i);
    }

    public void sendMessage5(View view) {

        Intent i = new Intent(infomenu.this, conversoes.class);
        startActivity(i);
    }

    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }
}