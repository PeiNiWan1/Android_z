package com.example.learningplatform.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learningplatform.JsonX;
import com.example.learningplatform.R;
import com.example.learningplatform.ScHttp;
import com.google.gson.Gson;

public class CityModleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.citymodle_fragment,container,false);
        final TextView citytext=layout.findViewById(R.id.cityText);
        ScHttp scHttp=new ScHttp("http://124.93.196.45:10001/prod-api/api/metro/found/list");
        scHttp.setCallData(new ScHttp.CallData() {
            @Override
            public void CallData(String data) {
                Gson gson=new Gson();
                JsonX.CitySw citySw=gson.fromJson(data,JsonX.CitySw.class);
               // citytext.setText(citySw.getData().get(0).getMetroFoundList().get(0).getFoundTime());
            }
        });
        scHttp.Start();
        return layout;
    }

}
