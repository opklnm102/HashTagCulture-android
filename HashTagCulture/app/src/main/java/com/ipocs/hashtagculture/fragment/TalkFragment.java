package com.ipocs.hashtagculture.fragment;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipocs.hashtagculture.R;

import butterknife.ButterKnife;


public class TalkFragment extends BaseFragment {

    public static final String TAG = TalkFragment.class.getSimpleName();

    public static TalkFragment newInstance() {
        TalkFragment fragment = new TalkFragment();
        return fragment;
    }

    public TalkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talk, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("fragment", TAG + " onViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragment", TAG + " onAttach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("fragment", TAG +  " onDestroyView");
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
}
