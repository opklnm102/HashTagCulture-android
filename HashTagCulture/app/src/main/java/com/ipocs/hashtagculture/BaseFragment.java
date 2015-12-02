package com.ipocs.hashtagculture;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Dong on 2015-12-01.
 */
public class BaseFragment extends Fragment {

    private BaseActivity hostActivity;

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
