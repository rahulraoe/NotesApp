package com.rahul.notesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.io.Serializable;
import java.util.List;

//this also changed////

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<NoteClass> mynotes;
    Context con;

    public RecyclerAdapter(List<NoteClass> mynotes) {
        this.mynotes=mynotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rec,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        holder.title.setText(mynotes.get(position).getTitle());
        holder.content.setText(mynotes.get(position).getContent());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con,ViewNotesActivity.class);
                intent.putExtra("title",mynotes.get(position).getTitle() );
                intent.putExtra("content",mynotes.get(position).getContent() );
                intent.putExtra("date",mynotes.get(position).getDate());
                intent.putExtra("noteid",mynotes.get(position).getNoteid());
               // Toast.makeText(con, "hello"+mynotes.get(position).getDate(), Toast.LENGTH_SHORT).show();
               // intent.putExtra("note", (Serializable) mynotes.get(position));
                con.startActivity(intent);
//
//                final AppDatabase db= Room.databaseBuilder(con,AppDatabase.class,"abc")
//                        .allowMainThreadQueries()
//                        .build();
//                db.NoteDao().delete(mynotes.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mynotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,content;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            content=itemView.findViewById(R.id.content);
            cardView=itemView.findViewById(R.id.card);
            con=itemView.getContext();
        }
    }

    public void afterchanges(List<NoteClass> mynotes)
    {
        this.mynotes=mynotes;
    notifyDataSetChanged();
    }
}
