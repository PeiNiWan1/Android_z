package com.example.learningplatform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView version=findViewById(R.id.version);
        if (init(version))
        {


            handler.sendEmptyMessageDelayed(0,3000);
        }
        else {
            Toast.makeText(this,"版本信息错误 无法使用",Toast.LENGTH_LONG);
        }

    }

    private boolean init(TextView view)
    {


        return true;
    }


    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what){
                case 0:
                    getmainactivity();
                    break;
                case 1:
                    ToText((String) message.obj);
            }
            return false;
        }
    });
    private void ToText(String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT);
    }
    private void getmainactivity()
    {
        Intent intent=new Intent(welcome.this,login.class);
        startActivity(intent);
        finish();
    }
}