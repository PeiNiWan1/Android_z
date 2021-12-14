package com.example.learningplatform;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;

import static android.content.ContentValues.TAG;

public class login_fragment extends Fragment {

    private TextView Re_but;
    private EditText Us_edit,Pa_edit;
    private Button Login_but;
    public interface ReListener
    {
        public void Re_Onclick(int poin);
        public void Login_Onclick(String us,String pa) throws JSONException;
    }
    private ReListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View viewlayout=inflater.inflate(R.layout.login_fragment,container,false);
        Re_but=viewlayout.findViewById(R.id.register_text);
        Login_but=viewlayout.findViewById(R.id.login_but);
        Us_edit=viewlayout.findViewById(R.id.us_edit);
        Pa_edit=viewlayout.findViewById(R.id.pa_edit);
        return viewlayout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Re_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Fragment Click Interface");
                listener.Re_Onclick(1);
            }
        });
        Login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listener.Login_Onclick(Us_edit.getText().toString(),Pa_edit.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener=(ReListener)context;
    }
}
