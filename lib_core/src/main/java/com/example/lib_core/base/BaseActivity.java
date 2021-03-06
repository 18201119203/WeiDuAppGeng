package com.example.lib_core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        bind = ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        initView();
        initData();
        initPre();

    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getViewId();
    protected abstract void initPre();


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
            ImmersionBar.with(this).destroy();
        }
    }
}
