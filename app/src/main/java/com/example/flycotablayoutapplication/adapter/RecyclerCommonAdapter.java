package com.example.flycotablayoutapplication.adapter;

import android.graphics.ColorSpace;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.flycotablayoutapplication.R;

import java.util.List;
import java.util.Map;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/30
 * @Describe:
 */
public class RecyclerCommonAdapter extends BaseQuickAdapter<Map<String, Object>, BaseViewHolder> {


    public RecyclerCommonAdapter(int layoutResId, @Nullable List<Map<String, Object>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Map<String, Object> item) {
        helper.setText(R.id.tv_recy_item_1_desc, item.get("desc").toString());
        helper.setText(R.id.tv_recy_item_1_name, item.get("name").toString());
        helper.setImageResource(R.id.img_recy_item_1_pic, (Integer) item.get("pic"));
        helper.addOnClickListener(R.id.img_recy_item_1_pic);
        helper.addOnClickListener(R.id.tv_recy_item_1_name);
    }
}
