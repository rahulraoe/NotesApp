package com.rahul.notesapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface NoteDao {
    @Query("SELECT * FROM NoteClass ORDER BY date DESC")
    List<NoteClass> getAllNotes();
    @Insert
    void insertNotes(NoteClass...noteClasses);
    @Query("DELETE FROM Noteclass WHERE date = :abcd")
    void deletenotes(String abcd);
    @Delete
    void delete(NoteClass noteClass);


    @Query("UPDATE Noteclass SET title = :title,content = :content WHERE date = :abcd")
    void updatenotes(String abcd,String title,String content);


 }
