package com.example.capstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {




    private  EditText EmailA;
    private  EditText passW;
    private  EditText Confirm;
    private Button Sign;

    private TextView signIn ;
    private  EditText name;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




setup();



firebaseAuth = FirebaseAuth.getInstance();

        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()){
                    String user_email = EmailA.getText().toString().trim();
                    String pass_word = passW.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,pass_word).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent( MainActivity.this,Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Registration Failed, try again.", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(MainActivity.this,MainActivity.class);
                                startActivity(intent);
                            }


                        }
                    });


                }


            }
        });
        signIn = (TextView)findViewById(R.id.inSign) ;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

    }

    private void setup(){

        name = (EditText)findViewById(R.id.fulname);
        EmailA = (EditText)findViewById(R.id.email);
        passW = (EditText)findViewById(R.id.password);
        Confirm = (EditText)findViewById(R.id.passconfirm);
        Sign = (Button)findViewById(R.id.signup);


    }

    private  Boolean validate(){
        Boolean results = false;
        String nAme = name.getText().toString();
        String passwrd = passW.getText().toString();
        String mail = EmailA.getText().toString();
        String conf = Confirm.getText().toString();

        if (nAme.isEmpty() || passwrd.isEmpty() || mail.isEmpty() || conf.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter all the details :", Toast.LENGTH_SHORT).show();
        }


        else {
            results = true;
        }
        if(passwrd != conf) {
            Toast.makeText(MainActivity.this, "Password not identical , enter same password:", Toast.LENGTH_SHORT).show();
        }

        return results;
    }

}