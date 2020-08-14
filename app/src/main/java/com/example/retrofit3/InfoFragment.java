package com.example.retrofit3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofit3.data.GhibliService;
import com.example.retrofit3.model.Films;

import java.util.List;

public class InfoFragment extends Fragment implements GhibliService.GhibliCallback {
    public static final String ARG_POSITION = "position";
    private TextView title, producer, year,description;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(int position) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String id = bundle.getString("position");
            App.ghibliService.getFilmById(this, id);
        }
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        producer = view.findViewById(R.id.producer);
        year = view.findViewById(R.id.releaseData);
        description = view.findViewById(R.id.description);


    }

    @Override
    public void onSuccess(List<Films> filmsList) {

    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onSuccessFilm(Films films) {
        title.setText(films.getTitle());
        producer.setText(films.getProducer());
        year.setText(films.getReleaseDate().toString());
        description.setText(films.getDescription());

    }
}