package com.example.androidtest;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        
        final ImageView img = (ImageView) findViewById(R.id.imageView1);

        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Drawable drawable = getResources().getDrawable(R.drawable.budapest);
				printf("draw: %s x %s", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
				printf("img: %s x %s", img.getWidth(), img.getHeight());

				drawable.setLevel(10000);
				drawable.setBounds(0, 0, 50, 50);
				img.setImageDrawable(drawable);

//				ClipDrawable clip = new ClipDrawable(drawable, Gravity.TOP, ClipDrawable.HORIZONTAL);
//				Rect bounds = new Rect(0, 0, 20, 20);
//				clip.setBounds(bounds);
//				clip.setLevel(10000);// max is 10000
//				img.setVisibility(View.VISIBLE);
//				img.setImageDrawable(clip);

				img.refreshDrawableState();
				img.invalidate();
			}
		});

        button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Drawable drawable = getResources().getDrawable(R.drawable.budapest);

				ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main);
		        MySurafaceView surfaceView = new MySurafaceView(MainActivity.this);
		        surfaceView.setWillNotDraw(false);
		        printf("MySurafaceView: %s", surfaceView.getClass().getCanonicalName());
		        surfaceView.setDrawable(drawable);
		        surfaceView.setVisibility(View.VISIBLE);
		        viewGroup.addView(surfaceView, 10, 10);
			}
		});

        MySurafaceView surfaceView = (MySurafaceView) findViewById(R.id.surface);
		Drawable drawable = getResources().getDrawable(R.drawable.budapest);
        surfaceView.setWillNotDraw(false);
        surfaceView.setDrawable(drawable);
//        surfaceView.refreshDrawableState();
//        surfaceView.invalidateDrawable(drawable);
//        surfaceView.invalidate();

        button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Drawable drawable = getResources().getDrawable(R.drawable.budapest);

				printf("Use existin surface");
		        MySurafaceView surfaceView = (MySurafaceView) findViewById(R.id.surface);
//		        surfaceView.setWillNotDraw(false);
		        surfaceView.setDrawable(drawable);
//		        surfaceView.refreshDrawableState();
//		        surfaceView.invalidateDrawable(drawable);
//		        surfaceView.invalidate();
			}
		});

    }

    static void printf(String format, Object...args) {
    	String message = String.format(format, args);
    	Log.d("test", message);
    }
}
