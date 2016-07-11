package com.example.yangdianwen.apidemo;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by yangdianwen on 16-7-11.
 */
public class RetrofitClient implements GankApi {
   public static RetrofitClient  client;
    private GankApi gankApi;

    public static RetrofitClient getInstance() {
        if ( client== null) {
           client=new RetrofitClient();
        }
        return client;
    }
   public  RetrofitClient(){
       OkHttpClient okHttpClient=new OkHttpClient();
       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(Constant.BASE_URL)
               .client(okHttpClient)
               .build();
       gankApi = retrofit.create(GankApi.class);
   }
    @Override
    public Call<ResponseBody> getApi() {
        return gankApi.getApi();
    }
}
