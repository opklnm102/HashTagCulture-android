package com.ipocs.hashtagculture.fragment;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ipocs.hashtagculture.adapter.RecommendAdapter;
import com.ipocs.hashtagculture.model.Culture;
import com.ipocs.hashtagculture.R;
import com.ipocs.hashtagculture.utils.SpacesItemDecoration;
import com.ipocs.hashtagculture.widget.SelectTextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecommendFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @Bind(R.id.recyclerView_recommend)
    RecyclerView rvRecommend;

    @Bind(R.id.imageView_tag_show)
    ImageView ivTagShow;

    @Bind(R.id.linearLayout_tag)
    LinearLayout linearTag;

    @Bind(R.id.relativeLayout_tag)
    RelativeLayout relativeTag;

    @Bind(R.id.textView_tag_music)
    SelectTextView tvTagMusic;

    @Bind(R.id.textView_tag_concert)
    SelectTextView tvTagConcert;

    @Bind(R.id.textView_tag_theater)
    SelectTextView tvTagTheater;

    @Bind(R.id.textView_tag_gukak)
    SelectTextView tvTagGukak;

    @Bind(R.id.textView_tag_art)
    SelectTextView tvTagArt;

    @Bind(R.id.textView_tag_etc)
    SelectTextView tvTagEtc;

    boolean tagShowFlag = false;

    ArrayList<Culture> mCultureArrayList;
    RecommendAdapter mRecommendAdapter;

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    public RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCultureArrayList = new ArrayList<>();

//        for(int i=0; i<10; i++){
//            ArrayList<String> strings = new ArrayList<>();
//            Culture culture = new Culture("한국 피아노 협회공연","fdfd","2015-12-22","2015-12-25",strings, false);
//            mCultureArrayList.add(culture);
//        }

        mRecommendAdapter = new RecommendAdapter(getActivity(), mCultureArrayList);

        rvRecommend.setAdapter(mRecommendAdapter);
        rvRecommend.setHasFixedSize(true);
        rvRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecommend.addItemDecoration(new SpacesItemDecoration(24));

        Log.e("fragment", TAG + " onViewCreated");

        relativeTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tagShowFlag = !tagShowFlag;

                if (tagShowFlag) {
                    linearTag.setVisibility(View.VISIBLE);
                    ivTagShow.setImageResource(android.R.drawable.arrow_up_float);

                } else {
                    linearTag.setVisibility(View.GONE);
                    ivTagShow.setImageResource(android.R.drawable.arrow_down_float);
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragment", TAG + " onAttach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("fragment", TAG + " onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("fragment", TAG + " onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("fragment", TAG + " onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragment", TAG + " onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("fragment", TAG + " onPause");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("fragment", TAG + " onPause");
    }

    @OnClick({R.id.textView_tag_music, R.id.textView_tag_concert, R.id.textView_tag_theater, R.id.textView_tag_gukak, R.id.textView_tag_art, R.id.textView_tag_etc})
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.textView_tag_music:
                tvTagMusic.setSelect(!tvTagMusic.getSelect());
                if(tvTagMusic.getSelect()){
                    tvTagMusic.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagMusic.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
            case R.id.textView_tag_concert:
                tvTagConcert.setSelect(!tvTagConcert.getSelect());
                if(tvTagConcert.getSelect()){
                    tvTagConcert.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagConcert.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
            case R.id.textView_tag_theater:
                tvTagTheater.setSelect(!tvTagTheater.getSelect());
                if(tvTagTheater.getSelect()){
                    tvTagTheater.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagTheater.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
            case R.id.textView_tag_gukak:
                tvTagGukak.setSelect(!tvTagGukak.getSelect());
                if(tvTagGukak.getSelect()){
                    tvTagGukak.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagGukak.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
            case R.id.textView_tag_art:
                tvTagArt.setSelect(!tvTagArt.getSelect());
                if(tvTagArt.getSelect()){
                    tvTagArt.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagArt.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
            case R.id.textView_tag_etc:
                tvTagEtc.setSelect(!tvTagEtc.getSelect());
                if(tvTagEtc.getSelect()){
                    tvTagEtc.setBackgroundResource(R.drawable.category_shape_select);
                }else{
                    tvTagEtc.setBackgroundResource(R.drawable.category_shape_normal);
                }
                break;
        }
    }
}
