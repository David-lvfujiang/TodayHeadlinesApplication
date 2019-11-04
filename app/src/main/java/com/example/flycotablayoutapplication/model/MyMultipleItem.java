package com.example.flycotablayoutapplication.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Map;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/30
 * @Describe:
 */
public class MyMultipleItem implements MultiItemEntity {
    public static final int FIRST_TYPE = 1;
    public static final int SECOND_TYPE = 2;

    private int itemType;
    private Map<String, Object> data;

    public MyMultipleItem(int itemType, Map<String, Object> data) {
        this.itemType = itemType;
        this.data = data;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public Map<String, Object> getData(){
        return data;
    }
}
