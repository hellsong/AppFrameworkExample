package com.helsong.appframeworkexample.ui.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.helsong.appframeworkexample.R;
import com.helsong.appframeworkexample.annotation.Named;
import com.helsong.appframeworkexample.presenters.Presenter;
import com.helsong.appframeworkexample.ui.viewinterface.ReadmeInfoView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReadmeInfoActivity extends BaseActivity implements ReadmeInfoView {
    @InjectView(R.id.read_me_info_tv)
    TextView mReadmeInfoTV;
    @Inject
    @Named("ReadmeInfo")
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(this, this);
//        mReadmeInfoTV = (TextView) findViewById(R.id.read_me_info_tv);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_readme_info;
    }


    @Override
    public void showReadmeInfo(String info) {
        mReadmeInfoTV.setText(info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onTakeView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onDropView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
