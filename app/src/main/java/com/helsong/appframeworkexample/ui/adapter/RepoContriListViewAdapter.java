package com.helsong.appframeworkexample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.helsong.appframeworkexample.R;
import com.helsong.appframeworkexample.model.Contributor;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by weiruyou on 2015/5/19.
 */
public class RepoContriListViewAdapter extends BaseAdapter {
    private List<Contributor> mContributorsList;

    public void setContributorsList(List<Contributor> list) {
        mContributorsList = list;
    }

    @Override
    public int getCount() {
        return mContributorsList == null ? 0 : mContributorsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mContributorsList == null ? null : mContributorsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, parent, false);
            vh = new ViewHolder();
            vh.contributorNameTV = (TextView) convertView.findViewById(R.id.contributor_name_tv);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.contributorNameTV.setText(mContributorsList.get(position).getLogin());
        return convertView;
    }

    static class ViewHolder {
        public TextView contributorNameTV;
    }
}
