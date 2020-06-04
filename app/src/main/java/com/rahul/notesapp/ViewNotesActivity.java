package com.rahul.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ViewNotesActivity extends AppCompatActivity {

    String title,content,date,noteid;
    EditText vtitle,vcontent;
    NoteClass noteClass;


    String ntitle,ncontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppBarTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        title=getIntent().getStringExtra("title");
        content=getIntent().getStringExtra("content");
        date=getIntent().getStringExtra("date");
        noteid=getIntent().getStringExtra("noteid");
//        noteClass= (NoteClass) getIntent().getSerializableExtra("note");
      //Toast.makeText(this, "hello"+noteid, Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vtitle=(EditText) findViewById(R.id.vtitle);
        vcontent=(EditText) findViewById(R.id.vcontent);
        vtitle.setText(title);
        vcontent.setText(content);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.threedotsmenu,menu);
        MenuItem item1=menu.findItem(R.id.delete);
        MenuItem item2=menu.findItem(R.id.colors);
        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

//               NoteClass abc=new NoteClass(date,title,content);
////               abc.setNoteid(Integer.parseInt(noteid));
                final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                        .allowMainThreadQueries()
                        .build();
                db.NoteDao().deletenotes(date);
                finish();

                return false;
            }
        });
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                Toast.makeText(ViewNotesActivity.this, "colors", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        ntitle=vtitle.getText().toString();
        ncontent=vcontent.getText().toString();
        if(ntitle!=title || ncontent!=content){
            final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                    .allowMainThreadQueries()
                    .build();
            db.NoteDao().updatenotes(date,ntitle,ncontent);
            super.onBackPressed();

        }
        else
            super.onBackPressed();
    }

    @Override
    protected void onDestroy() {

        ntitle=vtitle.getText().toString();
        ncontent=vcontent.getText().toString();
        if(ntitle!=title || ncontent!=content){
            final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"abc")
                    .allowMainThreadQueries()
                    .build();
            db.NoteDao().updatenotes(date,ntitle,ncontent);
            super.onDestroy();

        }
        else
        super.onDestroy();
    }
}
