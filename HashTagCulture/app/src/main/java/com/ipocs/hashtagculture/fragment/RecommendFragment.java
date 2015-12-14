package com.ipocs.hashtagculture.fragment;


import android.content.Context;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipocs.hashtagculture.adapter.RecommendAdapter;
import com.ipocs.hashtagculture.model.Culture;
import com.ipocs.hashtagculture.R;
import com.ipocs.hashtagculture.utils.SpacesItemDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecommendFragment extends BaseFragment {

    public static final String TAG = RecommendFragment.class.getSimpleName();

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

        Log.e("fragment", TAG +  " onViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragment", TAG +  " onAttach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("fragment", TAG +  " onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("fragment", TAG +  " onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("fragment", TAG +  " onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragment", TAG +  " onResume");
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
}
