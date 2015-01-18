package com.example.mxix.order_system;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    DatabaseHelper db;
    Customer Customer;
    String name,email,phone_no;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final EditText et = (EditText) findViewById(R.id.phone_number);
        final EditText et2 = (EditText) findViewById(R.id.name);
        final EditText et3 = (EditText) findViewById(R.id.email);
        Button b = (Button) findViewById(R.id.register);
        Button c = (Button) findViewById(R.id.admin);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DatabaseHelper(getApplicationContext());
                db.getWritableDatabase();
                Customer = new Customer();

                Intent intent1;
                intent1 = new Intent(MainActivity.this, AddressActivity.class);
                intent1.putExtra("phone_no", et.getText().toString());
                intent1.putExtra("name", et2.getText().toString());
                intent1.putExtra("email", et3.getText().toString());
                Customer.name=et2.getText().toString();
                Customer.phone_no=et.getText().toString();
                Customer.email=et3.getText().toString();
                Log.i("name,email,phone_no", "" +name + ""+ email + "" + phone_no);
                long id = db.addProduct(Customer);
                Utils.setLongPrefs(MainActivity.this,"customer_id",id);
                Toast.makeText(MainActivity.this, "Record Added successfully.",Toast.LENGTH_LONG).show();
                finish();

                intent1.putExtra("customer_id", id);
                startActivity(intent1);
            }
        });

        c.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent2);
            }
        });


    }
    }

