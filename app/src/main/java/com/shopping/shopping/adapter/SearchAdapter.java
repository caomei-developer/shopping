package com.shopping.shopping.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.shopping.shopping.model.Search;
import com.shopping.shopping.model.SearchBean;
import com.shopping.shopping.model.SearchResponse;
import com.shopping.view.recyclerview.view.adapter.BaseViewHolder;
import com.shopping.view.recyclerview.view.adapter.RecyclerAdapter;

public class SearchAdapter extends RecyclerAdapter<SearchBean.DataBean> {

    public SearchAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<SearchBean.DataBean> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new SearchHolder(parent);
    }
}
