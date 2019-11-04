package com.example.flycotablayoutapplication.fragment;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.flycotablayoutapplication.R;
import com.example.flycotablayoutapplication.adapter.MultipleItemAdapter;
import com.example.flycotablayoutapplication.adapter.RecyclerCommonAdapter;
import com.example.flycotablayoutapplication.model.MyMultipleItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/10/28
 * @Describe:
 */
public class Fragment2Item1 extends MyBaseFragment {
    RecyclerView recyclerView;
    List<MyMultipleItem> lineData;
    MultipleItemAdapter adapter;
    int[] pics = {
            R.mipmap.bjx,
            R.mipmap.cq,
            R.mipmap.bm,
            R.mipmap.ds,
            R.mipmap.hl,
            R.mipmap.mm,
    };

    String[] names = {
            "北极熊",
            "狗",
            "白马",
            "袋鼠",
            "狐狸",
            "小猫咪",

    };

    @Override
    protected int getContentViewId() {

        return R.layout.fragment2_layout_item1;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initData() {
        recyclerView = mRootView.findViewById(R.id.recyclear_view);
        lineData = new ArrayList<>();
        addData();
        // 设置为线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // 设置适配器
        //recyclerView.setAdapter(new RecyclerLineAdapter(getContext(), lineData));
        //adapter = new RecyclerCommonAdapter(R.layout.recyclear_item, lineData);
        adapter = new MultipleItemAdapter(lineData);
        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        //上拉监听
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Toast.makeText(getActivity(), "正在加载", Toast.LENGTH_SHORT).show();
                addData();
                adapter.loadMoreComplete();
            }
        }, recyclerView);
        //item监听
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "点击了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();

            }
        });
        //item子view
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_recy_item_1_name:
                        Toast.makeText(getActivity(), "点击了第" + (position + 1) + "名字", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.img_recy_item_1_pic:
                        Toast.makeText(getActivity(), "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        });
        recyclerView.setAdapter(adapter);

    }

    private void addData() {
        Map<String, Object> map = null;
        Random random = new Random();
        for (int i = 0; i < names.length; i++) {

            map = new HashMap<>();
            map.put("pic", pics[i]);
            map.put("name", names[i]);
            map.put("desc", "我是一只" + names[i]);
            if (i % 2 == 0) {
                lineData.add(new MyMultipleItem(1, map));
            } else {
                lineData.add(new MyMultipleItem(2, map));

            }
        }
    }
}
