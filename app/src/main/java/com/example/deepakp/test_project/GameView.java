package com.example.deepakp.test_project;

import android.content.Context;
import android.view.SurfaceView;

/**
 * Created by deepakp on 12/7/2016.
 */

public class GameView extends SurfaceView implements Runnable{


    //boolean variable to track if the game is playing or not
    volatile boolean playing;

    public GameView(Context context) {
        super(context);
    }

    @Override
    public void run() {

        while (playing) {
            //to update the frame
            update();

            //to draw the frame
            draw();

            //to control
            control();
        }

    }

    private void update() {

    }

    private void draw() {

    }

    private void control() {
        //   gameThread.sleep(17);
    }

    public void pause() {
        //when the game is paused
        //setting the variable to false
        playing = false;
        //stopping the thread
        //  gameThread.join();
    }

    public void resume() {
        //when the game is resumed
        //starting the thread again
        playing = true;
     //   gameThread = new Thread(this);
      //  gameThread.start();
    }

}
