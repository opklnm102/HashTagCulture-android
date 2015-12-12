package com.ipocs.hashtagculture.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ipocs.hashtagculture.util.BackendHelper;

/**
 * Created by Dong on 2015-12-01.
 */
public class BaseActivity extends AppCompatActivity {

    protected static BackendHelper requestHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }
    }


}
