package com.appsquadz.feedback_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddFaculty extends AppCompatActivity {
    List<Faculty> faculties;

    EditText FacultyName;
    EditText FacultyId;
    EditText FacultyEmail;
    EditText FacultyNumber;
    Button addfaculty;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        FacultyName=findViewById(R.id.input_facultyname);
        FacultyId=findViewById(R.id.input_facultyId);
        FacultyNumber=findViewById(R.id.input_facultyNumber);
        FacultyEmail=findViewById(R.id.input_facultyemail);
        addfaculty=findViewById(R.id.btn_addFaculty);

        databaseReference= FirebaseDatabase.getInstance().getReference("faculties");
        faculties=new ArrayList<>();

        addfaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aFaculty();
            }
        });

    }

    private void aFaculty() {
        String id = databaseReference.push().getKey();

        String name=FacultyName.getText().toString().trim();
        String number=FacultyNumber.getText().toString().trim();
        String Id=FacultyId.getText().toString().trim();
        String email=FacultyEmail.getText().toString().trim();




        Faculty faculty = new Faculty(Id, name,number,email);
        databaseReference.child(id).setValue(faculty);

    Toast.makeText(this, "Faculty added", Toast.LENGTH_LONG).show();
    }
}
