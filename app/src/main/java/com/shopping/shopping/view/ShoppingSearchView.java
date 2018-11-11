package com.shopping.shopping.view;

import com.shopping.mvp.BaseView;
import com.shopping.shopping.model.Search;
import com.shopping.shopping.model.SearchBean;
import com.shopping.shopping.model.SearchResponse;

import java.util.List;

public interface ShoppingSearchView extends BaseView{
    void getDataSuccess(SearchBean searchResponse);

    void getDataFail(String msg);

    void getPullDownData(SearchBean searchResponse);

    void getPullUpRefresh(SearchBean searchResponse);

}

