package com.ipocs.hashtagculture.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

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

    /**
     *    Todo: api구현
     */

    //전체 공연 정보
    public Call<JsonArray> getPerformanceEntire(){
        return service.getPerformanceEntire();
    }

    //Todo: query parameter
    //추천 공연 정보
    public Call<JsonArray> getPerformanceRecommend(){
        return service.getPerformanceRecommend();
    }

    //상세 공연 정보
    public Call<JsonObject> getPerformanceDetail(Integer id){
        return service.getPerformanceDetail(id);
    }

    //전체 전시 정보
    public Call<JsonArray> getExhibitEntire(){
        return service.getExhibitEntire();
    }

    //Todo: query parameter
    //추천 전시 정보
    public Call<JsonArray> getExhibitRecommend(){
        return service.getExhibitRecommend();
    }

    //상세 전시 정보
    public Call<JsonObject> getExhibitDetail( Integer id){
        return service.getExhibitDetail(id);
    }
}
