package com.example.collegedatabaseapplication.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.collegedatabaseapplication.Entities.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course course);

    @Query("DELETE FROM course")
    void deleteAll() ;

    @Query("SELECT * FROM course")
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM course " +
            "WHERE instructorId = :instructorID")
    LiveData<List<Course>> findCoursesByInstructorId(int instructorID);
}
