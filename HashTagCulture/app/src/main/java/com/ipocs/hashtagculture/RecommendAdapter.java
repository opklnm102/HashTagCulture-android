package com.ipocs.hashtagculture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dong on 2015-12-01.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {

    public static final String TAG = RecommendAdapter.class.getSimpleName();

    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    private ArrayList<Culture> mCultureArrayList;

    public RecommendAdapter(Context context, ArrayList<Culture> cultureArrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mCultureArrayList = cultureArrayList;
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_recommend, parent, false);

        return new RecommendViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder holder, int position) {

        Culture item = mCultureArrayList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDateStart.setText(item.getStartDate());
        holder.tvDateEnd.setText(item.getEndDate());
//        holder.ivSumnail.setImageResource(item.getImgSumnailUrl());  //이미지 url

        ArrayList<String> hashTags = item.getHashTag();

        for(int i=0; i<hashTags.size(); i++){
            TextView hashTag = new TextView(mContext);
//            hashTag.set  //크기 정하기
//            hashTag.setText("#" + hashTags.get(i));
//            holder.linearHashtag.addView(hashTag);
        }

    }

    @Override
    public int getItemCount() {
        return mCultureArrayList.size();
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.textView_title)
        TextView tvTitle;
        @Bind(R.id.imageView_sumnail)
        ImageView ivSumnail;
        @Bind(R.id.textView_date_start)
        TextView tvDateStart;
        @Bind(R.id.textView_date_end)
        TextView tvDateEnd;
        @Bind(R.id.container_hashTag)
        LinearLayout linearHashtag;

        View mView;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }
}
