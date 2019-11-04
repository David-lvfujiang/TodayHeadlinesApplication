package com.example.flycotablayoutapplication.fragment;

import android.util.Log;
import android.widget.TextView;

import com.example.flycotablayoutapplication.R;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/25
 * @Describe:
 */
public class Fragment1 extends MyBaseFragment {
    TextView  textView;
    @Override
    protected int getContentViewId() {
        return R.layout.fragment1_layout;
    }

    @Override
    protected void lazyLoad() {
            Log.e("fragment1", "fragment1");
        try {
            Thread.sleep(5000);
            textView  = mRootView.findViewById(R.id.text_name);
            textView.setText("哈哈哈哈");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initData() {

    }
}
