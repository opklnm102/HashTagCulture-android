package com.ipocs.hashtagculture.utils;

import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Created by Dong on 2015-12-01.
 */
public class BackendHelper {

    private static final String endPoint = "http://hashtagculture.herokuapp.com";
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BackendService.class);
    }

    //Todo: api구현

    //전체 공연 정보
    public Call<JsonArray> getPerformanceEntire(){
        return service.getPerformanceEntire();
    }



}
