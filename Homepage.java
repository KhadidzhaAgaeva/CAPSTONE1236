package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    private Button Diary1;
    private  TextView signou ;
    Button btnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Diary1 = (Button)findViewById(R.id.diary);

        Button button2 = (Button)findViewById(R.id.peak);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, PulseOximeter.class);
                startActivity(intent);
            }
        });

        Button btnn = (Button) findViewById(R.id.notifications);


        TextView txtxt = (TextView)findViewById(R.id.nottxt) ;

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtxt.setText(" No Notifications.");

            }
        });
        Button button1 = (Button)findViewById(R.id.call);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Emergency.class);
                startActivity(intent);
            }
        });
        Button button = (Button)findViewById(R.id.settings);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Setting.class);
                startActivity(intent);
            }
        });

        Diary1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,Diary.class);
                startActivity(intent);
            }
        });

        signou = (TextView)findViewById(R.id.signout);

        signou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Login.class);
                startActivity(intent);
            }
        });


        btnChart=(Button)findViewById(R.id.btnChart);
        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Chart.class);
                startActivity(intent);
            }
        });

    }
}