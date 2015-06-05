package com.helsong.appframeworkexample.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.helsong.appframeworkexample.R;
import com.helsong.appframeworkexample.annotation.Named;
import com.helsong.appframeworkexample.model.Contributor;
import com.helsong.appframeworkexample.presenters.Presenter;
import com.helsong.appframeworkexample.presenters.RepoContriPresenter;
import com.helsong.appframeworkexample.ui.viewinterface.RepoContributorsView;
import com.helsong.appframeworkexample.ui.adapter.RepoContriListViewAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

public class RepoContributorsActivity extends BaseActivity implements RepoContributorsView {
    private final static String TAG = RepoContributorsActivity.class.getSimpleName();
    @Inject
    @Named("repoContributor")
    Presenter mRepoContriPresentor;

    @InjectView(R.id.list)
    ListView mListView;
    private RepoContriListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepoContriPresentor.onCreate(this, this);
        initView();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    private void initView() {
        mAdapter = new RepoContriListViewAdapter();
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void showContributors(List<Contributor> list) {
        mAdapter.setContributorsList(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String msgString) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mRepoContriPresentor.onTakeView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRepoContriPresentor.onDropView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRepoContriPresentor.onDestroy();
    }
}
