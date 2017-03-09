package com.example.deepakp.test_project.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.deepakp.test_project.R;
import com.example.deepakp.test_project.activities.GameActivity;

/**
 * Created by deepakp on 12/7/2016.
 */

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener
{

    //image button
    private ImageButton buttonPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);

        //adding a click listener
        buttonPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //starting game activity
        startActivity(new Intent(this, GameActivity.class));
    }
}
