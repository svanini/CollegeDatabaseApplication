package com.example.collegedatabaseapplication.ArrayAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.collegedatabaseapplication.Entities.Course;
import com.example.collegedatabaseapplication.Entities.Instructor;

import java.util.List;

public class CourseArrayAdapter extends ArrayAdapter {
    private List<Course> mCourses;
    public CourseArrayAdapter(@NonNull Context context, int resource, List<Course> courses) {
        super(context, resource, courses);
        mCourses = courses;
    }
    @Override
    public int getCount() {
        return mCourses.size();
    }
    @Override
    public Course getItem(int position) {
        return mCourses.get(position);
    }
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        Course course = getItem(position);
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(course.mTitle);
        return convertView;
    }
}
