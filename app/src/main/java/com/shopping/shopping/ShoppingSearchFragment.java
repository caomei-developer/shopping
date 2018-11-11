package com.shopping.shopping;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shopping.R;
import com.shopping.base.CommonBaseFragment;
import com.shopping.shopping.adapter.SearchAdapter;
import com.shopping.shopping.model.SearchBean;
import com.shopping.shopping.presenter.ShoppingPresenter;
import com.shopping.shopping.view.ShoppingSearchView;
import com.shopping.util.StringUtils;
import com.shopping.view.recyclerview.view.RefreshRecyclerView;
import com.shopping.view.recyclerview.view.adapter.Action;


public class ShoppingSearchFragment extends CommonBaseFragment<ShoppingPresenter> implements ShoppingSearchView, View.OnClickListener {
    private RefreshRecyclerView refreshRecyclerView;
    private LinearLayout searchBtn;
    private TextView searchKey;
    private SearchAdapter searchAdapter;
    private int page = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shopping_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshRecyclerView = view.findViewById(R.id.refresh_recyclerView);
        searchBtn = view.findViewById(R.id.search_btn);
        searchKey = view.findViewById(R.id.search_key);
        refreshRecyclerView.setSwipeRefreshColors(0xFF437845,0xFFE44F98,0xFF2FAC21);
        searchBtn.setOnClickListener(this);
        refreshRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        searchAdapter = new SearchAdapter(getActivity());
        refreshRecyclerView.setAdapter(searchAdapter);
        refreshRecyclerView.addRefreshAction(new Action() {
            @Override
            public void onAction() {
                mvpPresenter.checkObtainMode(ShoppingPresenter.isType.PULL_UP_REFRESH,"手机",1);
                refreshRecyclerView.getSwipeRefreshLayout().setRefreshing(false);
            }
        });
        refreshRecyclerView.addLoadMoreAction(new Action() {
            @Override
            public void onAction() {
                page ++;
                mvpPresenter.checkObtainMode(ShoppingPresenter.isType.PULL_DOWN,"手机",page);
            }
        });
    }

    private String keyWord(){
        String keyWord = searchKey.getText().toString();
        return StringUtils.isEmpty(keyWord) ? null : keyWord;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_btn:
                if (StringUtils.isEmpty(keyWord())) {
                    return;
                }
                mvpPresenter.getLoadGoodsSearch(ShoppingPresenter.isType.LOADING, "手机", 1);
                break;
        }
    }

    @Override
    protected ShoppingPresenter createPresenter() {
        return new ShoppingPresenter(this);
    }

    @Override
    public void getDataSuccess(SearchBean searchBean) {
        if (searchBean.getStatus().equals("404")){
            return;
        }
        if (searchBean.getData()!= null) {
            searchAdapter.addAll(searchBean.getData());
            searchAdapter.notifyDataSetChanged();
        }
        Log.e("请求","is null");
    }

    @Override
    public void getPullDownData(SearchBean searchBean) {
        if (searchBean.getStatus().equals("404")){
            refreshRecyclerView.showNoMore();
            return;
        }
        searchAdapter.addAll(searchBean.getData());
        Log.e("上拉","is null");
    }

    @Override
    public void getPullUpRefresh(SearchBean searchBean) {
        if (searchBean.getStatus().equals("404")){
            return;
        }
        searchAdapter.clear();
        searchAdapter.addAll(searchBean.getData());
        searchAdapter.notifyDataSetChanged();
        Log.e("刷新","is null");

    }

    @Override
    public void getDataFail(String msg) {
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!StringUtils.isEmpty(keyWord())){
            searchKey.setText("");
        }
    }
}
