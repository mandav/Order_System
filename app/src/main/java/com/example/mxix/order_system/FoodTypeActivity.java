package com.example.mxix.order_system;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class FoodTypeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_type);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Button snacks= (Button) findViewById(R.id.snacks);
        Button mc= (Button) findViewById(R.id.mc);
        Button thali= (Button) findViewById(R.id.thali);
snacks.setOnClickListener(new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent1=new Intent(FoodTypeActivity.this,SnackActivity.class);
        startActivity(intent1);

    }
});
        mc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(FoodTypeActivity.this,MCActivity.class);
                startActivity(intent2);
            }
        });

        thali.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(FoodTypeActivity.this,ThaliActivity.class);
                startActivity(intent2);
            }
        });
                       }




    }




