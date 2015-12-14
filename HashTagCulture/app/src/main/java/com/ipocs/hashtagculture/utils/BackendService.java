package com.ipocs.hashtagculture.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by Dong on 2015-12-01.
 */
public interface BackendService {
    //Todo: api정의

    @Headers({"Content-type: application/json", "Accept: */*"})

    //전체 공연 정보
    @GET("/performances")
    Call<JsonArray> getPerformanceEntire();

    //Todo: query parameter
    //추천 공연 정보
    @GET("/performances/recommend")
    Call<JsonArray> getPerformanceRecommend();

    //상세 공연 정보
    @GET("/performances/detail/{id}")
    Call<JsonObject> getPerformanceDetail(@Path("id") Integer id);

    //전체 전시 정보
    @GET("/exhibits")
    Call<JsonArray> getExhibitEntire();

    //Todo: query parameter
    //추천 전시 정보
    @GET("/exhibits/recommend")
    Call<JsonArray> getExhibitRecommend();

    //상세 전시 정보
    @GET("/exhibits/detail/{id}")
    Call<JsonObject> getExhibitDetail(@Path("id") Integer id);

}
