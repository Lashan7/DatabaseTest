package com.example.databasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.viewHolder>{

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImg = new ArrayList<>();
    private Context mContext;

    public RecycleViewAdapter( Context mContext, ArrayList<String> mNames, ArrayList<String> mImg) {
        this.mNames = mNames;
        this.mImg = mImg;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImg.get(position))
                .into(holder.img);

        holder.name.setText(mNames.get(position));

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }

}
