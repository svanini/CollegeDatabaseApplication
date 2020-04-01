package com.example.collegedatabaseapplication.ViewModels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.collegedatabaseapplication.Databases.CollegeDatabase;
import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.Entities.Instructor;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private CollegeDatabase collegeDatabase;
    private LiveData<List<Course>> courses;

    public CourseViewModel(Application application) {
        super(application);
        collegeDatabase = collegeDatabase.getInstance(application.getApplicationContext());
        courses = collegeDatabase.getCourseDao().getAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() { return courses; };


    public LiveData<List<Course>> findCoursesByInstructorId(int instructorId) {
        return collegeDatabase.getCourseDao().findCoursesByInstructorId(instructorId);
    }

    public void insertCourse(Course course) {
        new InsertCourseAsyncTask().execute(course);
    }

    private class InsertCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        @Override
        protected Void doInBackground(Course... courses) {
            Course course = courses[0];
            collegeDatabase.getCourseDao().insert(course);
            return null;
        }
    }
}
