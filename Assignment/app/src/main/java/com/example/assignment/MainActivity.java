package com.example.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editID,editRecipe,editStyle,editAverageCreationTime;
    Button btnAddData;
    Button btnViewALL;
    Button btnUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editID = (EditText)findViewById(R.id.editText_ID);
        editRecipe = (EditText)findViewById(R.id.editText_Recipe);
        editStyle = (EditText)findViewById(R.id.editText_Style);
        editAverageCreationTime = (EditText)findViewById(R.id.editText_Average);
        btnAddData = (Button)findViewById(R.id.buttonAdd);
        btnViewALL = (Button)findViewById(R.id.buttonView);
        btnUpdate = (Button)findViewById(R.id.buttonUpd);
        btnDelete = (Button)findViewById(R.id.buttonDlt);
        AddData();
        ViewALL();
        Update();
        Delete();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted =  myDB.insertData(editRecipe.getText().toString(),
                                editStyle.getText().toString(),
                                editAverageCreationTime.getText().toString());

                        if( isInserted ==true)
                                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();

                    }
                }

                );
    }

    public void ViewALL()
    {
        btnViewALL.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result = myDB.showAllData();
                        if(result.getCount() == 0)
                        {
                            //show meessage
                            showMessage("Error","No data");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext())
                        {
                            buffer.append("ID : " + result.getString(0)+"\n");
                            buffer.append("Recipe : " + result.getString(1)+"\n");
                            buffer.append("Style : " + result.getString(2)+"\n");
                            buffer.append("AverageCreationTime : " + result.getString(3)+"\n");
                        }
                        //show all
                        showMessage("All recipes",buffer.toString());
                    }
                }



        );
    }

    public void Update()
    {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean Update = myDB.updateData(editID.getText().toString(),editRecipe.getText().toString(),editStyle.getText().toString(),editAverageCreationTime.getText().toString());

                        if (Update == true)
                        {
                            Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );
    }

    public void Delete(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int deletedRows = myDB.delete(editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }


        );

    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
