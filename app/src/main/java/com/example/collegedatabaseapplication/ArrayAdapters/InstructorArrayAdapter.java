package com.example.collegedatabaseapplication.ArrayAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.collegedatabaseapplication.Entities.Instructor;

import java.util.List;

public class InstructorArrayAdapter extends ArrayAdapter {
        private List<Instructor> mInstructors;
        public InstructorArrayAdapter(@NonNull Context context, int resource, List<Instructor> instructors) {
            super(context, resource, instructors);
            mInstructors = instructors;
        }
        @Override
        public int getCount() {
            return mInstructors.size();
        }
        @Override
        public Instructor getItem(int position) {
            return mInstructors.get(position);
        }
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            Instructor instructor = getItem(position);
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText(instructor.mFirstName + " " + instructor.mLastName);
            return convertView;
        }
}
