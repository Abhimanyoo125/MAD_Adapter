package com.example.mad_adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewStudents = findViewById(R.id.listViewStudents);

        // Create a list of students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));
        students.add(new Student("Charlie"));
        students.add(new Student("David"));
        students.add(new Student("Eva"));

        // Create an ArrayAdapter with custom layout
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this,
                R.layout.list_item_student, // Use custom layout
                students) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Inflate the custom layout if convertView is null
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_student, parent, false);
                }

                // Get the current student
                Student currentStudent = getItem(position);

                // Set the student name to the TextView
                TextView textView = convertView.findViewById(R.id.textViewStudentName);
                if (currentStudent != null) {
                    textView.setText(currentStudent.getName());
                }

                return convertView;
            }
        };

        // Set the adapter to the ListView
        listViewStudents.setAdapter(adapter);
    }
}

