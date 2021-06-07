package com.example.capstone;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText name ;
    private  EditText pass;
    private Button log;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView lout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.inName);
        pass = (EditText)findViewById(R.id.inPass);

        log = (Button)findViewById(R.id.logbtn);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString() , pass.getText().toString());

            }
        });

        lout = (TextView)findViewById(R.id.logggtxt);
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private  void validate (String userName, String password){


        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, Homepage.class));
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Login Failed",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Login.class));
                }
            }
        });
    }
}