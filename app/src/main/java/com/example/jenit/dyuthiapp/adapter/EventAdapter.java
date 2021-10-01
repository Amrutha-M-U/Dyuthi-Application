package com.example.jenit.dyuthiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jenit.dyuthiapp.R;
import com.example.jenit.dyuthiapp.model.EventsDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jenit on 30-08-2016.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<EventsDetails> events;
    private int rowLayout;
    private Context context;


    public static class EventViewHolder extends RecyclerView.ViewHolder {
        LinearLayout eventListLayout;
        TextView eventName;
        TextView location;
        TextView time;
        ImageView imageView;




        public EventViewHolder(View v) {
            super(v);

            eventListLayout = (LinearLayout) v.findViewById(R.id.relative_parent);
            eventName = (TextView) v.findViewById(R.id.eventname);
            location = (TextView) v.findViewById(R.id.venue);
            time = (TextView) v.findViewById(R.id.event_time);
            imageView = (ImageView)v.findViewById(R.id.image);

        }
    }

    public EventAdapter(List<EventsDetails> events, int rowLayout, Context context) {
        this.events = events;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new EventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {
        holder.eventName.setText(events.get(position).getEvent());
        holder.location.setText(events.get(position).getVenue());
        holder.time.setText(events.get(position).getTime());
        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w500" + events.get(position).getPosterPath())
                .resize(220,270)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),Main22Activity.class);
                intent.putExtra("abc",movies.get(position).getTitle().toString());
                intent.putExtra("def",movies.get(position).getOverview().toString());
                intent.putExtra("ghi",movies.get(position).getPosterPath().toString());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }







}
