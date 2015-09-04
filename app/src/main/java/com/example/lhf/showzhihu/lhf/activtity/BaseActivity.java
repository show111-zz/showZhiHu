package com.example.lhf.showzhihu.lhf.activtity;

import android.app.Activity;

import butterknife.ButterKnife;

/**
 * Created by LHF on 15/9/4.
 */
public class BaseActivity extends Activity{

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);

    }
}
