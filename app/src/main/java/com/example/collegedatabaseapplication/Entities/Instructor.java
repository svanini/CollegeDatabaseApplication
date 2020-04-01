package com.example.collegedatabaseapplication.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Instructor {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "first_name")
    public String mFirstName;

    @ColumnInfo(name = "last_name")
    public String mLastName;

    @ColumnInfo(name = "qualification")
    public String mQualification;

    public Instructor(String mFirstName, String mLastName, String mQualification) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mQualification = mQualification;
    }
}
