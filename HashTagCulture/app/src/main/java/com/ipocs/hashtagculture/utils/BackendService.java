package com.ipocs.hashtagculture.utils;



import com.google.gson.JsonArray;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by Dong on 2015-12-01.
 */
public interface BackendService {
    //Todo: api정의

    @Headers({"Content-type: application/json", "Accept: */*"})

    //전체 공연 정보
    @GET("/performances")
    Call<JsonArray> getPerformanceEntire();

}
