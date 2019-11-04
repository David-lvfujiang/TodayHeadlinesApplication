package com.example.flycotablayoutapplication.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.flycotablayoutapplication.R;
import com.example.flycotablayoutapplication.model.MyMultipleItem;

import java.util.List;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/30
 * @Describe:
 */
public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<MyMultipleItem, BaseViewHolder> {

    public MultipleItemAdapter(List data) {
        super(data);
        //必须绑定type和layout的关系
        addItemType(MyMultipleItem.FIRST_TYPE, R.layout.recyclear_item);
        addItemType(MyMultipleItem.SECOND_TYPE, R.layout.recyclear_item1);


    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem item) {
        switch (helper.getItemViewType()) {
            case MyMultipleItem.FIRST_TYPE:
                Log.i("tag","FIRST_TYPE==============="+helper.getLayoutPosition());
                helper.setText(R.id.tv_recy_item_1_desc, item.getData().get("desc").toString());
                helper.setText(R.id.tv_recy_item_1_name, item.getData().get("name").toString());
                helper.setImageResource(R.id.img_recy_item_1_pic, (Integer) item.getData().get("pic"));
                helper.addOnClickListener(R.id.img_recy_item_1_pic);
                helper.addOnClickListener(R.id.tv_recy_item_1_name);
                break;
            case MyMultipleItem.SECOND_TYPE:
                Log.i("tag","SECOND_TYPE==============="+helper.getLayoutPosition());
                helper.setText(R.id.tv_recy_item_2_desc, item.getData().get("desc").toString());
                helper.setText(R.id.tv_recy_item_2_name, item.getData().get("name").toString());
                helper.setImageResource(R.id.img_recy_item_2_pic, (Integer) item.getData().get("pic"));
                helper.addOnClickListener(R.id.img_recy_item_2_pic);
                helper.addOnClickListener(R.id.tv_recy_item_2_name);
                break;
        }
    }
}

