package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Changes extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.capstone.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changes);

        EditText usernam = (EditText)findViewById(R.id.editname) ;
        EditText adres = (EditText)findViewById(R.id.loc);
        EditText emal = (EditText)findViewById(R.id.emailedt);
        EditText phone = (EditText)findViewById(R.id.phonedt);



        Button button = (Button)findViewById(R.id.saveChn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UserName = usernam.getText().toString();
                String UserAdres = adres.getText().toString();
                String UserEmail = emal.getText().toString();
                String UserContact = phone.getText().toString();


                Intent intent = new Intent(Changes.this, Setting.class);
                intent.putExtra("keyuseN",UserName);
                intent.putExtra("keyuseA",UserAdres);
                intent.putExtra("keyuseE",UserEmail);
                intent.putExtra("keyuseP",UserContact);

                startActivity(intent);
            }
        });
    }


}