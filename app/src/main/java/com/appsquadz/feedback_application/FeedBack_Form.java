package com.appsquadz.feedback_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedBack_Form extends AppCompatActivity {


    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back__form);

        submit=findViewById(R.id.btn_submitf);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedBack_Form.this,AddFaculty.class));
            }
        });
    }
}
