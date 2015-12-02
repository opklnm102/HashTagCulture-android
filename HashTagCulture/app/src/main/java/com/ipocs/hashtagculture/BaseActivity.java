package com.ipocs.hashtagculture;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dong on 2015-12-01.
 */
public class BaseActivity extends AppCompatActivity {

    protected static BackendHelper requestHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }
    }


}
