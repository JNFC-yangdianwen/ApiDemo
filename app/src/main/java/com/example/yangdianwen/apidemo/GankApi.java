package com.example.yangdianwen.apidemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yangdianwen on 16-7-11.
 */
public interface GankApi {
    //http://gank.io/api/day/history
@GET("api/day/history")
Call<ResponseBody> getApi();
}
