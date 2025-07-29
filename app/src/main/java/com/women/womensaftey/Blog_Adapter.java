package com.women.womensaftey;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Activities.Blog_read_Actiity;
import com.women.womensaftey.Model.Blog_Model;

import java.util.ArrayList;

public class Blog_Adapter extends RecyclerView.Adapter<Blog_Adapter.ViewHolder> {
    ArrayList<Blog_Model> b_array_list = new ArrayList<>();
    Context context;

    public Blog_Adapter(Context context2, ArrayList<Blog_Model> b_array_list2) {
        this.context = context2;
        this.b_array_list = b_array_list2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.blog_post_items, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.root.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Blog_Adapter.this.context, Blog_read_Actiity.class);
                intent.putExtra("image", Blog_Adapter.this.b_array_list.get(position).getImage());
                intent.putExtra("city", Blog_Adapter.this.b_array_list.get(position).getBlog_city_name());
                intent.putExtra("title", Blog_Adapter.this.b_array_list.get(position).getBlog_title());
                intent.putExtra("details", Blog_Adapter.this.b_array_list.get(position).getBlog_details());
                Blog_Adapter.this.context.startActivity(intent);
            }
        });
        holder.imageView.setImageResource(this.b_array_list.get(position).getImage());
        holder.blog_city.setText(this.b_array_list.get(position).getBlog_city_name());
        holder.blog_title.setText(this.b_array_list.get(position).getBlog_title());
        holder.blog_date.setText(this.b_array_list.get(position).getBlog_date());
    }

    public int getItemCount() {
        return this.b_array_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView blog_city;
        TextView blog_date;
        TextView blog_title;
        ImageView imageView;
        RelativeLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.blog_image);
            this.blog_city = (TextView) itemView.findViewById(R.id.city_blog_title);
            this.blog_title = (TextView) itemView.findViewById(R.id.blog_title);
            this.blog_date = (TextView) itemView.findViewById(R.id.date_uplod);
            this.root = (RelativeLayout) itemView.findViewById(R.id.root);
        }
    }
}