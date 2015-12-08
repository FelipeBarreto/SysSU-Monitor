package br.ufc.great.iot.syssumonitor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.ViewHolder> {
    private ArrayList<String> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_user_name);
        }
    }

    public ListUsersAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    public void setmDataset(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ListUsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}