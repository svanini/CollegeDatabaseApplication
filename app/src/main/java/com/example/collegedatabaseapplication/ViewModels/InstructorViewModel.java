package com.example.collegedatabaseapplication.ViewModels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.collegedatabaseapplication.Databases.CollegeDatabase;
import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.Entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorViewModel extends AndroidViewModel {
    private CollegeDatabase collegeDatabase;
    private LiveData<List<Instructor>> instructors;

    public InstructorViewModel(Application application) {
        super(application);
        collegeDatabase = collegeDatabase.getInstance(application.getApplicationContext());
        instructors = collegeDatabase.getInstructorDao().getAllInstructors();
    }

    public LiveData<List<Instructor>> getAllInstructors() { return instructors; };

    public void insertInstructor(Instructor instructor) {
        new InsertInstructorAsyncTask().execute(instructor);
    }

    private class InsertInstructorAsyncTask extends AsyncTask<Instructor, Void, Void> {
        @Override
        protected Void doInBackground(Instructor... instructors) {
            Instructor instructor = instructors[0];
            collegeDatabase.getInstructorDao().insert(instructor);
            return null;
        }
    }
}
