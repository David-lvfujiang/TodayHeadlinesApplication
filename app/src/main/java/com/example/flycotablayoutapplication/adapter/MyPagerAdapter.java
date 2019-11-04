package com.example.flycotablayoutapplication.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.flycotablayoutapplication.fragment.MyBaseFragment;

import java.util.ArrayList;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/28
 * @Describe:
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private  ArrayList<MyBaseFragment> mFragments;
    private String[] mTitles;
    public MyPagerAdapter(FragmentManager fm, ArrayList mFragments,String[] mTitles )
    {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
