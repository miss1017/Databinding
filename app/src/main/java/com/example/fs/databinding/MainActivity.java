package com.example.fs.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fs.databinding.handler.ClickHandler;
import com.example.fs.databinding.model.User;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainDatabinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("xx");
        binding.setUser(user);
        binding.setHandler(new ClickHandler());
    }

}
