package com.example.ekasi.reportcardapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewAll extends AppCompatActivity {
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        myDb = new DatabaseHelper(this);

                        Cursor res = myDb.getAllData();
                        if(res.getCount()== 0){
                            //show message
                            showMessage ("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            System.out.println(("The id is ___ "+ res.getString(0)));
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            System.out.println(("The name is ___ "+ res.getString(1)));
                            buffer.append("Surname :"+ res.getString(2)+"\n");
                            System.out.println(("The surname is ___ "+ res.getString(2)));
                            System.out.println(("The marks are ___ "+ res.getString(3)));
                            buffer.append("Marks :"+ res.getString(3)+"\n\n\n");
                        }

                        // show all data
                        showMessage ("Data",buffer.toString());



    }
    public  void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
