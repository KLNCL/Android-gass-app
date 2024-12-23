package com.example.gas.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gas.Database.DataBaseHelper2;
import com.example.gas.R;

public class order extends AppCompatActivity {
    DataBaseHelper2 orderDb;
    EditText editName,editAddress,editGas,editNumber,editID,editStore;
    Button AddOrder,Vieworder,Updateorder,Deleteorder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // home button
        ImageButton homeButton=findViewById(R.id.home_btn);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order.this,home.class);
                startActivity(intent);
            }
        });

        orderDb= new DataBaseHelper2(this);

        editID = findViewById(R.id.inputid);
        editName = findViewById(R.id.inputname);
        editAddress= findViewById(R.id.inputaddress);
        editGas = findViewById(R.id.inputgas);
        editNumber = findViewById(R.id.inputnumber);
        editStore = findViewById(R.id.inputstore);
        AddOrder = findViewById(R.id.order_btn);
        Vieworder=findViewById(R.id.view_btn2);
        Updateorder = findViewById(R.id.update_btn);
        Deleteorder = findViewById(R.id.delete_btn);



        addData();
        viewdata();
        updateData();
        deleteData();

    }
    //add data
    public void addData(){
        AddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = orderDb.insertData(editName.getText().toString(),
                        editAddress.getText().toString(),editGas.getText().toString(),
                        editNumber.getText().toString(),editStore.getText().toString());
            if (isInserted == false)
                Toast.makeText(order.this, "All fields are mandatory",
                        Toast.LENGTH_SHORT).show();
            if (isInserted == true)
                Toast.makeText(order.this, "Order Successfuly",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(order.this, "Order Not Successfuly",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    //view data
    public void viewdata(){
        Vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor results = orderDb.getAllData();
                if (results.getCount()==0){
                    showMessage("Error message :","No data available in the Database");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (results.moveToNext()){
                    buffer.append("ID :"+results.getString(0)+"\n");
                    buffer.append("NAME :"+results.getString(1)+"\n");
                    buffer.append("ADDRESS :"+results.getString(2)+"\n");
                    buffer.append("GAS :"+results.getString(3)+"\n");
                    buffer.append("NUMBER :"+results.getString(4)+"\n");
                    buffer.append("STORE :"+results.getString(5)+"\n");

                    showMessage("List of Data",buffer.toString());
                }

            }
        });
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    //update data
    public void updateData(){
        Updateorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = orderDb.updateData(editID.getText().toString(),editName.getText().toString(),
                        editAddress.getText().toString(),editGas.getText().toString(),editNumber.getText().toString(),
                        editStore.getText().toString());
                if (isUpdate == true)
                    Toast.makeText(order.this,"Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(order.this,"Data not Update", Toast.LENGTH_LONG).show();
            }
        });

    }

    //Delete data
    public void deleteData(){
        Deleteorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedatarows = orderDb.deleteData(editID.getText().toString());
                if ((deletedatarows>0))
                    Toast.makeText(order.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(order.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });

    }

}