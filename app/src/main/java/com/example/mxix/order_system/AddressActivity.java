package com.example.mxix.order_system;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class AddressActivity extends ActionBarActivity {
    DatabaseHelper db;
    CustomerContinued CustomerContinued;
    String address,phone_no,restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_activity_continued);
        TextView tv= (TextView) findViewById(R.id.textView8);
        tv.setText(getIntent().getExtras().getString("name"));
        final Spinner sp= (Spinner) findViewById(R.id.spinner);
        String text=sp.getSelectedItem().toString();
        final EditText et1= (EditText) findViewById(R.id.address);
        final EditText et2= (EditText) findViewById(R.id.phone_no);
        final EditText et3= (EditText) findViewById(R.id.landmark);
        final EditText et4= (EditText) findViewById(R.id.pin_code);
        Button bt= (Button) findViewById(R.id.next);

        bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DatabaseHelper(getApplicationContext());
                db.getWritableDatabase();
                CustomerContinued = new CustomerContinued();
                CustomerContinued.address=et1.getText().toString()+"-"+ et4.getText().toString()+" near "+et3.getText().toString();
                CustomerContinued.phone_no=et2.getText().toString();
                CustomerContinued.restaurant=sp.getSelectedItem().toString();
                CustomerContinued.customer_id=Utils.getLongPrefs(AddressActivity.this,"customer_id");
                Log.i("restaurant,address,phone_no", ""+ restaurant + address + " " + phone_no);
                db.addcustomer_continued(CustomerContinued);
                Toast.makeText(AddressActivity.this, "Record Added successfully.",Toast.LENGTH_LONG).show();
                finish();

            Intent intent=new Intent(AddressActivity.this,FoodTypeActivity.class);
                startActivity(intent);
            }
        });

    }



    }

