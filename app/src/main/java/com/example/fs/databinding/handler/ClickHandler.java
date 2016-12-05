package com.example.fs.databinding.handler;

import android.util.Log;
import android.view.View;

/**
 * Created by 086 on 2016/12/5.
 */

public class ClickHandler {
    //方法引用
    public void onClick(View view) {
        Log.i("fengsi", "btn1---view = " + view);
    }

    //监听绑定
    public void onClick() {
        Log.i("fengsi", "btn2");
    }

}
