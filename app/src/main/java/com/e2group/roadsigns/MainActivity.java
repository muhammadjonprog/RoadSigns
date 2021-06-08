package com.e2group.roadsigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.e2group.roadsigns.Adapters.CategoriesAdapter;
import com.e2group.roadsigns.Model.CategoriesSign;
import com.e2group.roadsigns.ViewModel.ViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CategoriesAdapter categoriesAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        categoriesAdapter = new CategoriesAdapter(this);
        recyclerView.setAdapter(categoriesAdapter);

        ViewModel articleViewModel = new ViewModelProvider(this).get(ViewModel.class);

        articleViewModel.getAllArticles().observe(this, new Observer<List<CategoriesSign>>() {
            @Override
            public void onChanged(List<CategoriesSign> categoriesSigns) {
                categoriesAdapter.setArticles(categoriesSigns);
                Log.d("TAG","textSign"+categoriesSigns.get(0).getText());
            }
        });
    }
}