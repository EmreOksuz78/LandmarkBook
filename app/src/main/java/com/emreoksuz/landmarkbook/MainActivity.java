package com.emreoksuz.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.emreoksuz.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        Landmark kizkulesi = new Landmark("Kız Kulesi", "Türkiye", R.drawable.kizkulesi);
        Landmark galatakulesi = new Landmark("Galata Kulesi", "Türkiye", R.drawable.galatakulesi);
        Landmark bogazkoprusu = new Landmark("Boğaz Köprüsü", "Türkiye", R.drawable.bogazkoprusu);
        Landmark kapadokya = new Landmark("Kapadokya", "Türkiye", R.drawable.kapadokya);

        landmarkArrayList.add(kizkulesi);
        landmarkArrayList.add(galatakulesi);
        landmarkArrayList.add(bogazkoprusu);
        landmarkArrayList.add(kapadokya);

        //Yazılar alt alta mı yoksa yan yana mı olsun
        //Alt alta istediğimizden LinearLayoutManager kullandık eğer yan yana isteseydik gridLayout kullanıcaktık.
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        landmarkAdapter landmarkAdapter = new landmarkAdapter(landmarkArrayList);

        //Oluşturulan Adapter u buraya vermek için setAdapter kullanılır.
        binding.recyclerView.setAdapter(landmarkAdapter);


    }
}