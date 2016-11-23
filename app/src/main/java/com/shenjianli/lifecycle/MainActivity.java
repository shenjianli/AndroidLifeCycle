package com.shenjianli.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.shenjianli.shenlib.base.BaseFragmentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {


    @Bind(R.id.activity_open)
    Button activityOpen;
    @Bind(R.id.fragment_content)
    FrameLayout fragmentContent;
    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showDefaultFragment();
    }

    private void showDefaultFragment() {
        mMainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentByTag(String.valueOf(1));
        if (null == mMainFragment) {
            mMainFragment = MainFragment.newInstance(1);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, mMainFragment,
                        String.valueOf(1)).commit();
    }


    @OnClick(R.id.activity_open)
    public void onClick() {
        Intent intent = new Intent(this,OtherActivity.class);
        startActivity(intent);
    }
}
