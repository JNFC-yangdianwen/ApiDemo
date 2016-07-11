package com.example.yangdianwen.apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<String> datas;
    private ListView listView;
    private DateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lv);
        adapter = new DateAdapter();

        Call<ResponseBody> api = RetrofitClient.getInstance().getApi();
        api.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String body = response.body().string();
                    JSONObject jsonObject=new JSONObject(body);
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int i = 0; i <results.length() ; i++) {
                        String date = (String) results.get(i);
                        datas.add(date);
                    }
                    adapter.addData(datas);
                    listView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
