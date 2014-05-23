package com.luiscesjr.aquariodebolso.aquariodebolso;

import com.luiscesjr.aquariodebolso.aquariodebolso.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class aquamain extends Activity {

        public void sendMessage(View view) {

            Intent i = new Intent(aquamain.this, aquamenu.class);
            startActivity(i);
        }

        public void sendMessage2(View view) {

        Intent i = new Intent(aquamain.this, infomenu.class);
        startActivity(i);
    }

    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

        private static final boolean AUTO_HIDE = true;

        private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

        private static final boolean TOGGLE_ON_CLICK = true;

        private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

        private SystemUiHider mSystemUiHider;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_aquamain);

            final View controlsView = findViewById(R.id.fullscreen_content_controls);
            final View contentView = findViewById(R.id.fullscreen_content);
            mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
            mSystemUiHider.setup();
            mSystemUiHider
                    .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {

                        int mControlsHeight;
                        int mShortAnimTime;

                        @Override
                        @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
                        public void onVisibilityChange(boolean visible) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                                if (mControlsHeight == 0) {
                                    mControlsHeight = controlsView.getHeight();
                                }
                                if (mShortAnimTime == 0) {
                                    mShortAnimTime = getResources().getInteger(
                                            android.R.integer.config_shortAnimTime);
                                }
                                controlsView.animate()
                                        .translationY(visible ? 0 : mControlsHeight)
                                        .setDuration(mShortAnimTime);
                            } else {
                                controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                            }

                            if (visible) {

                                delayedHide(AUTO_HIDE_DELAY_MILLIS);
                            }
                        }
                    });
            contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TOGGLE_ON_CLICK) {
                        mSystemUiHider.toggle();
                    } else {
                        mSystemUiHider.show();
                    }
                }
            });

            findViewById(R.id.aqua_button).setOnTouchListener(mDelayHideTouchListener);
        }

        @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);

            delayedHide(100);
        }

        View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AUTO_HIDE) {
                    delayedHide(AUTO_HIDE_DELAY_MILLIS);
                }
                return false;
            }
        };

        Handler mHideHandler = new Handler();
        Runnable mHideRunnable = new Runnable() {
            @Override
            public void run() {
                mSystemUiHider.hide();
            }
        };

        private void delayedHide(int delayMillis) {
            mHideHandler.removeCallbacks(mHideRunnable);
            mHideHandler.postDelayed(mHideRunnable, delayMillis);
        }
    }