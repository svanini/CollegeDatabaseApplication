package com.example.collegedatabaseapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.collegedatabaseapplication.ViewModels.CourseViewModel;
import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.R;

public class AddCourseActivity extends AppCompatActivity {
    private int instructorId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);

        Intent intent = getIntent();
        instructorId = intent.getIntExtra("instructorId", 1);

        findViewById(R.id.createButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText) findViewById(R.id.titleEditText)).getText().toString();
                String description = ((EditText) findViewById(R.id.descriptionEditText)).getText().toString();
                int credits = Integer.parseInt(((EditText) findViewById(R.id.creditsEditText)).getText().toString());

                if(title.equals("")) title = "Title";
                if(description.equals("")) description = "Description";

                CourseViewModel courseViewModel = new CourseViewModel(getApplication());
                Course course = new Course(title, description, credits, instructorId);
                courseViewModel.insertCourse(course);
                finish();
            }
        });
    }
}
