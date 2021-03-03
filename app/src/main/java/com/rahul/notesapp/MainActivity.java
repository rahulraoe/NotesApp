package com.rahul.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;



//this is changed activity///
public class MainActivity extends AppCompatActivity {
RecyclerView rec;
RecyclerAdapter recyclerAdapter;
FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppBarTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("My Notes");
        rec=(RecyclerView)findViewById(R.id.rec);
        fab=(FloatingActionButton)findViewById(R.id.fab);


       final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                .allowMainThreadQueries()
                .build();
        //db.NoteDao().deletenotes();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                db.NoteDao().insertNotes(new NoteClass("123","hello","hellocontent"));
//                List<NoteClass> mynotes =db.NoteDao().getAllNotes();
//                recyclerAdapter. afterchanges(mynotes);

                startActivity(new Intent(MainActivity.this,InsertNotesActivity.class));
            }
        });
        //rec.setLayoutManager(new LinearLayoutManager(this));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(staggeredGridLayoutManager);
        List<NoteClass> mynotes =db.NoteDao().getAllNotes();
        recyclerAdapter=new RecyclerAdapter(mynotes);
        rec.setAdapter(recyclerAdapter);



    }


    @Override
    protected void onRestart() {
        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                .allowMainThreadQueries()
                .build();
        List<NoteClass> mynotes =db.NoteDao().getAllNotes();
              recyclerAdapter. afterchanges(mynotes);
        super.onRestart();
    }
}
