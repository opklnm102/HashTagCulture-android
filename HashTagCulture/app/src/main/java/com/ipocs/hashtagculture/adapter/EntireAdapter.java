package com.ipocs.hashtagculture.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ipocs.hashtagculture.model.Culture;
import com.ipocs.hashtagculture.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dong on 2015-12-01.
 */
public class EntireAdapter extends RecyclerView.Adapter<EntireAdapter.EntireViewHolder> {

    public static final String TAG = EntireAdapter.class.getSimpleName();

    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    private ArrayList<Culture> mCultureArrayList;

    public EntireAdapter(Context context, ArrayList<Culture> cultureArrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mCultureArrayList = cultureArrayList;
    }

    @Override
    public EntireViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_enrite, parent, false);

        return new EntireViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EntireViewHolder holder, int position) {

        Culture item = mCultureArrayList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDateStart.setText(item.getStartDate());
        holder.tvDateEnd.setText(item.getEndDate());

        if(item.getImgSumnailUrl() != null){    //이미지 url
            Uri uri = Uri.parse("http://www.culture.go.kr/upload/rdf/1435908782387o%EB%B3%91%EC%82%AC%EC%9D%B4%EC%95%BC%EA%B8%B0_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg");
            holder.ivSumnail.setImageURI(uri);
        }else{
            Uri uri = Uri.parse("http://www.culture.go.kr/upload/rdf/1435908782387o%EB%B3%91%EC%82%AC%EC%9D%B4%EC%95%BC%EA%B8%B0_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg");
            holder.ivSumnail.setImageURI(uri);
        }

    }

    @Override
    public int getItemCount() {
        return mCultureArrayList.size();
    }

    public static class EntireViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.textView_title)
        TextView tvTitle;
        @Bind(R.id.imageView_sumnail)
        SimpleDraweeView ivSumnail;
        @Bind(R.id.textView_date_start)
        TextView tvDateStart;
        @Bind(R.id.textView_date_end)
        TextView tvDateEnd;

        View mView;

        public EntireViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }
}
