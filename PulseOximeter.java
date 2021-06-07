package com.example.capstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class PulseOximeter extends AppCompatActivity {

    int outp;
    TextView OxiSattxxt;
    TextView condtxt;
    EditText txtenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse_oximeter);


        OxiSattxxt = (TextView)findViewById(R.id.OxiSattxxt);
       condtxt = (TextView)findViewById(R.id.conttxt);
       txtenter= (EditText)findViewById(R.id.txtenter);



        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                outp=Integer.valueOf(txtenter.getText().toString());

                OxiSattxxt.setText(" " +outp+ " %");

                if (outp <92){
                    condtxt.setText(" CRITICAL");

                }else if (outp > 92 && outp < 94){
                    condtxt.setText("Click to Enter Peak Flow Results");
                    condtxt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(PulseOximeter.this, PeakFlow.class);
                            startActivity(intent);
                        }
                    });
                }else {
                    condtxt.setText("GOOD");

                }
            }
        });

        Button button = (Button)findViewById(R.id.settbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PulseOximeter.this , Setting.class);
                startActivity(intent);
            }
        });



    }


}
