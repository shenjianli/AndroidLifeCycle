package com.shenjianli.lifecycle;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.shenjianli.lifecycle.service.ServiceActivity;
import com.shenjianli.shenlib.base.BaseFragmentActivity;
import com.shenjianli.shenlib.util.LogUtils;

import java.util.List;

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


    @OnClick({R.id.activity_open,R.id.service_open})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_open:
//                Intent intent = new Intent(this,OtherActivity.class);
//                startActivity(intent);
                isServiceRunning(this, "MainService");
                break;
            case R.id.service_open:
                Intent intent1 = new Intent(this, ServiceActivity.class);
                startActivity(intent1);
                break;
        }
    }

    /**
     * 用来判断服务是否运行.
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRunning(Context mContext, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)
                mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList
                = activityManager.getRunningServices(30);
        if (!(serviceList.size()>0)) {
            return false;
        }
        for (int i=0; i<serviceList.size(); i++) {
            LogUtils.i("服务：" + serviceList.get(i).service.getClassName());
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                LogUtils.i("找到了：" + serviceList.get(i).service.getClassName());
                break;
            }
        }
        return isRunning;
    }
}
