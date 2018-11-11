package com.shopping.shopping.presenter;

import com.shopping.callback.ApiCallback;
import com.shopping.api.API;
import com.shopping.http.RetrofitHelper;
import com.shopping.mvp.BasePresenter;
import com.shopping.shopping.model.Search;
import com.shopping.shopping.model.SearchBean;
import com.shopping.shopping.model.SearchResponse;
import com.shopping.shopping.view.ShoppingSearchView;

import java.util.List;


public class ShoppingPresenter extends BasePresenter<ShoppingSearchView> {

    public ShoppingPresenter(ShoppingSearchView view) {
        attachView(view);
    }

    public void getLoadGoodsSearch(isType type, String searchValue, int page){
        mvpView.showLoading();
        checkObtainMode(type,searchValue,page);
    }

    public void checkObtainMode(final isType type, String searchValue , int page){
        addSubscription(getApi().getLoadSearchList(searchValue,page), new ApiCallback<SearchBean>() {
            @Override
            public void onSuccess(SearchBean model) {
                switch (type){
                    case LOADING:
                        mvpView.getDataSuccess(model);
                        break;
                    case PULL_DOWN:
                        mvpView.getPullDownData(model);
                        break;
                    case PULL_UP_REFRESH:
                        mvpView.getPullUpRefresh(model);
                        break;
                }
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

    public void getHotWords(){
        addSubscription(getApi().getHotWords(), new ApiCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> model) {
            mvpView.getHotWords(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }


    private API getApi(){
        return  RetrofitHelper.retrofit(API.API_BASE_URL).create(API.class);
    }


    public enum isType{
        LOADING,
        PULL_DOWN,
        PULL_UP_REFRESH,
    }
}
