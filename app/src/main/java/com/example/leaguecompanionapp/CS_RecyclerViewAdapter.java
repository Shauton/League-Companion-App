package com.example.leaguecompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CS_RecyclerViewAdapter extends RecyclerView.Adapter<CS_RecyclerViewAdapter.MyViewHolder> {

    private final ChampViewInterface champViewInterface;

    Context context;
    ArrayList<Champion> champions;

    public CS_RecyclerViewAdapter(Context context, ArrayList<Champion> champions, ChampViewInterface champViewInterface) {

        this.context = context;
        this.champions = champions;
        this.champViewInterface = champViewInterface;
    }

    @NonNull
    @NotNull
    @Override
    public CS_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new CS_RecyclerViewAdapter.MyViewHolder(view, champViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CS_RecyclerViewAdapter.MyViewHolder holder, int i) {

        holder.champName.setText(champions.get(i).getName());
        holder.champTitle.setText(champions.get(i).getDescription());
        holder.champImage.setImageResource(champions.get(i).getImageId());

    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView champImage;
        TextView champName, champTitle;

        public MyViewHolder(@NonNull View itemView, ChampViewInterface champViewInterface) {
            super(itemView);

            champImage = itemView.findViewById(R.id.champImageView);
            champName = itemView.findViewById(R.id.champNameView);
            champTitle = itemView.findViewById(R.id.champTitleView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (champViewInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            champViewInterface.onItemClicked(position);
                        }
                    }
                }
            });

        }
    }
}
