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
import com.google.gson.Gson;

public class MyFragment extends Fragment {



    public TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.myfragment,container,false);
        textView=layout.findViewById(R.id.infr);
        TextView user=layout.findViewById(R.id.usertext);


        Bundle bundle = this.getArguments();
        String str="网络错误";
        if (bundle != null)
        {
            str = bundle.getString("Data");
            Gson gson=new Gson();
            JsonX.Pinformation pinformation= gson.fromJson(str,JsonX.Pinformation.class);
            JsonX.User userX =pinformation.user;
            user.setText(userX.userName);

        }
        textView.setText(str);
        return layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
