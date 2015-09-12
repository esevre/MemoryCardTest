package com.eriksevre.esevre.memorycardtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    int numClicks;
    int[] clickHistory;

    /*
        Because we are often changing images, I will keep the image objects in memory
     */
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;

    /*
        Four methods to keep track of which buttons are clicked
        Click 1: Flip first card
        Click 2: Flip second card
        Click 3: Reset cards (later you might want to use a timer for this)
     */

    public void globalClick(View v){
        if (v.getId() == iv1.getId()){
            buttonOneClicked(v);
        } else if (v.getId() == R.id.imageView2) {
            buttonTwoClicked(v);
        } else if(v.getId() == R.id.imageView3) {
            buttonThreeClicked(v);
        } else if (v.getId() == R.id.imageView4) {
            buttonFourClicked(v);
        }

        // This is used for testing which images are displayed
        //
        //  I'm keeping this here as a record of my debug process
        TextView tv = (TextView) findViewById(R.id.textView);
        String displayMe = "(" + clickHistory[0] + ", " + clickHistory[1] + ")";
        tv.setText(displayMe);

    }

    public void buttonOneClicked(View v){

        String currentTag = (String) iv1.getTag();
        int myResource = R.drawable.front_cup;

        if (numClicks == 0) {
            iv1.setImageResource(myResource);
            iv1.setTag("front");
            clickHistory[0] = myResource;
            numClicks++;
        } else if (numClicks == 1 & currentTag.equals("back")) {
            iv1.setImageResource(myResource);
            iv1.setTag("front");
            clickHistory[1] = myResource;
            numClicks++;
        } else if (numClicks == 2) {
            resetCards();
            numClicks = 0;
        } else {
            // this should never happen
            resetCards();
        }
    }

    public void buttonTwoClicked(View v){

        String currentTag = (String) iv2.getTag();
        int myResource = R.drawable.front_cup;

        if (numClicks == 0) {
            iv2.setImageResource(myResource);
            iv2.setTag("front");
            clickHistory[0] = myResource;
            numClicks++;
        } else if (numClicks == 1 & currentTag.equals("back")) {
            iv2.setImageResource(myResource);
            iv2.setTag("front");
            clickHistory[1] = myResource;
            numClicks++;
        } else if (numClicks == 2) {
            resetCards();
            numClicks = 0;
        } else {
            // this should never happen
            resetCards();
        }
    }

    public void buttonThreeClicked(View view) {


        String currentTag = (String) iv3.getTag();
        int myResource = R.drawable.front_tree;

        if (numClicks == 0) {
            iv3.setImageResource(myResource);
            iv3.setTag("front");
            clickHistory[0] = myResource;
            numClicks++;
        } else if (numClicks == 1 & currentTag.equals("back")) {
            iv3.setImageResource(myResource);
            iv3.setTag("front");
            clickHistory[1] = myResource;
            numClicks++;
        } else if (numClicks == 2) {
            resetCards();
            numClicks = 0;
        } else {
            // this should never happen
            resetCards();
        }
    }

    public void buttonFourClicked(View view) {

        String currentTag = (String) iv4.getTag();
        int myResource = R.drawable.front_tree;

        if (numClicks == 0) {
            iv4.setImageResource(myResource);
            iv4.setTag("front");
            clickHistory[0] = myResource;
            numClicks++;
        } else if (numClicks == 1 & currentTag.equals("back")) {
            iv4.setImageResource(myResource);
            iv4.setTag("front");
            clickHistory[1] = myResource;
            numClicks++;
        } else if (numClicks == 2) {
            resetCards();
            numClicks = 0;
        } else {
            // this should never happen
            resetCards();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // Set the initial images to be the card back
        //
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);

        resetCards();
    }

    public void resetCards(){
        // set numclicks to 0, at start of game there are no clicks
        numClicks = 0;

        // set the choices to
        clickHistory = new int[2];
        for (int i = 0; i < 2; i++){
            clickHistory[i] = 0;
        }

        iv1.setImageResource(R.drawable.cardback);
        iv2.setImageResource(R.drawable.cardback);
        iv3.setImageResource(R.drawable.cardback);
        iv4.setImageResource(R.drawable.cardback);

        // I'm going to use a "tag" to keep track of the current image displayed
        // Front means front of card, back means back image displayed
        iv1.setTag("back");
        iv2.setTag("back");
        iv3.setTag("back");
        iv4.setTag("back");
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
