package com.shenjianli.lifecycle;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shenjianli.shenlib.base.BaseFragmentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OtherActivity extends BaseFragmentActivity {

    @Bind(R.id.activity_open)
    TextView activityOpen;
    @Bind(R.id.fragment_content)
    FrameLayout fragmentContent;

    private OtherFragment mOtherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
        showDefaultFragment();
    }

    private void showDefaultFragment() {

        mOtherFragment = (OtherFragment) getSupportFragmentManager()
                .findFragmentByTag(String.valueOf(2));
        if (null == mOtherFragment) {
            mOtherFragment = OtherFragment.newInstance(2);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, mOtherFragment,
                        String.valueOf(2)).commit();
    }

}
