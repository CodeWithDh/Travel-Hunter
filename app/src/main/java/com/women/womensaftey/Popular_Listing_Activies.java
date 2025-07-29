package com.women.womensaftey;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Model.Places_Model;

import java.util.ArrayList;

public class Popular_Listing_Activies extends AppCompatActivity {
    ArrayList<Places_Model> arrayList = new ArrayList<>();
    RecyclerView recyclerView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_popular_listing_activies);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String value = getIntent().getStringExtra("getData");
        if (value.equals("Chandigarh")) {
          //  String valueOf = String.valueOf(R.string.about_iskon);
            this.arrayList.add(new Places_Model(R.drawable.rock_garden, "The Rock Garden ", "Sector-36B, Chandigarh, 160036", "Crowded ", "The International Society for Krishna Consciousness (ISKCON) was established in 1966 by His Divine Grace A.C. Bhaktivedanta Swami Prabhupada (Srila Prabhupada). ISKCON has since developed into a worldwide confederation of 10,000 temple devotees and 250,000 congregational", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.doll_museum, "International Dolls Museum", "33 Market Rd, Sector 33B, Chandigarh, 160036", "Crowded", "Sprawling over 10 acres of land, the primary attraction of the Terraced Garden is the musical fountain that dances to its own rhythm when Bollywood hits are played in the background every evening, adding an artistic touch to its natural landscapes.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.sukhan_lake_chandigarh, "Sukhna Lake", "Sector 19B Old Architect Building", "Crowded ", "Chandigarh's Capitol Complex built by Le Corbusier is an interplay of edifices and symbols. The Capitol Complex, completed in 1961, is a glowing example of the genius of Corbusier, the visionary who had a profound impact on modern Indian architecture.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.child_art_gallery, "Child Art Gallery", "Sector-36B, Chandigarh, 160036", "Average Crowded ", "The Butterfly Park in Chandigarh, India, is a haven for various butterfly species. Located in Sector 26, it aims to conserve and showcase these delicate creatures. The park's landscaped environment mimics their natural habitat, making it an ideal place for visitors to learn about butterflies and their importance in pollination and biodiversity. It offers educational exhibits and photo opportunities. A nominal entry fee supports conservation efforts. This tranquil park in Chandigarh attracts nature enthusiasts, families, and photography enthusiasts alike. It's a unique destination for appreciating the beauty of butterflies and understanding their ecological significance.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.leisure_valley, "Leisure Valley", "Sector 10, Chandigarh, 160011", "Average Crowded ", "Le Corbusier retained the eroded valley of a seasonal rivulet on the original site of the City and sculptured it into a Linear park now over 8km long . It starts from Sector 1 in the north and leaves Chandigarh at its southernn most edge in sector 53", ""));
            this.arrayList.add(new Places_Model(R.drawable.capital_complex, "Capital Complex", "5, Lake Walking Way, Kishangarh", "Average Crowded ", "The Capitol Complex is made up of three concrete buildings: the Palace of Assembly or Legislative Assembly, the Secretariat and the High Court", ""));
            this.recyclerView.setAdapter(new Learknown_Adapter(this, this.arrayList));
        }
        if (value.equals("Jaipur")) {
          //  String valueOf2 = String.valueOf(R.string.about_iskon);
            this.arrayList.add(new Places_Model(R.drawable.albert_hall, "ALBERT HALL", "Sector-36B, Chandigarh, 160036", "Crowded ", "The International Society for Krishna Consciousness (ISKCON) was established in 1966 by His Divine Grace A.C. Bhaktivedanta Swami Prabhupada (Srila Prabhupada). ISKCON has since developed into a worldwide confederation of 10,000 temple devotees and 250,000 congregational", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.city_palace, "CITY PALACE ", "33 Market Rd, Sector 33B, Chandigarh, 160036", "Crowded", "Sprawling over 10 acres of land, the primary attraction of the Terraced Garden is the musical fountain that dances to its own rhythm when Bollywood hits are played in the background every evening, adding an artistic touch to its natural landscapes.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.nahagargh, "NAHARGARH", "Sector 19B Old Architect Building", "Crowded ", "Chandigarh's Capitol Complex built by Le Corbusier is an interplay of edifices and symbols. The Capitol Complex, completed in 1961, is a glowing example of the genius of Corbusier, the visionary who had a profound impact on modern Indian architecture.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.sheesj_mahal, "SHEESH MAHAL", "Sector-36B, Chandigarh, 160036", "Average Crowded ", "The Butterfly Park in Chandigarh, India, is a haven for various butterfly species. Located in Sector 26, it aims to conserve and showcase these delicate creatures. The park's landscaped environment mimics their natural habitat, making it an ideal place for visitors to learn about butterflies and their importance in pollination and biodiversity. It offers educational exhibits and photo opportunities. A nominal entry fee supports conservation efforts. This tranquil park in Chandigarh attracts nature enthusiasts, families, and photography enthusiasts alike. It's a unique destination for appreciating the beauty of butterflies and understanding their ecological significance.", "500 per day"));
            this.arrayList.add(new Places_Model(R.drawable.hawa_mehal, "HAWA MAHAL ", "Sector 10, Chandigarh, 160011", "Average Crowded ", "Le Corbusier retained the eroded valley of a seasonal rivulet on the original site of the City and sculptured it into a Linear park now over 8km long . It starts from Sector 1 in the north and leaves Chandigarh at its southernn most edge in sector 53", ""));
            this.recyclerView.setAdapter(new Learknown_Adapter(this, this.arrayList));
        }
    }
}
