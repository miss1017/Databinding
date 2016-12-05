package com.example.fs.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.fs.databinding.BR;

/**
 * Created by 086 on 2016/12/5.
 */

public class User extends BaseObservable{
    private String name;
    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
