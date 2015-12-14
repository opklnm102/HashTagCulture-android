package com.ipocs.hashtagculture.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ipocs.hashtagculture.model.Culture;
import com.ipocs.hashtagculture.R;
import com.ipocs.hashtagculture.utils.TimeUtils;

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
        holder.tvDateStart.setText(TimeUtils.UnixTimeStampToStringDate(item.getStartDate()));
        holder.tvDateEnd.setText(TimeUtils.UnixTimeStampToStringDate(item.getEndDate()));

        if (item.getMainPosterUrl() != null) {    //이미지 url
            Uri uri = Uri.parse(item.getMainPosterUrl());
            holder.ivSumnail.setImageURI(uri);
        } else {
            Uri uri = Uri.parse("http://www.culture.go.kr/upload/rdf/1435908782387o%EB%B3%91%EC%82%AC%EC%9D%B4%EC%95%BC%EA%B8%B0_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg");
            holder.ivSumnail.setImageURI(uri);
        }

//        ArrayList<String> hashTags = item.getHashTag();
//
//        for(int i=0; i<hashTags.size(); i++){
//            TextView hashTag = new TextView(mContext);
////            hashTag.set  //크기 정하기
////            hashTag.setText("#" + hashTags.get(i));
////            holder.linearHashtag.addView(hashTag);
//        }

    }

    @Override
    public int getItemCount() {
        return mCultureArrayList.size();
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.textView_title)
        TextView tvTitle;
        @Bind(R.id.imageView_sumnail)
        SimpleDraweeView ivSumnail;
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
