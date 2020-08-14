package com.example.retrofit3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit3.model.Films;

import java.util.List;

public class AdapterFilm extends RecyclerView.Adapter<AdapterFilm.ViewHolder> {
    List<Films> list;
    OnClick onInfoClick;

    public AdapterFilm(List<Films> list,OnClick onClick) {
        this.list = list;
        this.onInfoClick=onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.mainTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onInfoClick.onInfoCLick(getAdapterPosition());
                }
            });
        }

        public void onBind(Films films) {
            textView1.setText(films.getTitle());

        }
    }
}
