package com.example.mxix.order_system;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdminViewActivity extends Activity {
    private ListView listview;
    DatabaseHelper db;
    public ArrayList<AdminOrder> adminorderlist = new ArrayList<AdminOrder>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.admin_view);
        listview = (ListView) findViewById(R.id.listView);
    }
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        adminorderlist.clear();

        db = new DatabaseHelper(getApplicationContext());
        db.getWritableDatabase();
        ArrayList<AdminOrder> adminorderlist = db.admin_list();
        listview.setAdapter(new AdminOrderAdapter(this, adminorderlist));
        db.close();

    }
    public class AdminOrderAdapter extends ArrayAdapter<AdminOrder> {
        public AdminOrderAdapter(Context context, ArrayList<AdminOrder> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            AdminOrder adminOrder = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
            }
            // Lookup view for data population
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView address = (TextView) convertView.findViewById(R.id.address);
            TextView phoneno = (TextView) convertView.findViewById(R.id.phoneno);
            TextView item = (TextView) convertView.findViewById(R.id.item);
            TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
            TextView cost = (TextView) convertView.findViewById(R.id.cost);
            // Populate the data into the template view using the data object
            name.setText(adminOrder.name);
            address.setText(adminOrder.address);
            phoneno.setText(adminOrder.phone_no);
            item.setText(adminOrder.item);
            quantity.setText(adminOrder.quantity);
            cost.setText(adminOrder.cost);
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
