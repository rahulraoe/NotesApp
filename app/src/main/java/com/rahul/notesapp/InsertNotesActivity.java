package com.rahul.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    EditText etitle,econtent;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppBarTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_notes);
        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                .allowMainThreadQueries()
                .build();
        etitle=(EditText)findViewById(R.id.etitle);
        econtent=(EditText)findViewById(R.id.econtent);
        submit=(Button)findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                db.NoteDao().insertNotes(new NoteClass(dateFormat.format(date),etitle.getText().toString(),econtent.getText().toString(),"default",dateFormat.format(date)));
                finish();
            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
