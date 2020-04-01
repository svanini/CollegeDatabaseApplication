package com.example.collegedatabaseapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collegedatabaseapplication.Entities.Instructor;
import com.example.collegedatabaseapplication.ViewModels.InstructorViewModel;
import com.example.collegedatabaseapplication.R;

public class AddInstructorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_instructor);

        findViewById(R.id.createButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = ((EditText) findViewById(R.id.firstNameEditText)).getText().toString();
                String secondName = ((EditText) findViewById(R.id.secondNameEditText)).getText().toString();
                String qualification = ((EditText) findViewById(R.id.secondNameEditText)).getText().toString();

                if(firstName.equals("")) firstName = "Name";
                if(secondName.equals("")) secondName = "Surname";
                if(qualification.equals("")) qualification = "Qualification";

                Instructor instructor = new Instructor(firstName, secondName, qualification);

                InstructorViewModel instructorViewModel = new InstructorViewModel(getApplication());
                instructorViewModel.insertInstructor(instructor);
                finish();
            }
        });
    }
}
