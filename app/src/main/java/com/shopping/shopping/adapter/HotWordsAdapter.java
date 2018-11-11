package com.shopping.shopping.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shopping.R;

import java.util.ArrayList;
import java.util.List;


public class HotWordsAdapter extends RecyclerView.Adapter<HotWordsAdapter.ViewHolder> {
    private Context context;

    private List<String> list;

    public HotWordsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotWordsAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.hot_hit_words_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).toString());
        if (clickItem != null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItem.onClick(list.get(position).toString());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.hot_hit_words);
        }
    }

    public void setData(List<String> list) {
        if (list == null || list.size() == 0 || list.isEmpty()){
            return;
        }
        this.list = list;
        notifyDataSetChanged();
    }

    public interface ClickItem{
        void onClick(String value);
    }


    private ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }
}
