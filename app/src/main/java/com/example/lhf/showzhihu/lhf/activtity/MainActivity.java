package com.example.lhf.showzhihu.lhf.activtity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.lhf.showzhihu.R;
import com.example.lhf.showzhihu.lhf.db.CacheDbHelper;
import com.example.lhf.showzhihu.lhf.fragment.MainFragment;


/**
 * Created by LHF on 15/9/4.
 */
public class MainActivity extends AppCompatActivity {
    private FrameLayout fl_content;
    private SwipeRefreshLayout sr;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;

    private SharedPreferences sp;
    private CacheDbHelper dbHelper;

    private boolean isLight;
    private String curId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        dbHelper = new CacheDbHelper(this,1);
        isLight = sp.getBoolean("isLight",true);
        initView();
        loadLastest();
    }

    private void loadLastest() {
//        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left).replace(R.id.fl_content, new MainFragment(), "latest").commit();

        getSupportFragmentManager().beginTransaction().
                setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left).
                replace(R.id.fl_content, new MainFragment(), "latest").
                commit();
        curId = "lastest";
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(isLight ? R.color.light_toolbar : R.color.dark_toolbar));
        setSupportActionBar(toolbar);

        sr = (SwipeRefreshLayout) findViewById(R.id.sr);
        sr.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_red_light);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                replaceFragment();
                sr.setRefreshing(false);
            }
        });
    }

    private void replaceFragment() {
        if(curId.equals("latest")){

        }

    }

    public void setToolbarTitle(String test){
        toolbar.setTitle(test);
    }


}
