package com.example.kasomu.materialdesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by kasomu on 8/27/2015.
 */
public class Splashh extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        final ImageView iv = (ImageView)findViewById(R.id.splash_imageid);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.animation_splash);
        final Animation a = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("Animation","At the animation end");
                iv.startAnimation(a);
                finish();
                Intent in = new Intent(getBaseContext(),MainActivity.class);
                startActivity(in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
