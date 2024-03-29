package com.example.a32gbfoodorderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton cwaiter;
    String val;
    //TextView counttime;

    final Random waiter = new Random();
    public int counter=120;
    private final int secs=120000;
    //public int num=1;
    private static CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cwaiter = (ToggleButton) findViewById(R.id.cwaiter);
        cwaiter.setOnClickListener(new ToggleButton_Click());
        //waiterhere = (Button) findViewById(R.id.waiterhere);


    }

    class ToggleButton_Click implements ToggleButton.OnClickListener{
        @Override
        public void onClick(View v){
            if(cwaiter.isChecked()){
                val = String.valueOf(waiter.nextInt(12) + 1);
                String t = "Waiter: " + val +" is coming";
                Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();

                startTimer(secs);

            }
            else{
                stopCountdown();
                String wait= "Waiter: " + val +" is here";
                Toast.makeText(getApplicationContext(), wait, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void viewAppetizers(View v){
        Intent i = new Intent(MainActivity.this, AppetizerList.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void viewMainCourse(View v){
        Intent i = new Intent(MainActivity.this, mainCourseList.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void viewDessert(View v){
        Intent i = new Intent(MainActivity.this, dessertList.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void viewDrink(View v){
        Intent i = new Intent(MainActivity.this, drinksList.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void viewBill(View v){
        Intent i = new Intent(MainActivity.this, BillActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void startTimer(int numofSecs)

    {

        countDownTimer= new CountDownTimer(numofSecs, 1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {


                //  Toast.makeText(getApplicationContext(),String.valueOf(counter) + "Seconds Left ", Toast.LENGTH_LONG).show();
                counter --;

                //int data=300;

                if(counter == 60)
                {
                    Toast.makeText(getApplicationContext()," Waiter would be here in 1 minute", Toast.LENGTH_LONG).show();
                }

                if(counter == 30)
                {
                    Toast.makeText(getApplicationContext()," Waiter would be here in 30 seconds", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFinish()
            {

                Toast.makeText(getApplicationContext(),"Calling Another Waiter ", Toast.LENGTH_LONG).show();
                val = String.valueOf(waiter.nextInt(100));
                //countDownTimer.start();

                startTimer(secs);

            }

        }.start();

    }

    public void stopCountdown(){
        if(countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }

    }

}


//public class MainActivity extends AppCompatActivity {
//
//    Button cwaiter,waiterhere;
//    String val;
//    //TextView counttime;
//
//    final Random waiter = new Random();
//    public int counter=180;
//    private final int secs=15000;
//    public int num=1;
//    private static CountDownTimer countDownTimer;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        final Random waiter = new Random();
//
//        cwaiter=(Button)findViewById(R.id.cwaiter);
//        //waiterhere = (Button) findViewById(R.id.waiterhere);
//
//
//    }
//    public void viewAppetizers(View v){
//        Intent i = new Intent(MainActivity.this, AppetizerList.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//    public void viewMainCourse(View v){
//        Intent i = new Intent(MainActivity.this, mainCourseList.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//    public void viewDessert(View v){
//        Intent i = new Intent(MainActivity.this, dessertList.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//
//    public void viewDrink(View v){
//        Intent i = new Intent(MainActivity.this, drinksList.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//
//    public void viewBill(View v){
//        Intent i = new Intent(MainActivity.this, BillActivity.class);
//        startActivity(i);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//
//    public void startTimer(int numofSecs)
//
//    {
//
//        countDownTimer= new CountDownTimer(numofSecs, 1000 ) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                Toast.makeText(getApplicationContext(),String.valueOf(counter) + "Seconds Left ", Toast.LENGTH_LONG).show();
//                counter--;
//            }
//
//            @Override
//            public void onFinish()
//            {
//
//                val = String.valueOf(waiter.nextInt(100));
//                //countDownTimer.start();
//                counter=180;
//                startTimer(secs);
//
//            }
//
//        }.start();
//
//    }
//
//    public void stopCountdown(){
//        if(countDownTimer != null) {
//            countDownTimer.cancel();
//            countDownTimer = null;
//        }
//
//    }
//
//    public void CallWaiter(View v)
//    {
//        val = String.valueOf(waiter.nextInt(12));
//        String t= "Waiter" + val +" is coming";
//        Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
//
//        cwaiter.setVisibility(v.INVISIBLE);
//        waiterhere.setVisibility(v.VISIBLE);
//
//        startTimer(secs);
//
//
//        waiterhere.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                stopCountdown();
//
//                // num=0;
//                String wait= "Waiter" + val +" is here";
//                Toast.makeText(getApplicationContext(), wait, Toast.LENGTH_SHORT).show();
//                //counttime.setText(wait);
//
//                cwaiter.setVisibility(v.VISIBLE);
//                waiterhere.setVisibility(v.INVISIBLE);
//
//            }
//        });
//
//    }
//
//}


