package com.example.day09.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StatusBarUtil {

    public static void setStatussBarColor(Activity context , int colorRes){
        Window window = context.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

//            添加状态栏背景色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//            设置状态栏颜色
            window.setStatusBarColor(context.getResources().getColor(colorRes));

//          状态栏中文字的颜色变成黑色

           window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }


    //        隐藏标题栏  和 toolBar
    public static void setFollScreen(Activity context){
        Window window = context.getWindow();
        window.getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

//     标题栏 的颜色
    public static void setStatusBarTrans(Activity context){
        Window window = context.getWindow();
        window.getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.BLUE);
    }



}
