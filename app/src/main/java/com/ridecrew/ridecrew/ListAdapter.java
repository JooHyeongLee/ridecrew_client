package com.ridecrew.ridecrew;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by JooHyeong on 2017. 12. 23..
 */

public class ListAdapter extends RecyclerView.Adapter{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mContentsText;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mContentsText = (TextView)itemView.findViewById(R.id.contents);
            itemView.setOnClickListener(this);

        }
        public void bindView(int position) {
            mTitleText.setText(OurData.title[position]);
            mContentsText.setText(OurData.contents[position]);
        }
        public void onClick(View view){

        }
    }
}
