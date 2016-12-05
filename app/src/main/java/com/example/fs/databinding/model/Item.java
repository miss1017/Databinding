package com.example.fs.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.ColorInt;
import com.example.fs.databinding.BR;

/**
 * Created by 086 on 2016/12/5.
 */

public class Item extends BaseObservable{
    private String name;
    @ColorInt
    private int color;
    private int paddingLeft;
    public Item(String name, @ColorInt int color, int paddingLeft) {
        this.name = name;
        this.color = color;
        this.paddingLeft = paddingLeft;
    }

    public Item() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }
}
