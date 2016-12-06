package com.example.fs.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fs.databinding.databinding.ActivityObservableBinding;
import com.example.fs.databinding.model.Item;
import com.example.fs.databinding.model.User;


public class ObservableActivity extends AppCompatActivity {

    private User user;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        //User演示Observable对象
        user = new User("xx");
        binding.setUser(user);
        binding.setHandler(new ClickHandler());
        //Item演示ObservableField
        item = new Item();
        item.name.set("yy");
        binding.setItem(item);
    }

    public class ClickHandler {
        public void onClick() {
            user.setName("changed");
            item.name.set("haha");
        }
        public void onClick(View v) {

        }
    }
}
