package com.example.flycotablayoutapplication.adapter;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/28
 * @Describe:
 */
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flycotablayoutapplication.R;

import java.util.List;
import java.util.Map;

/**
 * @author xww
 * @desciption :
 * @date 2019/7/24
 * @time 12:06
 */
public class RecyclerLineAdapter extends RecyclerView.Adapter<RecyclerLineAdapter.ViewHolder> {

    Context context;
    List<Map<String, Object>> data;

    public RecyclerLineAdapter(Context context, List<Map<String, Object>> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclear_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.name.setText(data.get(i).get("name").toString());
        holder.desc.setText(data.get(i).get("desc").toString());
        holder.img.setImageResource(Integer.parseInt(data.get(i).get("pic").toString()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_recy_item_1_pic);
            name = itemView.findViewById(R.id.tv_recy_item_1_name);
            desc = itemView.findViewById(R.id.tv_recy_item_1_desc);

        }
    }
}

