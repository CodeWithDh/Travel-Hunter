package com.women.womensaftey;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Activities.Details_Activity;
import com.women.womensaftey.Model.Places_Model;

import java.util.ArrayList;

public class Learknown_Adapter extends RecyclerView.Adapter<Learknown_Adapter.ViewHolder> {
    ArrayList<Places_Model> arrayList = new ArrayList<>();
    Context context;

    public Learknown_Adapter(Context context2, ArrayList<Places_Model> arrayList2) {
        this.context = context2;
        this.arrayList = arrayList2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.list_places, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.root.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Learknown_Adapter.this.context, Details_Activity.class);
                intent.putExtra("image", Learknown_Adapter.this.arrayList.get(position).getImage());
                intent.putExtra("name", Learknown_Adapter.this.arrayList.get(position).getName());
                intent.putExtra("address", Learknown_Adapter.this.arrayList.get(position).getAddress());
                intent.putExtra("budget", Learknown_Adapter.this.arrayList.get(position).getBudget());
                intent.putExtra("disc", Learknown_Adapter.this.arrayList.get(position).getDiscriptions());
                Learknown_Adapter.this.context.startActivity(intent);
            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Learknown_Adapter.this.context, Details_Activity.class);
                intent.putExtra("image", Learknown_Adapter.this.arrayList.get(position).getImage());
                intent.putExtra("name", Learknown_Adapter.this.arrayList.get(position).getName());
                intent.putExtra("address", Learknown_Adapter.this.arrayList.get(position).getAddress());
                intent.putExtra("budget", Learknown_Adapter.this.arrayList.get(position).getBudget());
                intent.putExtra("disc", Learknown_Adapter.this.arrayList.get(position).getDiscriptions());
                Learknown_Adapter.this.context.startActivity(intent);
            }
        });
        holder.image.setImageResource(this.arrayList.get(position).getImage());
        holder.place_name.setText(this.arrayList.get(position).getName());
        holder.address.setText(this.arrayList.get(position).getAddress());
        holder.crowd.setText(this.arrayList.get(position).getCrowd());
    }

    public int getItemCount() {
        return this.arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        Button button;
        TextView crowd;
        ImageView image;
        TextView place_name;
        RelativeLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.place_iamge);
            this.place_name = (TextView) itemView.findViewById(R.id.place_name);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.crowd = (TextView) itemView.findViewById(R.id.crowd);
            this.root = (RelativeLayout) itemView.findViewById(R.id.root);
            this.button = (Button) itemView.findViewById(R.id.btn);
        }
    }
}