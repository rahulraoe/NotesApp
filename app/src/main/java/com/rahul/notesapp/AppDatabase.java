package com.rahul.notesapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = NoteClass.class,version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao NoteDao();
}
