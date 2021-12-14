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

public class re_fragment extends Fragment {

    TextView Re_text;
    Button Re_but;
    EditText Us_edit,Pa_edit,Ph_edit;
    public interface ReListener
    {
        public void Re_Onclick(int poin);
        public void Register_Onclick(String us,String pa,String phone,int si) throws JSONException;
    }
    private ReListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View viewlayout=inflater.inflate(R.layout.re_fragment,container,false);
        Re_text=viewlayout.findViewById(R.id.register_text);
        Re_but=viewlayout.findViewById(R.id.re_but);
        Us_edit=viewlayout.findViewById(R.id.us_edit);
        Pa_edit=viewlayout.findViewById(R.id.pa_edit);
        Ph_edit=viewlayout.findViewById(R.id.ph_edit);
        return viewlayout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Re_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Fragment Click Interface");
                listener.Re_Onclick(2);
            }
        });
        Re_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listener.Register_Onclick(Us_edit.getText().toString(),Pa_edit.getText().toString(),Ph_edit.getText().toString(),0);
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
