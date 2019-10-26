package com.example.flycotablayoutapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SlidingTabLayout tablayout;
    ViewPager viewPager;

    private ArrayList<MyBaseFragment> mFagments = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};

    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tablayout = findViewById(R.id.shape_table_layout);
        viewPager = findViewById(R.id.view_pager);
        mFagments.add(new Fragment1());
        mFagments.add(new Fragment1());
        mFagments.add(new Fragment1());
        mFagments.add(new Fragment1());
        // getChildFragmentManager() 如果是嵌套在fragment中实现就要用这个
        // 在activity中FragmentManager通过getSupportFragmentManager()去获取，如果在是在fragment中就需要通过getChildFragmentManager()去说去
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setViewPager(viewPager, mTitles);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFagments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFagments.get(position);
        }
    }
}
