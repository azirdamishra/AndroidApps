package com.example.bussinessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //define attributes for the buttons
    private EditText editTextStockName;
    private EditText editTextStockQuantity;
    private TextView textViewDisplayOutput;

    private myDBHandle dbHandle;
    private SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStockName = findViewById(R.id.editTextStockName);
        editTextStockQuantity = findViewById(R.id.editTextStockQuantity);

        textViewDisplayOutput = findViewById(R.id.textViewDisplayOutput);

        dbHandle = new myDBHandle(this, "FirstDatabase", null, 1);
        //using the above handle I can derive my database
        myDatabase = dbHandle.getWritableDatabase();
        //this DB gets created on the local android only and no server so it is pretty secure

        //should have created a separate table but keeping it here for now
        try{
            String createStringTable = "CREATE TABLE firstTable(StockName TEXT, Quantity INTEGER)";
            myDatabase.execSQL(createStringTable);
        }catch (Exception e){
            e.printStackTrace();
            //this exception is thrown if the table is already created
        }
    }

    public void writeButton(View view){
        ContentValues contentValues = new ContentValues();

        contentValues.put("StockName", editTextStockName.getText().toString());
        contentValues.put("Quantity", Integer.parseInt(editTextStockQuantity.getText().toString()));
        myDatabase.insert("firstTable", null, contentValues);
    }

    public void readButton(View view){
        String query = "Select * FROM firstTable WHERE StockName + '" + editTextStockName.getText().toString() + "'";

        Cursor cursor = myDatabase.rawQuery(query, null);
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            textViewDisplayOutput.setText(cursor.getString(0) + "   -->   " + cursor.getString(1));
        }else { //is used when there is no data found for my cursor
            textViewDisplayOutput.setText("Data Not Found");
        }
    }

}