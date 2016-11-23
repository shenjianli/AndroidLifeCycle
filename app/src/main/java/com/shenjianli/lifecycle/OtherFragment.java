package com.shenjianli.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shenjianli.shenlib.base.BaseFragment;

/**
 * Created by shenjianli on 2016/9/2.
 */
public class OtherFragment extends BaseFragment implements View.OnClickListener {

    private Context mContext;
    private View mView;

    public static OtherFragment newInstance(int index) {
        OtherFragment mainFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mView = inflater.inflate(R.layout.fragment_other, container,
                false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void clearObject() {

    }

    @Override
    public void clearView() {

    }
}
