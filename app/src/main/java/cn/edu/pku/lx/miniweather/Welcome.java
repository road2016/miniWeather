package cn.edu.pku.lx.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


import cn.edu.pku.lx.miniweather.R;

/**
 * 欢迎界面
 */
public class Welcome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        * 如果是第一次登录，则进入第一次登录界面
        * */
        SharedPreferences sharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
        boolean isFirst=sharedPreferences.getBoolean("isFirstOpen",true);
        if(isFirst){
            Intent intent=new Intent(this,Guide.class);
            startActivity(intent);
            finish();
        }

        /*
        * 否则进入欢迎页
        * */
        setContentView(R.layout.welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHome();
            }
        },2000);
    }

    private void enterHome(){

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
