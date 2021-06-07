package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class Diary extends AppCompatActivity implements DatePickerDialog.OnDateSetListener ,AdapterView.OnItemSelectedListener {

    Button show;
    Button date;
    Button set;
    TextView datetext;
    Spinner spinnerSym;
    Spinner spinnertrig;
    Spinner spinnerMed;
    Member member;
    String items;
    String itemt;
    String itemm;
    DatabaseReference databaseReference;
    String[ ] Symptoms={"Symptoms","Cough","Chest Tightness","Shortness of breath","Wheeze"};
    String[ ] Triggers= {"Triggers","Dust Mites","Medicines","Pollution","Pollen","Wheeze"};
    String[ ] Medication={"Medication",  "CFC","Flutikazon","Budesonid","Siklezonid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        FirebaseDatabase database= FirebaseDatabase.getInstance();
        databaseReference =database.getReference("value");
        member=new Member();

       spinnerSym = (Spinner)findViewById(R.id.spinnerSym);
       spinnertrig = (Spinner)findViewById(R.id.spinnertrig);
       spinnerMed = (Spinner)findViewById(R.id.spinnerMed) ;

        
        spinnerSym.setOnItemSelectedListener(this);
        spinnertrig.setOnItemSelectedListener( this);
        spinnerMed.setOnItemSelectedListener(this);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(Diary.this, android.R.layout.simple_spinner_dropdown_item, Symptoms);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSym.setAdapter(myadapter);

        ArrayAdapter<String> myadapter1 = new ArrayAdapter<String>(Diary.this, android.R.layout.simple_spinner_dropdown_item,Triggers );
        myadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertrig.setAdapter(myadapter1);

        ArrayAdapter<String> myadapter2 = new ArrayAdapter<String>(Diary.this, android.R.layout.simple_spinner_dropdown_item, Medication);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMed.setAdapter(myadapter2);

        date = (Button)findViewById(R.id.date);
        set = (Button)findViewById(R.id.set);
        show =  (Button)findViewById(R.id.show);




        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SaveValue(items,itemt,itemm);
                Intent intent = new Intent(Diary.this, DiaryMain.class);
                startActivity(intent);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diary.this, Setting.class);
                startActivity(intent);
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH ,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getInstance().format(c.getTime());

        datetext = (TextView)findViewById(R.id.datetxt);
        datetext.setText(currentDateString);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        items=spinnerSym.getSelectedItem().toString();
        itemt=spinnertrig.getSelectedItem().toString();
        itemm=spinnerMed.getSelectedItem().toString();
        


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void SaveValue(String items,String itemt,String itemm){
        member.setSymptoms(items);
        member.setTriggers(itemt);
        member.setMed(itemm);
        String id=databaseReference.push().getKey();
        databaseReference.child(id).setValue(member);

    }

}