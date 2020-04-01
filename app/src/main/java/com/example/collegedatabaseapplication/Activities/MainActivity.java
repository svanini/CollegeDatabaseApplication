package com.example.collegedatabaseapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.collegedatabaseapplication.Entities.Instructor;
import com.example.collegedatabaseapplication.ArrayAdapters.InstructorArrayAdapter;
import com.example.collegedatabaseapplication.ViewModels.InstructorViewModel;
import com.example.collegedatabaseapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView instructorsListView;
    private InstructorViewModel instructorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instructorsListView = findViewById(R.id.instructorsListView);

        instructorViewModel = new InstructorViewModel(getApplication());

        instructorViewModel.getAllInstructors().observe(this, new Observer<List<Instructor>>() {
            @Override
            public void onChanged(List<Instructor> instructors) {
                if (instructors == null) {
                    return;
                }
                InstructorArrayAdapter adapter = new InstructorArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, instructors);
                instructorsListView.setAdapter(adapter);
            }
        });

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddInstructorActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        instructorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instructor item = (Instructor) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), CourseListActivity.class);
                intent.putExtra("instructorId", item.id);
                startActivity(intent);
            }
        });
    }
}
