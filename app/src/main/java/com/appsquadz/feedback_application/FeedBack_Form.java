package com.appsquadz.feedback_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FeedBack_Form extends AppCompatActivity {

    EditText commentEdit, subjectEdit;
    private ProgressDialog progressDialog;
    private FirebaseFirestore firebaseFirestore;
    Button submit;

    RadioGroup qOneGroup, qTwoGroup, qThreeGroup, qFourGroup, qFiveGroup, qSixGroup, qSevenGroup, qEightGroup, qNineGroup, qTenGroup;
    RadioButton qOneButton, qTwoButton, qThreeButton, qFourButton, qFiveButton, qSixButton, qSevenButton, qEightButton, qNineButton, qTenButton;
    String getusername, statusString, ansOne, ansTwo, ansThree, ansFour, ansFive, ansSix, ansSeven, ansEight, ansNine, ansTen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back__form);

        submit=findViewById(R.id.btn_submitf);

        commentEdit = findViewById(R.id.comment);
        subjectEdit = findViewById(R.id.subject);
        qOneGroup = findViewById(R.id.rgOne);
        qTwoGroup = findViewById(R.id.rgTwo);
        qThreeGroup = findViewById(R.id.rgThree);
        qFourGroup = findViewById(R.id.rgFour);
        qFiveGroup = findViewById(R.id.rgFive);
        qSixGroup = findViewById(R.id.rgSix);
        qSevenGroup = findViewById(R.id.rgSeven);
        qEightGroup = findViewById(R.id.rgEight);
        qNineGroup = findViewById(R.id.rgNine);
        qTenGroup = findViewById(R.id.rgTen);
        firebaseFirestore= FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String commentString = commentEdit.getText().toString();
                String subjectString = subjectEdit.getText().toString();

                int qOneId = qOneGroup.getCheckedRadioButtonId();
                int qTwoId = qTwoGroup.getCheckedRadioButtonId();
                int qThreeId = qThreeGroup.getCheckedRadioButtonId();
                int qFourId = qFourGroup.getCheckedRadioButtonId();
                int qFiveId = qFiveGroup.getCheckedRadioButtonId();
                int qSixId = qSixGroup.getCheckedRadioButtonId();
                int qSevenId = qSevenGroup.getCheckedRadioButtonId();
                int qEightId = qEightGroup.getCheckedRadioButtonId();
                int qNineId = qNineGroup.getCheckedRadioButtonId();
                int qTenId = qTenGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                qOneButton = findViewById(qOneId);
                qTwoButton = findViewById(qTwoId);
                qThreeButton = findViewById(qThreeId);
                qFourButton = findViewById(qFourId);
                qFiveButton = findViewById(qFiveId);
                qSixButton = findViewById(qSixId);
                qSevenButton = findViewById(qSevenId);
                qEightButton = findViewById(qEightId);
                qNineButton = findViewById(qNineId);
                qTenButton = findViewById(qTenId);
                Map<String,String> rating=new HashMap<>();
                rating.put("Passion and enthusiasm to teach",qOneButton.getText().toString());
                rating.put("Subject knowledge", qTwoButton.getText().toString());
                rating.put("Clarity and emphasis on concept",qThreeButton.getText().toString());
                rating.put("Motivation and inspiring the student", qFourButton.getText().toString());
                rating.put("Creating interest in subject",qFiveButton.getText().toString());
                rating.put("Quality of illustrative examples",qSixButton.getText().toString());
                rating.put("Regularity, punctuality and uniform coverage of syllabus",qSevenButton.getText().toString());
                rating.put("Discipline and control over the class", qEightButton.getText().toString());
                rating.put("Promoting student thinking",qNineButton.getText().toString());
                rating.put("Encouraging and student interaction",qTenButton.getText().toString());
                firebaseFirestore.collection("users").add(rating).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        progressDialog.dismiss();
                        Toast.makeText(FeedBack_Form.this, " Feedback Uploaded Sucessfully", Toast.LENGTH_SHORT).show();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error=e.getMessage();
                        progressDialog.dismiss();
                        Toast.makeText(FeedBack_Form.this,"Error in uploading feedback:"+error, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }




}
