package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editRecipe,editStyle,editAverageCreationTime;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editRecipe = (EditText)findViewById(R.id.editText_Recipe);
        editStyle = (EditText)findViewById(R.id.editText_Style);
        editAverageCreationTime = (EditText)findViewById(R.id.editText_Average);
        btnAddData = (Button)findViewById(R.id.buttonAdd);
        AddData();

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
}
