package com.example.learningplatform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;




public class login extends AppCompatActivity implements login_fragment.ReListener, re_fragment.ReListener {

    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        replaceFragment(new login_fragment());
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务
        transaction.replace(R.id.fragment2, fragment);
        transaction.commit();
    }
    private void login(String us,String pa) throws JSONException {
        Log.d(TAG, "login: "+us+pa);
        JSONObject json=new JSONObject();
        json.put("username",us);
        json.put("password",pa);


        ScHttp scHttp=new ScHttp("http://124.93.196.45:10001/prod-api/api/login",2,json);
        scHttp.setCallData(new ScHttp.CallData() {
           @Override
           public void CallData(String data) {
               Log.d(TAG, "CallData: "+data);
               Gson gson=new Gson();
               JsonX.LoginX json=gson.fromJson(data,JsonX.LoginX.class);

               if (json.code==200)
               {
                   SharedPreferences cong=getSharedPreferences("data",0);
                   SharedPreferences.Editor editor=cong.edit();
                   editor.putString("token",json.token);
                   editor.commit();
                   ToActivity();
                   Tlogd(json.msg);
               }
               Tlogd(json.msg);
           }
        });
        scHttp.Start();


    }
    private void Register(String us, String pa, String phone,int si) throws JSONException {
        JSONObject json=new JSONObject();
        json.put("userName",us);
        json.put("password",pa);
        json.put("phonenumber",phone);


        ScHttp scHttp=new ScHttp("http://124.93.196.45:10001/prod-api/api/register",2,json);
        scHttp.setCallData(new ScHttp.CallData() {
            @Override
            public void CallData(String data) {
                Log.d(TAG, "CallData: "+data);
                Gson gson=new Gson();
                JsonX.Base json=gson.fromJson(data, JsonX.Base.class);
                Log.d(TAG, "CallData: code"+json.code);
                if (json.code==200)
                {
                    SetFragment(2);
                }
                Tlogd(json.msg);
            }
        });
        scHttp.Start();

    }

    private void SetFragment(int i)
    {
        switch (i)
        {
            case 1:
                replaceFragment(new re_fragment());
                break;
            case 2:
                replaceFragment(new login_fragment());
                break;

        }
    }

    private void Tlogd(String str)
    {
        Looper.prepare();
        Toast.makeText(login.this,str,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
    private void ToActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
       startActivity(intent);
       finish();
    }


    //Fragment 接口
    public void Re_Onclick(int poin)
    {
        Log.d(TAG, "Re_Onclick: 注册接口 响应");
        SetFragment(poin);

    }

    @Override
    public void Register_Onclick(String us, String pa,String phone, int si) throws JSONException {
        Register(us,pa,phone,si);
    }

    @Override
    public void Login_Onclick(String us, String pa) throws JSONException {
        login(us,pa);
    }
}
