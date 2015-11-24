package com.ipocs.hashtagculture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class EntireFragment extends Fragment {

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
}
