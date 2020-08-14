package com.example.retrofit3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retrofit3.data.GhibliService;
import com.example.retrofit3.model.Films;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GhibliService.GhibliCallback, OnClick {
    RecyclerView recyclerView;
    AdapterFilm adapter;
    List<Films> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.ghibliService.getListFilms(this);

    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterFilm(list,this::onInfoCLick);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSuccess(List<Films> filmsList) {
        Log.e("tag", "onSuccess response");
        list = filmsList;
        initRecycler();
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onSuccessFilm(Films films) {

    }

    @Override
    public void onInfoCLick(int position) {
        recyclerView.setVisibility(View.INVISIBLE);
        Bundle bundle = new Bundle();
        bundle.putString("position", list.get(position).getId());
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.info_frame,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
    }
}