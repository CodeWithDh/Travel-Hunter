package com.women.womensaftey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Model.Hotel_Street_Model;

import java.util.ArrayList;

public class Hotel_Street_Adapter extends RecyclerView.Adapter<Hotel_Street_Adapter.ViewHolder> {
    Context context;
    ArrayList<Hotel_Street_Model> s_arraylist = new ArrayList<>();

    public Hotel_Street_Adapter(Context context2, ArrayList<Hotel_Street_Model> s_arraylist2) {
        this.context = context2;
        this.s_arraylist = s_arraylist2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.street_hotel_items, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(this.s_arraylist.get(position).getImage());
        holder.name.setText(this.s_arraylist.get(position).getName());
        holder.address.setText(this.s_arraylist.get(position).getAddress());
        holder.timing.setText(this.s_arraylist.get(position).getTiming());
        holder.contact.setText(this.s_arraylist.get(position).getContact());
    }

    public int getItemCount() {
        return this.s_arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView contact;
        ImageView imageView;
        TextView name;
        TextView timing;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image_view);
            this.name = (TextView) itemView.findViewById(R.id.hotel_name);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.timing = (TextView) itemView.findViewById(R.id.timing);
            this.contact = (TextView) itemView.findViewById(R.id.contact);
        }
    }
}