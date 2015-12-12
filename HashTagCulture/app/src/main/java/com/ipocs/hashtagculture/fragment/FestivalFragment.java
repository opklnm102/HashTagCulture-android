package com.ipocs.hashtagculture.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ipocs.hashtagculture.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FestivalFragment extends BaseFragment {

    public static final String TAG = FestivalFragment.class.getSimpleName();

    @Bind(R.id.tabLayout_menu)
    TabLayout mTabLayoutMenu;

    @Bind(R.id.fragment_container_festival)
    FrameLayout fLayoutFragmentContainer;

    FragmentManager fm;

    public static FestivalFragment newInstance() {
        FestivalFragment fragment = new FestivalFragment();
        return fragment;
    }

    public FestivalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_festival, container, false);
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

                Fragment oldFragment = fm.findFragmentById(R.id.fragment_container_festival);

                switch (tab.getPosition()) {
                    case 0:
                        if (!(oldFragment instanceof RecommendFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_festival, RecommendFragment.newInstance()).commit();
                        }
                        break;
                    case 1:
                        if (!(oldFragment instanceof EntireFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_festival, EntireFragment.newInstance()).commit();
                        }
                        break;
                    case 2:
                        if (!(oldFragment instanceof TalkFragment)) {
                            fm.beginTransaction().replace(R.id.fragment_container_festival, TalkFragment.newInstance()).commit();
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
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_festival);

        if (fragment == null) {
            fragment = createFragment();

            fm.beginTransaction().add(R.id.fragment_container_festival, fragment).commit();
        }
    }

    public Fragment createFragment() {
        return RecommendFragment.newInstance();
    }
}
