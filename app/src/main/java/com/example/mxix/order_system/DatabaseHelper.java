package com.example.mxix.order_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASENAME = "order_system";  // our database Name

    public static String customer = "Customer";                    //table name
    public static String customer_continued = "customeraddress"; //TABLE NAME
    public static String order = "finalorder";//order table
    private ArrayList<AdminOrder> cartList = new ArrayList<AdminOrder>();
    Context c;


    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, 33);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE if not exists customeraddress(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"restaurant"
                +" TEXT,"
                + "address"
                + " TEXT,"
                + "phone_no"
                + " TEXT,"
        +"customer_id"+" INTEGER)");
        db.execSQL("CREATE TABLE if not exists Customer(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name"
                + " TEXT,"
                + "phone_no"
                + " TEXT,"
                + "email" + " TEXT)");
        db.execSQL("CREATE TABLE if not exists finalorder(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "item"
                + " TEXT,"
                + "quantity"
                + " TEXT,"
                + "cost" + " TEXT,"+"customer_id"+" INTEGER)");
            }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + customer);
        db.execSQL("DROP TABLE IF EXISTS" + customer_continued);
        db.execSQL("DROP TABLE IF EXISTS" + order);
        onCreate(db);
    }

    //Add record
    public long addProduct(Customer Customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", Customer.name);
        contentValues.put("PHONE_NO", Customer.phone_no);
        contentValues.put("EMAIL", Customer.email);
        return db.insert("Customer", null, contentValues);
    }

    public void addcustomer_continued(CustomerContinued CustomerContinued) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("restaurant", CustomerContinued.restaurant);
        contentValues.put("address", CustomerContinued.address);
        contentValues.put("phone_no", CustomerContinued.phone_no);
        contentValues.put("customer_id", CustomerContinued.customer_id);
        db.insert("customeraddress", null, contentValues);
        db.close();
    }

    public void addfinal_order(FinalOrder order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item",order.item);
        contentValues.put("quantity", order.quantity);
        contentValues.put("cost", order.cost);
        contentValues.put("customer_id", order.customer_id);
        db.insert("finalorder", null, contentValues);
        db.close();
    }

    // get all products from database
    public ArrayList<AdminOrder> admin_list() {

        cartList.clear();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Customer,customeraddress,finalorder"+" WHERE Customer.id = customeraddress.customer_id AND Customer.id=finalorder.customer_id "+"GROUP by Customer.name", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    AdminOrder item = new AdminOrder();

                    item.idno = cursor.getString(cursor
                            .getColumnIndex("id"));

                    item.name = cursor.getString(cursor
                            .getColumnIndex("name"));

                    item.address = cursor.getString(cursor
                            .getColumnIndex("address"));
                    item.phone_no = cursor.getString(cursor
                            .getColumnIndex("phone_no"));

                    item.item = cursor.getString(cursor
                            .getColumnIndex("item"));

                    item.quantity = cursor.getString(cursor
                            .getColumnIndex("quantity"));

                    item.cost = cursor.getString(cursor
                            .getColumnIndex("cost"));

                    cartList.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return cartList;
    }}
//
//
//    public ArrayList<ProductModel> getProudcts(String record) {
//
//        cartList.clear();
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.query(true, "producttable", new String[] {
//                "productidno", "productname", "productprice" }, "productname"
//                + "=?", new String[] { record }, null, null, null, null);
//
//        if (cursor.getCount() != 0) {
//            if (cursor.moveToFirst()) {
//                do {
//                    ProductModel item = new ProductModel();
//
//                    item.idno = cursor.getString(cursor
//                            .getColumnIndex("productidno"));
//
//                    item.productname = cursor.getString(cursor
//                            .getColumnIndex("productname"));
//
//                    item.productprice = cursor.getString(cursor
//                            .getColumnIndex("productprice"));
//
//                    cartList.add(item);
//
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        db.close();
//        return cartList;
//    }
//}
