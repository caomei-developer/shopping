package com.shopping.api;


import com.shopping.shopping.model.Search;
import com.shopping.shopping.model.SearchBean;
import com.shopping.shopping.model.SearchResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    String API_BASE_URL = "http://103.46.128.41:15342";

    @GET("/index.php?app=search2&")
    Observable<SearchBean> getLoadSearchList(@Query("keyword")String search, @Query("page") int page);

}
