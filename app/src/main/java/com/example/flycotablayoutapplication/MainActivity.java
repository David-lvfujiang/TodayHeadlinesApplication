package com.example.flycotablayoutapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.flycotablayoutapplication.adapter.MyPagerAdapter;
import com.example.flycotablayoutapplication.fragment.Fragment1;
import com.example.flycotablayoutapplication.fragment.Fragment2;
import com.example.flycotablayoutapplication.fragment.Fragment3;
import com.example.flycotablayoutapplication.fragment.MyBaseFragment;
import com.example.flycotablayoutapplication.model.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    RelativeLayout relativeLayout;
    NavigationView navigationView;
    ViewPager mViewPager;
    CommonTabLayout commonTabLayout;
    private ArrayList<MyBaseFragment> mFagments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private String[] mTitles = {"首页", "小视频", "我的"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    /**
     * 初始化底部导航栏的数据
     */
    public void initTab() {
        for (String mTitle : mTitles) {
            if ("首页".equals(mTitle)) {
                //后面两个值是选中图标和未选中(R.drawable.xxx)不要图标就填0
                mTabEntities.add(new TabEntity(mTitle, R.mipmap.home_select_icon, R.mipmap.home_unselect_icon));
            } else if ("小视频".equals(mTitle)) {
                mTabEntities.add(new TabEntity(mTitle, R.mipmap.video_select_icon, R.mipmap.video_unselect_icon));
            } else if ("我的".equals(mTitle)) {
                mTabEntities.add(new TabEntity(mTitle, R.mipmap.my_select_icon, R.mipmap.my_unselect_icon));
            }
        }
    }

   public void  drawerLayoutAddListener(){
       drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
           @Override
           public void onDrawerSlide(View drawerView, float slideOffset) {
               //获取屏幕的宽高
               WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
               Display display = manager.getDefaultDisplay();
               //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
               relativeLayout.layout(navigationView.getRight(), 0, navigationView.getRight() + display.getWidth(), display.getHeight());
           }
           @Override
           public void onDrawerOpened(View drawerView) {

           }
           @Override
           public void onDrawerClosed(View drawerView) {

           }
           @Override
           public void onDrawerStateChanged(int newState) {

           }
       });
   }
    private void initView() {
        drawerLayout = findViewById(R.id.drawerLayout);
        relativeLayout = findViewById(R.id.main_right);
        navigationView = findViewById(R.id.main_left);

        mViewPager = findViewById(R.id.view_pager);
        commonTabLayout = findViewById(R.id.tl_commen);
        //底部导航栏切换监听
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //根据position切换viewpager
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        //viewpager切换监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //根据position切换选择tablayout
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initDate() {
        drawerLayoutAddListener();
        initTab();
        mFagments.add(new Fragment2());
        mFagments.add(new Fragment1());
        mFagments.add(new Fragment3());
        //设置底部导航栏数据
        commonTabLayout.setTabData(mTabEntities);
        // 在activity中FragmentManager通过getSupportFragmentManager()去获取，如果在是在fragment中就需要通过getChildFragmentManager()去说去
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), mFagments, mTitles);
        mViewPager.setAdapter(adapter);
        // 设置commonTabLayout下标为0的item未读消息数
        setUnReadMessage(0, 32);

    }

    /**
     * 设置未读消息数
     *
     * @param item
     * @param number
     */
    public void setUnReadMessage(int item, int number) {
        commonTabLayout.showMsg(item, number);
    }


}
