package com.women.womensaftey;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Model.Places_Model;

import java.util.ArrayList;

public class leaser_known_Activity extends AppCompatActivity {

    ArrayList<Places_Model> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaser_known);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recylerView);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        String value = getIntent().getStringExtra("getData");

        if (value.equals("Chandigarh")) {
         //   String valueOf = String.valueOf(R.string.about_iskon);
            this.arrayList.add(new Places_Model(R.drawable.iskon_temple, "ISKCON Temple", "Sector-36B, Chandigarh, 160036", "Non- Crowded ", "The International Society for Krishna Consciousness (ISKCON) was established in 1966 by His Divine Grace A.C. Bhaktivedanta Swami Prabhupada (Srila Prabhupada). ISKCON has since developed into a worldwide confederation of 10,000 temple devotees and 250,000 congregational", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.trace_garden, "Terraced Garden", "33 Market Rd, Sector 33B, Chandigarh, 160036", "", "Sprawling over 10 acres of land, the primary attraction of the Terraced Garden is the musical fountain that dances to its own rhythm when Bollywood hits are played in the background every evening, adding an artistic touch to its natural landscapes.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.le, "Le Corbusier Centre", "Sector 19B Old Architect Building", "Non- Crowded ", "Chandigarh's Capitol Complex built by Le Corbusier is an interplay of edifices and symbols. The Capitol Complex, completed in 1961, is a glowing example of the genius of Corbusier, the visionary who had a profound impact on modern Indian architecture.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.butterfly_park, "Butterfly Park", "Sector-36B, Chandigarh, 160036", "Non- Crowded ", "The Butterfly Park in Chandigarh, India, is a haven for various butterfly species. Located in Sector 26, it aims to conserve and showcase these delicate creatures. The park's landscaped environment mimics their natural habitat, making it an ideal place for visitors to learn about butterflies and their importance in pollination and biodiversity. It offers educational exhibits and photo opportunities. A nominal entry fee supports conservation efforts. This tranquil park in Chandigarh attracts nature enthusiasts, families, and photography enthusiasts alike. It's a unique destination for appreciating the beauty of butterflies and understanding their ecological significance.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.garder_science, "Garden of Silence", "5, Lake Walking Way, Kishangarh", "Non- Crowded ", "The Garden of Silence in Chandigarh is a serene and contemplative space designed for quiet reflection and relaxation. Located in the city's bustling Sector 27, this garden offers a peaceful escape from the urban hustle and bustle. It features lush greenery, soothing water features, and comfortable seating, making it an ideal spot for meditation and self-discovery. The Garden of Silence is a place for individuals to find solace and inner peace amidst the city's vibrant energy. Visitors can unwind and recharge in this tranquil oasis", "500 per day"));
            this.recyclerView.setAdapter(new Learknown_Adapter(this, this.arrayList));
        }
        if (value.equals("Jaipur")) {
            this.arrayList.add(new Places_Model(R.drawable.chandal, "CHANDLAI LAKE", "Sector-36B, Chandigarh, 160036", "Non- Crowded ", "The International Society for Krishna Consciousness (ISKCON) was established in 1966 by His Divine Grace A.C. Bhaktivedanta Swami Prabhupada (Srila Prabhupada). ISKCON has since developed into a worldwide confederation of 10,000 temple devotees and 250,000 congregational", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.hathi_gaon, "HATHI GAON", "33 Market Rd, Sector 33B, Chandigarh, 160036", "", "Sprawling over 10 acres of land, the primary attraction of the Terraced Garden is the musical fountain that dances to its own rhythm when Bollywood hits are played in the background every evening, adding an artistic touch to its natural landscapes.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.hathi_gaon, "SAGAR LAKE ", "Sector 19B Old Architect Building", "Non- Crowded ", "Chandigarh's Capitol Complex built by Le Corbusier is an interplay of edifices and symbols. The Capitol Complex, completed in 1961, is a glowing example of the genius of Corbusier, the visionary who had a profound impact on modern Indian architecture.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.grah_ganesh, "GARH GANESHJI ", "Sector-36B, Chandigarh, 160036", "Non- Crowded ", "The Butterfly Park in Chandigarh, India, is a haven for various butterfly species. Located in Sector 26, it aims to conserve and showcase these delicate creatures. The park's landscaped environment mimics their natural habitat, making it an ideal place for visitors to learn about butterflies and their importance in pollination and biodiversity. It offers educational exhibits and photo opportunities. A nominal entry fee supports conservation efforts. This tranquil park in Chandigarh attracts nature enthusiasts, families, and photography enthusiasts alike. It's a unique destination for appreciating the beauty of butterflies and understanding their ecological significance.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.jain_temple, "CHULGIRI JAIN TEMPLE ", "5, Lake Walking Way, Kishangarh", "Non- Crowded ", "The Garden of Silence in Chandigarh is a serene and contemplative space designed for quiet reflection and relaxation. Located in the city's bustling Sector 27, this garden offers a peaceful escape from the urban hustle and bustle. It features lush greenery, soothing water features, and comfortable seating, making it an ideal spot for meditation and self-discovery. The Garden of Silence is a place for individuals to find solace and inner peace amidst the city's vibrant energy. Visitors can unwind and recharge in this tranquil oasis", "500 per day"));
            this.recyclerView.setAdapter(new Learknown_Adapter(this, this.arrayList));
        }
    }
}