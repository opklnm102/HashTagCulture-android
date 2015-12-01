package com.ipocs.hashtagculture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EntireFragment extends Fragment {

    @Bind(R.id.recyclerView_entire)
    RecyclerView rvEntire;

    ArrayList<Culture> mCultureArrayList;
    EntireAdapter mEntireAdapter;


    public static EntireFragment newInstance() {
        EntireFragment fragment = new EntireFragment();
        return fragment;
    }

    public EntireFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entire, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCultureArrayList = new ArrayList<>();

        for(int i=0; i<20; i++){
            ArrayList<String> strings = new ArrayList<>();
            Culture culture = new Culture("한국 피아노 협회공연","fdfd","2015-12-22","2015-12-25",strings, false);
            mCultureArrayList.add(culture);
        }

        mEntireAdapter = new EntireAdapter(getActivity(), mCultureArrayList);

        rvEntire.setAdapter(mEntireAdapter);
        rvEntire.setHasFixedSize(true);
//        rvEntire.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvEntire.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        rvEntire.addItemDecoration(new SpacesItemDecoration(24));
    }
}
