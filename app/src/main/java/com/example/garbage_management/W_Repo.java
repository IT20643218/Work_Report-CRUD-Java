package com.example.garbage_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.garbage_management.Database.DBHandler;

public class W_Repo extends AppCompatActivity {

    EditText date,workreport1,workreport2,workreport3,workreport4;
    Button btn_workreport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_reports);

        date = findViewById(R.id.date);
        workreport1 = findViewById(R.id.workreport1);
        workreport2 = findViewById(R.id.workreport2);
        workreport3 = findViewById(R.id.workreport3);
        workreport4 = findViewById(R.id.workreport4);

        btn_workreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),Edit_Work_Report.class);
                startActivity(b);
            }
        });
        btn_workreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newRowId  = dbHandler.addwork(date.getText().toString(),workreport1.getText().toString(),workreport2.getText().toString()
                        ,workreport3.getText().toString(),workreport4.getText().toString());

                Toast.makeText(W_Repo.this, "Successfully Added , Work Date"+date, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),Edit_Work_Report.class);
                startActivity(i);
            }
        });
    }
}