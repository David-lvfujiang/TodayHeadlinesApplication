package com.example.flycotablayoutapplication.fragment;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.flycotablayoutapplication.CustPagerTransformer;
import com.example.flycotablayoutapplication.MainActivity;
import com.example.flycotablayoutapplication.R;
import com.example.flycotablayoutapplication.adapter.MyPagerAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/28
 * @Describe:
 */
public class Fragment2 extends MyBaseFragment {
    ArrayList<MyBaseFragment> mFagments;
    SlidingTabLayout tablayout;
    private String[] mTitles = {"关注", "视频", "热点", "问答","娱乐"};

    @Override
    protected int getContentViewId() {
        return R.layout.fragment2_layout;
    }

    @Override
    protected void lazyLoad() {
            Log.e("fragment2", "fragment2");
    }
    @Override
    protected void initData() {
        final ViewPager viewPager = mRootView.findViewById(R.id.view_pager2);
        tablayout = mRootView.findViewById(R.id.shape_table_layout);

        mFagments = new ArrayList<>();
        mFagments.add(new Fragment2Item1());
        mFagments.add(new Fragment2Item2());
        mFagments.add(new Fragment2Item3());
        mFagments.add(new Fragment2Item4());
        mFagments.add(new Fragment2Item5());
        // 在activity中FragmentManager通过getSupportFragmentManager()去获取，如果在是在fragment中就需要通过getChildFragmentManager()去说去
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(),mFagments,mTitles);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, new CustPagerTransformer(getActivity()));
        tablayout.setViewPager(viewPager, mTitles);

    }


}
