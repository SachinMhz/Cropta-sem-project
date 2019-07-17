package com.example.cropta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Assignments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Assignments.this, AddSubject.class);
                startActivity(i);
            }
        });

        String [] Subjects = {"dummy (go to teacher info tab) ", "Subject 0", "SUBJECT 2" , "SUBJECT 3"};
        ListAdapter Assignments_Adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1 , Subjects);
        ListView Assignments_ListView = (ListView) findViewById(R.id.Assignments_ListView);
        Assignments_ListView.setAdapter(Assignments_Adapter);

        Assignments_ListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String Subject = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Assignments.this, Subject + "Selected", Toast.LENGTH_LONG).show();
                        if (position == 0) {
                            Intent i = new Intent(Assignments.this, TeacherInfo.class);
                            startActivity(i);
                        }
                    }
                }
        );
    }


}
