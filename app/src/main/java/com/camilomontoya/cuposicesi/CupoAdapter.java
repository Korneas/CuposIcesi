package com.camilomontoya.cuposicesi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Camilo Montoya on 10/7/2017.
 */

public class CupoAdapter extends RecyclerView.Adapter<CupoAdapter.CupoViewHolder> {
    private List<CupoCard> items;

    public static class CupoViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public CupoViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgCupo);
        }
    }

    public CupoAdapter(List<CupoCard> items){
        this.items = items;
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public CupoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cupo_card, viewGroup, false);
        return new CupoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CupoViewHolder viewHolder, int i) {
        viewHolder.img.setImageResource(items.get(i).getImg());
    }
}
