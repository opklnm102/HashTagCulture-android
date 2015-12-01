package com.ipocs.hashtagculture;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecommendFragment extends Fragment {

    @Bind(R.id.recyclerView_recommend)
    RecyclerView rvRecommend;

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

        for(int i=0; i<10; i++){
            ArrayList<String> strings = new ArrayList<>();
            Culture culture = new Culture("한국 피아노 협회공연","fdfd","2015-12-22","2015-12-25",strings, false);
            mCultureArrayList.add(culture);
        }

        mRecommendAdapter = new RecommendAdapter(getActivity(), mCultureArrayList);

        rvRecommend.setAdapter(mRecommendAdapter);
        rvRecommend.setHasFixedSize(true);
        rvRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecommend.addItemDecoration(new SpacesItemDecoration(24));
    }
}
