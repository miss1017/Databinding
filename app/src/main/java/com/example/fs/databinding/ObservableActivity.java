package com.example.fs.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fs.databinding.databinding.ActivityObservableBinding;
import com.example.fs.databinding.model.User;


public class ObservableActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        user = new User("xx");
        binding.setUser(user);
        binding.setHandler(new ClickHandler());
    }

    public class ClickHandler {
        public void onClick() {
            user.setName("changed");
        }
    }
}
