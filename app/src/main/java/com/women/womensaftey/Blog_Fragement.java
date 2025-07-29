package com.women.womensaftey;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.women.womensaftey.Model.Blog_Model;

import java.util.ArrayList;


public class Blog_Fragement extends Fragment {

    ArrayList<Blog_Model> b_array_list = new ArrayList<>();
    RecyclerView recyclerView;
    public Blog_Fragement() {


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blog__fragement, container, false);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyler_view);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.b_array_list.add(new Blog_Model(R.drawable.chandigarh, "Chandigarh", "Best Places In Chandigarh", "Chandigarh, known as \"The City Beautiful,\" boasts several captivating places to explore. The Rock Garden, a masterpiece crafted from industrial waste, is a unique artistic haven. Sukhna Lake offers serenity with boating and lush green surroundings. The Capitol Complex, a UNESCO World Heritage site, showcases modernist architecture. Leisure Valley, a lush green stretch, is perfect for leisurely strolls. Nek Chand's Fantasy Rock Garden, a whimsical sculpture garden, sparks creativity. Rose Garden, home to thousands of blooming roses, is a floral delight. Chandigarh's sector markets, like Sector 17, cater to shopaholics. These diverse attractions make Chandigarh an enchanting destination.", "20 Nov"));
        this.b_array_list.add(new Blog_Model(R.drawable.sukhan_lake_chandigarh, "Chandigarh", "Know Everything About Sukhna Lake", "Sukhna Lake, an idyllic man-made reservoir nestled in the heart of Chandigarh, is a tranquil oasis that spans over 3 square kilometers. Its serene waters, fringed by lush greenery and a walking promenade, offer a perfect escape from the urban hustle. Visitors can enjoy boating, including paddle and rowing boats, while the distant Shivalik Hills provide a picturesque backdrop. It's a haven for birdwatchers as migratory birds flock here in the winter. The Lake Club adjacent to the lake hosts various water sports and activities. Sukhna Lake's calm ambiance, stunning sunsets, and recreational opportunities make it a cherished retreat for locals and tourists alike.", "25 Oct"));
        this.b_array_list.add(new Blog_Model(R.drawable.jaipur, "Jaipur", "Top 10 Places In Jaipur", "", "24 Oct"));
        this.b_array_list.add(new Blog_Model(R.drawable.loutou_temple, "Delhi", "Top 5 Parks To Visit In Delhi", "Delhi, India's vibrant capital, boasts an array of beautiful parks. 1. Lodhi Gardens, with its historical tombs and landscaped greenery, offers a serene retreat. 2. India Gate Lawns, surrounding the iconic India Gate monument, are perfect for picnics and evening strolls. 3. Garden of Five Senses entices with its unique sculptures, flowers, and a delightful ambiance. 4. Hauz Khas Deer Park combines nature and history, with a medieval reservoir and deer enclosure. 5. Nehru Park is a sprawling haven with well-maintained gardens and a serene lake. These parks provide peaceful respites from the bustling city and are beloved by Delhi's residents and visitors alike.", "22 Oct"));
        this.recyclerView.setAdapter(new Blog_Adapter(getContext(), this.b_array_list));
        return view;
    }
}