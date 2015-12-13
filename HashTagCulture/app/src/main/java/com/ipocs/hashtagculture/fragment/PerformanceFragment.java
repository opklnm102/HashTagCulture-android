package com.ipocs.hashtagculture.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ipocs.hashtagculture.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PerformanceFragment extends BaseFragment {

    public static final String TAG = PerformanceFragment.class.getSimpleName();

    @Bind(R.id.tabLayout_menu)
    TabLayout mTabLayoutMenu;

    @Bind(R.id.fragment_container_performance)
    FrameLayout fLayoutFragmentContainer;

    FragmentManager fm;
    ArrayList<BaseFragment> mBaseFragments;

    public static PerformanceFragment newInstance() {
        PerformanceFragment fragment = new PerformanceFragment();
        return fragment;
    }

    public PerformanceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_performance, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayoutMenu.addTab(mTabLayoutMenu.newTab().setText("추천"));
        mTabLayoutMenu.addTab(mTabLayoutMenu.newTab().setText("전체"));
        mTabLayoutMenu.addTab(mTabLayoutMenu.newTab().setText("톡"));

        mTabLayoutMenu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e(TAG, " " + tab.getPosition());

                Fragment oldFragment = fm.findFragmentById(R.id.fragment_container_performance);

                switch (tab.getPosition()) {
                    case 0:
                        if (!(oldFragment instanceof RecommendFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(0)).commit();
                        }
                        break;
                    case 1:
                        if (!(oldFragment instanceof EntireFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(1)).commit();
                        }
                        break;
                    case 2:
                        if (!(oldFragment instanceof TalkFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(2)).commit();
                        }
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        fm = getActivity().getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_performance);

        if (fragment == null) {
            createFragment();
            Log.e("fragment", TAG + " createFragment if");

            switch (mTabLayoutMenu.getSelectedTabPosition()) {
                case 0:
                    fm.beginTransaction().add(R.id.fragment_container_performance, mBaseFragments.get(0)).commit();
                    break;
                case 1:
                    fm.beginTransaction().add(R.id.fragment_container_performance, mBaseFragments.get(1)).commit();
                    break;
                case 2:
                    fm.beginTransaction().add(R.id.fragment_container_performance, mBaseFragments.get(2)).commit();
                    break;
            }
        } else {
            Log.e("fragment", TAG + " createFragment else");
            Log.e("fragment", TAG + " " + fragment.getClass().getSimpleName());
            switch (mTabLayoutMenu.getSelectedTabPosition()) {
                case 0:
                    Log.e("fragment", TAG + " createFragment else 0");
                    if (!(fragment instanceof RecommendFragment)) {
                        fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(0)).commit();
                    }
                    break;
                case 1:
                    Log.e("fragment", TAG + " createFragment else 1");
                    if (!(fragment instanceof EntireFragment)) {
                        fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(1)).commit();
                    }
                    break;
                case 2:
                    if (!(fragment instanceof TalkFragment)) {
                        fm.beginTransaction().replace(R.id.fragment_container_performance, mBaseFragments.get(2)).commit();
                    }
                    break;
            }
        }
        Log.e("fragment", TAG + " onViewCreated");
    }

    public void createFragment() {

        mBaseFragments = new ArrayList<>();

        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        recommendFragment.setTitle("추천");
        EntireFragment entireFragment = EntireFragment.newInstance();
        entireFragment.setTitle("전체");
        TalkFragment talkFragment = TalkFragment.newInstance();
        talkFragment.setTitle("톡");

        mBaseFragments.add(recommendFragment);
        mBaseFragments.add(entireFragment);
        mBaseFragments.add(talkFragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragment", TAG + " onAttach");
    }

    @Override
    public void onDestroyView() {
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_performance);
        if(fragment != null){
            Log.e("fragment", TAG + " onDestroyView " + fragment.getClass().getSimpleName());
            fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
        super.onDestroyView();
        Log.e("fragment", TAG + " onDestroyView");
    }

    public void removeFragment(){
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_performance);
        if(fragment != null){
            Log.e("fragment", TAG + " onDestroyView " + fragment.getClass().getSimpleName());
            fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onDetach() {
        Log.e("fragment", TAG + " onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.e("fragment", TAG + " onDestroy");
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragment", TAG + " onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("fragment", TAG + " onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e("fragment", TAG + " onViewStateRestored");
    }
}
