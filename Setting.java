package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView name = (TextView)findViewById(R.id.fulnametxt);
        TextView mail = (TextView)findViewById(R.id.emailtxt);
        TextView phon = (TextView)findViewById(R.id.phonetxt);

        TextView ades = (TextView)findViewById(R.id.loctxt) ;


        String username = getIntent().getStringExtra("keyuseN");
        String usermail = getIntent().getStringExtra("keyuseE");
        String userphonn = getIntent().getStringExtra("keyuseP");
        String userades = getIntent().getStringExtra("keyuseA");

        name.setText(username);
        mail.setText(usermail);
        phon.setText(userphonn);
        ades.setText(userades);



        Button button = (Button) findViewById(R.id.save);
        Button button1 = (Button)findViewById(R.id.plas);

button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Setting.this, Changes.class);
        startActivity(intent);
    }
});
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Homepage.class);
                startActivity(intent);
            }
        });


    }
}