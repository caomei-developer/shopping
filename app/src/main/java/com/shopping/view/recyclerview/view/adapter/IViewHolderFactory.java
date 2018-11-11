package com.shopping.view.recyclerview.view.adapter;

import android.view.ViewGroup;

public interface IViewHolderFactory {

    <V extends BaseViewHolder> V getViewHolder(ViewGroup parent, int viewType);
}
