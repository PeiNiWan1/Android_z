package com.example.learningplatform;

import android.util.Log;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class ScHttp {


    public int Modle_Get=1;
    public int Modle_Post=2;
    private int Modle=1;
    private String Url;
    private JSONObject DataLists;
    public OkHttpClient okHttpClient;
    public Request request;
    public Call call;
    public String Token="";


    public interface CallData
    {
        public void CallData(String data);

    }
    private CallData CallData;
    public void setCallData(CallData callData)
    {

        CallData=callData;
    }

    public ScHttp(String url,int modle,JSONObject datalists)
    {

        Modle=modle;
        Url=url;
        DataLists=datalists;
        init();
    }
    public ScHttp(String url)
    {


        Url=url;
        init();

    }
    public void init()
    {
        okHttpClient=new OkHttpClient();

    }
    public void getData()
    {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                CallData.CallData(response.body().string());

            }
        });

    }
    public void Start()
    {
        switch (Modle)
        {
            case 1:
                if (Token.equals("")){request=new Request.Builder().url(Url).get().build();}
                else {request=new Request.Builder().url(Url).addHeader("Authorization",Token).get().build();}

                break;
            case 2:
                MediaType mediaType= MediaType.parse("application/json");
                RequestBody requestBody=RequestBody.create(mediaType,String.valueOf( DataLists));


                request=new Request.Builder().url(Url).post(requestBody).build();
        }

        call=okHttpClient.newCall(request);
        getData();
    }
}
