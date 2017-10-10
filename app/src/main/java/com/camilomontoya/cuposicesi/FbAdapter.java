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

public class FbAdapter extends RecyclerView.Adapter<FbAdapter.FbViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(FbCard item);
    }

    private final List<FbCard> items;
    private final OnItemClickListener listener;

    public static class FbViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public FbViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgCupoFb);
        }

        public void bind(final FbCard item,final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public FbAdapter(List<FbCard> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public FbViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fb_card, viewGroup, false);
        return new FbViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FbViewHolder viewHolder, int i) {
        viewHolder.img.setImageResource(items.get(i).getImg());
        viewHolder.bind(items.get(i),listener);
    }
}