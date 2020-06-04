package com.rahul.notesapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteClass {
    @PrimaryKey(autoGenerate = true)
    private int noteid;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "edited_date")
    private String edited_date;



    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEdited_date() {
        return edited_date;
    }

    public void setEdited_date(String edited_date) {
        this.edited_date = edited_date;
    }

    public NoteClass(String date, String title, String content, String color, String edited_date) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.color = color;
        this.edited_date = edited_date;
    }
}
