package com.example.mxix.order_system;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AdminActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_pass);
        final EditText et1= (EditText) findViewById(R.id.pass);

        Button d= (Button) findViewById(R.id.validate);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=et1.getText().toString();
                if(pass.equals("mandav"))
            {
                Intent intent3;
                intent3 = new Intent(AdminActivity.this,AdminViewActivity.class);
                startActivity(intent3);
            }
                else
                {
                    Toast toast;
                    int i=Toast.LENGTH_LONG;
                    i=5000;
                    toast = Toast.makeText(AdminActivity.this, "Wrong Password",i);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();


                }

            }
        });

    }



}
