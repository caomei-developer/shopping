package com.shopping.shopping.model;

import com.shopping.http.Response;

import java.util.List;


public class SearchResponse extends Response {
    private List<Search> data;

    public List<Search> getList() {
        return data;
    }

    public void setList(List<Search> list) {
        this.data = list;
    }
}
