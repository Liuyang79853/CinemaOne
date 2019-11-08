package com.bawie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.bawie.R;
import com.bawie.view.fragment.FragmentOne;

public class MainActivity extends AppCompatActivity {

    private TextView tv_yin;
    private int time=2;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){

                if (time<=0){
                    startActivity(new Intent(MainActivity.this, FilmActivity.class));
                    finish();
                }else{
                    time--;
                    tv_yin.setText(time+"");
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main);
        tv_yin = (TextView) findViewById(R.id.tv_yin);

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what=1;
                handler.sendMessageDelayed(message,1000);
            }
        }.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }

    public void yind(View view) {
        startActivity(new Intent(MainActivity.this,FilmActivity.class));
    }
}
