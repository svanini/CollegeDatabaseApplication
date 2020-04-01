package com.example.collegedatabaseapplication.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.Entities.Instructor;

import java.util.List;

@Dao
public interface InstructorDAO {
    @Insert
    void insert(Instructor instructor);

    @Query("DELETE FROM instructor")
    void deleteAll();

    @Query("SELECT * FROM instructor")
    LiveData<List<Instructor>> getAllInstructors();
}
