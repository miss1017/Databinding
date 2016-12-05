package com.example.fs.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.fs.databinding.databinding.RecyclerViewItemIvBinding;
import com.example.fs.databinding.databinding.RecyclerViewItemTvBinding;
import com.example.fs.databinding.model.Dimen;
import com.example.fs.databinding.model.Item;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerDatabinding binding;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        Dimen dimen = new Dimen();
        dimen.setPaddingLeft(20);
        binding.setDimen(dimen);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();
        items.add(new Item("item1", getResources().getColor(R.color.red), 29));
        items.add(new Item("item2", Color.RED, 10));
        adapter.notifyDataSetChanged();
    }

//    @BindingAdapter("android:paddingLeft")
//    public static void setPaddingLeft(View view, int paddingLeft) {
//        view.setPadding(paddingLeft,
//                view.getPaddingTop(),
//                view.getPaddingRight(),
//                view.getPaddingBottom());
//    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<BindingHolder> {

        @Override
        public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                View view = getLayoutInflater().inflate(R.layout.recycler_view_item_tv, null);
                return new TVBindingHolder(view);
            } else {
                View view = getLayoutInflater().inflate(R.layout.recycler_view_item_iv, null);
                return new IVBindingHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(BindingHolder holder, int position) {
            holder.getBinding().setVariable(BR.item, items.get(position % 2));
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2;
        }
    }

    static abstract class BindingHolder extends RecyclerView.ViewHolder {

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public abstract ViewDataBinding getBinding();
    }

    static class TVBindingHolder extends BindingHolder {

        public TVBindingHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            RecyclerViewItemTvBinding tvBinding = DataBindingUtil.bind(itemView);
            return tvBinding;
        }
    }

    static class IVBindingHolder extends BindingHolder {
        public IVBindingHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            RecyclerViewItemIvBinding ivBinding = DataBindingUtil.bind(itemView);
            return ivBinding;
        }
    }

}
