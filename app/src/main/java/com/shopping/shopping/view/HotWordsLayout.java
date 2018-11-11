package com.shopping.shopping.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shopping.R;
import com.shopping.shopping.adapter.HotWordsAdapter;

import java.util.ArrayList;
import java.util.List;


public class HotWordsLayout extends LinearLayout{
    private Context context;
    private HotWordsAdapter hotWordsAdapter;
    private RecyclerView recyclerView;
    private List<String>list;

    public HotWordsLayout(Context context) {
        super(context);
        list = new ArrayList<>();
        this.context =context;
    }

    private void init() {
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(lp);
        inflate(context, R.layout.hot_words_layout, this);
        initView();
    }


    private void initView() {
        hotWordsAdapter  =new HotWordsAdapter(context);
        recyclerView = findViewById(R.id.hot_words_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(hotWordsAdapter);
        hotWordsAdapter.setData(list);

        hotWordsAdapter.setClickItem(new HotWordsAdapter.ClickItem() {
            @Override
            public void onClick(String value) {
                clickItem.onClick(value);
            }
        });
    }

    public void serData(List<String> list){
        this.list = list;
    }


    public interface ClickItem{
        void onClick(String value);
    }

    public ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }
}
