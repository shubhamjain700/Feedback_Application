package com.appsquadz.feedback_application;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText email;
    EditText password;
    FirebaseAuth firebaseAuth;
    Button signUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final TextView signin;
        firebaseAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.input_email);
        signin=findViewById(R.id.link_login);
        password=findViewById(R.id.input_password);
        signUp=findViewById(R.id.btn_signup);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=email.getText().toString().trim();
                String pass=password.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(em,pass);

                startActivity(new Intent(SignUp.this,SignActivity.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String em=email.getText().toString().trim();
//                String pass=password.getText().toString().trim();
//
//                firebaseAuth.createUserWithEmailAndPassword(em,pass);

                startActivity(new Intent(SignUp.this,SignActivity.class));
            }
        });


    }
}
