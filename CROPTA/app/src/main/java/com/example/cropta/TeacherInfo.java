package com.example.cropta;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;


public class TeacherInfo extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        String [] Subjects = {"dummy (go to assignment tab) ", "Teacher 0", "Teacher 2" , "Teacher 3"};
        ListAdapter TeacherInfo_Adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1 , Subjects);
        ListView TeacherInfo_ListView = (ListView) findViewById(R.id.TeacherInfo_ListView);
        TeacherInfo_ListView.setAdapter(TeacherInfo_Adapter);

        TeacherInfo_ListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String Subject = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(TeacherInfo.this,Subject + "selected", Toast.LENGTH_LONG).show();
                        if (position == 0) {
                            Intent i = new Intent(TeacherInfo.this, Assignments.class);
                            startActivity(i);
                        }
                    }
                }
        );
    }

    public void AddSubjectClicked(View view){
        Intent i = new Intent(this, AddTeacher
                .class);
        startActivity(i);

    }
}
