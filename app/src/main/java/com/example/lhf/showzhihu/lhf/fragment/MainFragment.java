package com.example.lhf.showzhihu.lhf.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lhf.showzhihu.R;
import com.example.lhf.showzhihu.lhf.activtity.MainActivity;

/**
 * Created by LHF on 15/9/4.
 */
public class MainFragment extends BaseFragment{
    private ListView lv_news;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) mActivity).setToolbarTitle("今日热闻");
        View view = inflater.inflate(R.layout.main_news_layout,container,false);
        lv_news = (ListView) view.findViewById(R.id.lv_news);
        View header = inflater.inflate(R.layout.kanner,lv_news,false);
        return null;
    }
}
