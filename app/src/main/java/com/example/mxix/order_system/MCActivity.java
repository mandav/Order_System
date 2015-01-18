package com.example.mxix.order_system;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MCActivity extends ActionBarActivity {
    DatabaseHelper db;
    FinalOrder order;
    Integer fr_cost,sp_cost,cc_cost,dosa_cost,cm_cost,mt_cost,mm_cost,roti_cost,total=0;
    String fr,sp,cc,dosa,cm,mt,mm,roti,total_cost,items="",quantity="";

    public static boolean isBlankOrNull(String str) {
        return (str == null || "".equals(str.trim()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList<String> arrayList2 = new ArrayList<String>();
        final ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList.clear();
        arrayList2.clear();
        arrayList3.clear();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_menu);
        final EditText et1= (EditText) findViewById(R.id.fr_quantity);
        final EditText et2= (EditText) findViewById(R.id.sp_quantity);
        final EditText et3= (EditText) findViewById(R.id.cc_quantity);
        final EditText et4= (EditText) findViewById(R.id.dosa_quantity);
        final EditText et5= (EditText) findViewById(R.id.cm_quantity);
        final EditText et6= (EditText) findViewById(R.id.mt_quantity);
        final EditText et7= (EditText) findViewById(R.id.mm_quantity);
        final EditText et8= (EditText) findViewById(R.id.roti_quantity);
        final TextView tv1= (TextView) findViewById(R.id.cost_fr);
        final TextView tv2= (TextView) findViewById(R.id.cost_sp);
        final TextView tv3= (TextView) findViewById(R.id.cost_cc);
        final TextView tv4= (TextView) findViewById(R.id.cost_dosa);
        final TextView tv5= (TextView) findViewById(R.id.cost_cm);
        final TextView tv6= (TextView) findViewById(R.id.cost_mt);
        final TextView tv7= (TextView) findViewById(R.id.cost_mm);
        final TextView tv8= (TextView) findViewById(R.id.cost_roti);
        final TextView tv9= (TextView) findViewById(R.id.total);
        Button bt=(Button) findViewById(R.id.confirm_mc);
        Button bt1= (Button) findViewById(R.id.total_value);
        bt1.setOnClickListener(new Button.OnClickListener() { //total
            @Override
            public void onClick(View v) {
                if(!isBlankOrNull(et1.getText().toString()))
                 {
                fr_cost=Integer.parseInt(et1.getText().toString())*75;
                total=fr_cost+total;
                fr=fr_cost.toString();
                tv1.setText(fr);
                 }
                if(!isBlankOrNull(et2.getText().toString()))
                {
                    sp_cost=Integer.parseInt(et2.getText().toString())*150;
                    sp=sp_cost.toString();
                    total=sp_cost+total;
                    tv2.setText(sp);
                }
                if(!isBlankOrNull(et3.getText().toString()))
                {
                    cc_cost=Integer.parseInt(et3.getText().toString())*200;
                    total=cc_cost+total;
                    cc=cc_cost.toString();
                    tv3.setText(cc);
                }
                if(!isBlankOrNull(et4.getText().toString()))
                {
                    dosa_cost=Integer.parseInt(et4.getText().toString())*80;
                    total=dosa_cost+total;
                    dosa=dosa_cost.toString();
                    tv4.setText(dosa);
                }
                if(!isBlankOrNull(et5.getText().toString()))
                {
                    cm_cost=Integer.parseInt(et5.getText().toString())*170;
                    cm=cm_cost.toString();
                    total=cm_cost+total;
                    tv5.setText(cm);
                }
                if(!isBlankOrNull(et6.getText().toString()))
                {
                    mt_cost=Integer.parseInt(et6.getText().toString())*200;
                    mt=mt_cost.toString();
                    total=mt_cost+total;
                    tv6.setText(mt);
                }
                if(!isBlankOrNull(et7.getText().toString()))
                {
                    mm_cost=Integer.parseInt(et7.getText().toString())*50;
                    mm=mm_cost.toString();
                    total=mm_cost+total;
                    tv7.setText(mm);
                }
                if(!isBlankOrNull(et8.getText().toString()))
                {
                    roti_cost=Integer.parseInt(et8.getText().toString())*8;
                    roti=roti_cost.toString();
                    total=roti_cost+total;
                    tv8.setText(roti);
                }
                total_cost=total.toString();
                tv9.setText(total_cost);
                total=0;
              }
        });
        bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrayList.clear();
                //arrayList2.clear();
                //arrayList3.clear();
                db = new DatabaseHelper(getApplicationContext());
                db.getWritableDatabase();
                order = new FinalOrder();
                Intent intent1=new Intent(MCActivity.this,MainActivity.class);
                if(!isBlankOrNull(et1.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.fr_d) + ",");
                    quantity=quantity.concat(et1.getText().toString()+",");
                    arrayList2.add("1");


                }
                if(!isBlankOrNull(et2.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.sp_d)+",");
                    quantity=quantity.concat(et2.getText().toString()+",");
                    arrayList.add(et2.getText().toString());
                    arrayList2.add("2");


                }
                if(!isBlankOrNull(et3.getText().toString()))
                {
                    items=items.concat(getResources().getString(R.string.cc_d)+",");
                    quantity=quantity.concat(et3.getText().toString()+",");
                    arrayList2.add("3");
                }
                if(!isBlankOrNull(et4.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.d_d)+",");
                    quantity=quantity.concat(et4.getText().toString()+",");
                    arrayList2.add("4");

                }
                if(!isBlankOrNull(et5.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.cm_d)+",");
                    quantity=quantity.concat(et5.getText().toString()+",");
                    arrayList2.add("5");


                }
                if(!isBlankOrNull(et6.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.mt_d)+",");
                    quantity=quantity.concat(et6.getText().toString()+",");
                    arrayList2.add("6");


                }
                if(!isBlankOrNull(et7.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.mm_d)+",");
                    quantity=quantity.concat(et7.getText().toString()+",");
                    arrayList2.add("7");


                }
                if(!isBlankOrNull(et8.getText().toString()))
                {   items=items.concat(getResources().getString(R.string.roti_d)+",");
                    quantity=quantity.concat(et8.getText().toString()+",");
                    arrayList2.add("8");
                }
                order.quantity=quantity;
                order.item=items;
                order.cost=total_cost;
                order.customer_id=Utils.getLongPrefs(MCActivity.this,"customer_id");
                Log.i("quantity,items,total cost", "" + quantity + ":" + items + ":" + total_cost);
                db.addfinal_order(order);
                Toast.makeText(MCActivity.this, "Order Inserted", Toast.LENGTH_LONG).show();
                finish();
//              startActivity(intent1);
            }
        });


    }



}
