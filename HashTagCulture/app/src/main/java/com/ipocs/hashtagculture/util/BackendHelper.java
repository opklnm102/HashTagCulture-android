package com.ipocs.hashtagculture.util;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Dong on 2015-12-01.
 */
public class BackendHelper {

    private static final String endPoint = "";
    private static BackendHelper instance;
    private BackendService service;

    public static BackendHelper getInstance(){
        synchronized (BackendHelper.class) {
            if (instance == null) {
                instance = new BackendHelper();
            }
            return instance;
        }
    }

    private BackendHelper(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(endPoint)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        service = retrofit.create(BackendService.class);
    }

    //Todo: api구현

}
