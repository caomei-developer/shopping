package com.shopping;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shopping.base.TabActivity;
import com.shopping.shopping.ShoppingSearchFragment;
import com.shopping.util.CompatUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends TabActivity {
    private List<TabItem> tabItemList = new ArrayList<>();

    private List<PagerFragment> viewPagerFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewPager();
    }

    @Override
    public void initView() {
        super.initView();
        tabItemList.add(new TabItem("首页", CompatUtil.getDrawable(this, R.mipmap.wallpaper_default),
                CompatUtil.getDrawable(this, R.mipmap.wallpaper_select), false));

        tabItemList.add(new TabItem("消息", CompatUtil.getDrawable(this, R.mipmap.comic_default),
                CompatUtil.getDrawable(this, R.mipmap.comic_select), false));

        tabItemList.add(new TabItem("购物车", CompatUtil.getDrawable(this, R.mipmap.find_default),
                CompatUtil.getDrawable(this, R.mipmap.find_select), false));

        tabItemList.add(new TabItem("我的", CompatUtil.getDrawable(this, R.mipmap.account_default),
                CompatUtil.getDrawable(this, R.mipmap.account_select), false));
        setTabItemList(tabItemList);
    }
    private void initViewPager() {
        Bundle bundle = new Bundle();
        viewPagerFragmentList.add(new PagerFragment(ShoppingSearchFragment.class, bundle));
        viewPagerFragmentList.add(new PagerFragment(ShoppingSearchFragment.class, bundle));
        viewPagerFragmentList.add(new PagerFragment(ShoppingSearchFragment.class, bundle));
        viewPagerFragmentList.add(new PagerFragment(ShoppingSearchFragment.class, bundle));
        setPagerFragmentList(viewPagerFragmentList);
        viewPager.setOffscreenPageLimit(3);
    }

    @Override
    protected String getToolbarTitle() {
        return null;
    }

    @Override
    protected boolean isDisplayToolbar() {
        return false;
    }


}
