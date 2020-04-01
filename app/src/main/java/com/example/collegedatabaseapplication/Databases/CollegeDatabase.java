package com.example.collegedatabaseapplication.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.collegedatabaseapplication.DAOs.CourseDAO;
import com.example.collegedatabaseapplication.DAOs.InstructorDAO;
import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.Entities.Instructor;

@Database(entities = {Course.class, Instructor.class}, version = 2)
public abstract class CollegeDatabase extends RoomDatabase {
    private static volatile CollegeDatabase INSTANCE;

    public static CollegeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CollegeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CollegeDatabase.class,
                            "college_database")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    public abstract CourseDAO getCourseDao();

    public abstract InstructorDAO getInstructorDao();

}
