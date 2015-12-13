package com.ipocs.hashtagculture.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ipocs.hashtagculture.activity.BaseActivity;
import com.ipocs.hashtagculture.util.BackendHelper;

/**
 * Created by Dong on 2015-12-01.
 */
public class BaseFragment extends Fragment {

    private BaseActivity hostActivity;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected static BackendHelper requestHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof BaseActivity){
            hostActivity = (BaseActivity)context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }
    }
}
