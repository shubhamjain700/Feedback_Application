package com.appsquadz.feedback_application;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class SignActivity extends AppCompatActivity {
    TextView signup;
    FirebaseAuth firebaseAuth;
    EditText email;
    EditText passowrd;
    Button login;
    TextView forgotPassword;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        signup=findViewById(R.id.sign_up);
        firebaseAuth=FirebaseAuth.getInstance();
        login=findViewById(R.id.login1);
        email=findViewById(R.id.email);
        passowrd=findViewById(R.id.password);
        forgotPassword=findViewById(R.id.link_forgotPassword);



//        addFaculty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignActivity.this,AddFaculty.class));
//
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e=email.getText().toString().trim();
                String pass=passowrd.getText().toString().trim();
                validation(e,pass);
//                firebaseAuth.signInWithEmailAndPassword(e,pass);
//

            }
        });



        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    startActivity(new Intent(SignActivity.this,Forgot_Password.class));

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignActivity.this,SignUp.class));

            }
        });






    }

    private void validation(String e, String pass) {



        firebaseAuth.signInWithEmailAndPassword(e,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(SignActivity.this,FeedBack_Form.class));

                            Toast.makeText(SignActivity.this,"Sucessful",
                                    Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(SignActivity.this,""+task.isSuccessful(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    });
    }

}
