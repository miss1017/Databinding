package com.example.fs.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.ColorInt;

/**
 * Created by 086 on 2016/12/5.
 */

public class Item extends BaseObservable {
    @ColorInt
    private int color;
    private int paddingLeft;
    public ObservableField<String> name = new ObservableField();

    public Item(String name, @ColorInt int color, int paddingLeft) {
        this.name.set(name);
        this.color = color;
        this.paddingLeft = paddingLeft;
    }

    public Item() {
    }

//    public String getName() {
//        return (String) name.get();
//    }
//
//    public void setName(String name) {
//        this.name.set(name);
//    }

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
