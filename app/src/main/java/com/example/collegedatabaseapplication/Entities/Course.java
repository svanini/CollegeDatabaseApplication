package com.example.collegedatabaseapplication.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Instructor.class,
                parentColumns = "id",
                childColumns = "instructorId")})
public class Course {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "title")
    public String mTitle;

    @ColumnInfo(name = "description")
    public String mDescription;

    @ColumnInfo(name = "credits")
    public int mCredits;

    @ColumnInfo(name="instructorId")
    public int mInstructorId;

    public Course(String mTitle, String mDescription, int mCredits, int mInstructorId) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mCredits = mCredits;
        this.mInstructorId = mInstructorId;
    }
}
