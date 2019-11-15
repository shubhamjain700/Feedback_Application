package com.appsquadz.feedback_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddFaculty extends AppCompatActivity {


    EditText FacultyName;
    EditText FacultyId;
    EditText FacultyEmail;
    EditText FacultyNumber;
    Button addfaculty;
    FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        FacultyName=findViewById(R.id.input_facultyname);
        FacultyId=findViewById(R.id.input_facultyId);
        FacultyNumber=findViewById(R.id.input_facultyNumber);
        FacultyEmail=findViewById(R.id.input_facultyemail);
        addfaculty=findViewById(R.id.btn_addFaculty);
       // firebaseAuth=FirebaseAuth.getInstance();
           firebaseFirestore= FirebaseFirestore.getInstance();


        addfaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=FacultyName.getText().toString().trim();
                String number=FacultyNumber.getText().toString().trim();
                String Id=FacultyId.getText().toString().trim();
                String email=FacultyEmail.getText().toString().trim();

                Map<String,String> mymap=new HashMap<>();
                mymap.put("name",name);
                mymap.put("number",number);
                firebaseFirestore.collection("users").add(mymap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AddFaculty.this, "Uploaded", Toast.LENGTH_SHORT).show();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error=e.getMessage();
                        Toast.makeText(AddFaculty.this,"Error :"+error, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }

}
