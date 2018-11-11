package com.shopping.shopping.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shopping.R;
import com.shopping.application.Application;
import com.shopping.shopping.model.Search;
import com.shopping.shopping.model.SearchBean;
import com.shopping.util.FastJsonUtil;
import com.shopping.util.StringUtils;
import com.shopping.util.image.CommonImageLoader;
import com.shopping.util.image.listener.ImageLoaderListener;
import com.shopping.view.recyclerview.view.adapter.BaseViewHolder;
import com.shopping.view.recyclerview.view.util.LogUtils;

public class SearchHolder extends BaseViewHolder<SearchBean.DataBean>{
    private ImageView searchGoodsImage;
    private TextView searchGoodsName,storeName;

    public SearchHolder(ViewGroup itemView) {
        super(itemView,R.layout.search_adapter_item);
    }


    @Override
    public void setData(final SearchBean.DataBean data) {
        super.setData(data);
        if (data != null && !StringUtils.isEmpty(data.getDefault_image())){
            Glide.with(Application.application).load(data.getDefault_image()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(searchGoodsImage);
            searchGoodsName.setText(data.getGoods_name());
            storeName.setText(data.getStore_name());
        }
    }

    @Override
    public void onInitializeView() {
        super.onInitializeView();
        searchGoodsImage = findViewById(R.id.search_goods_image);
        searchGoodsName = findViewById(R.id.search_goods_name);
        storeName = findViewById(R.id.store_name);
    }


    @Override
    public void onItemViewClick(SearchBean.DataBean data) {
        super.onItemViewClick(data);
        LogUtils.log("zw",FastJsonUtil.parseToJSON(data));
    }
}
