package com.example.ekasi.reportcardapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ekasi.reportcardapp.DatabaseHelper;

public class Details extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editID;
    Button btnAddData;
    Button btnViewAll;
    Button btnviewUpdate;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editName);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editMarks = (EditText) findViewById(R.id.editMarks);
        editID =(EditText)findViewById(R.id.editID);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnViewAll = (Button) findViewById(R.id.button_viewall);
        btnviewUpdate = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);
        AddData();
        viewall();
        UpdateData();
        DeleteData();

    }


    public  void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editID.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        ;
                    }
                }
        );

    }

    public void  UpdateData(){
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.upgdateData(editID.getText().toString(),editName.getText().toString(),
                                editSurname.getText().toString(),editMarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this,"Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this, "Data not Updated", Toast.LENGTH_LONG).show();;


                    }
                }
        );
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this,"Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(com.example.ekasi.reportcardapp.Details.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewall(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
                }
        );
    }

    public  void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}


