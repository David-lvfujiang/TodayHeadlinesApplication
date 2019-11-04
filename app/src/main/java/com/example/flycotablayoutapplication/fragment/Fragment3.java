package com.example.flycotablayoutapplication.fragment;

import android.util.Log;

import com.example.flycotablayoutapplication.R;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/28
 * @Describe:
 */
public class Fragment3 extends MyBaseFragment {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment3_layout;
    }
    @Override
    protected void initData() {
    }
    @Override
    protected void lazyLoad() {

            Log.e("fragment3", "fragment3");
    }
}
