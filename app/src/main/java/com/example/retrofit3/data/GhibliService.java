package com.example.retrofit3.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.retrofit3.MainActivity;
import com.example.retrofit3.model.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class GhibliService {
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://ghibliapi.herokuapp.com/")
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);


    public void getListFilms(GhibliCallback callback) {
        Call<List<Films>> call = service.getFilms();
        call.enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                        Log.e("tag", "response is here");
                    } else {
                        Log.e("tag", "Error" + new Exception());
                        callback.onFailure(new Exception());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                callback.onFailure(new Exception());
                Log.e("tag", "Error");
            }
        });
    }

    public void getFilmById(GhibliCallback callback, String id) {
        Call<Films> call = service.getFilmById(id);
        call.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() & response.body() != null) {
                    callback.onSuccessFilm(response.body());
                } else {
                    callback.onFailure(new Exception());
                }
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                Log.e("tag", "There is no film info" + t);
            }
        });
    }

    public interface GhibliApi {
        @GET("films/")
        Call<List<Films>> getFilms();

        @GET("films/{id}")
        Call<Films> getFilmById(@Path("id") String filmId);

    }

    public interface GhibliCallback {
        void onSuccess(List<Films> filmsList);

        void onFailure(Exception e);

        void onSuccessFilm(Films films);


    }
}
