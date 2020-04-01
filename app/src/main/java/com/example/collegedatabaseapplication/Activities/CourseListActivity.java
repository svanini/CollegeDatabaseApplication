package com.example.collegedatabaseapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.collegedatabaseapplication.ArrayAdapters.CourseArrayAdapter;
import com.example.collegedatabaseapplication.ViewModels.CourseViewModel;
import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.R;

import java.util.List;

public class CourseListActivity extends AppCompatActivity {
    private ListView coursesListView;
    private CourseViewModel courseViewModel;
    private int instructorId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);

        Intent intent = getIntent();
        instructorId = intent.getIntExtra("instructorId", 1);

        coursesListView = findViewById(R.id.coursesListView);

        courseViewModel = new CourseViewModel(getApplication());

        courseViewModel.findCoursesByInstructorId(instructorId).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                if (courses == null) {
                    return;
                }
                CourseArrayAdapter adapter = new CourseArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, courses);
                coursesListView.setAdapter(adapter);
            }
        });

        findViewById(R.id.fabCourse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCourseActivity.class);
                intent.putExtra("instructorId", instructorId);
                startActivityForResult(intent, 0);
            }
        });
    }
}
