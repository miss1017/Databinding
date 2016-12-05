package com.example.fs.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.example.fs.databinding.databinding.IncludeViewStubBinding;
import com.example.fs.databinding.model.User;


public class ViewStubActivity extends AppCompatActivity {

    private User user;
    private ViewstubDatabinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        user = new User("xx");
        binding.setUser(user);
        binding.setHandler(new ClickHandler());
    }

    public class ClickHandler {
        public void onClick() {
            if (!binding.viewStub.isInflated()) {
                binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
                    @Override
                    public void onInflate(ViewStub stub, View inflated) {
                        IncludeViewStubBinding viewStubBinding = DataBindingUtil.bind(inflated);
                        viewStubBinding.setUser(user);
                    }
                });
                binding.viewStub.getViewStub().inflate();
            }
        }
        
        public void onChangeName() {
            user.setName("name changed");
        }
    }
}
