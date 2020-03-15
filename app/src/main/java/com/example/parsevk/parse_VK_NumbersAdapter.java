/*package com.example.parsevk;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class parse_VK_NumbersAdapter extends Adapter<parse_VK_NumbersAdapter.NumberViewHolder> {
    private int numberItems;
    String name;
    private ArrayList<String> mens_for_recycle = new ArrayList();

    public parse_VK_NumbersAdapter(int NumberOfItems, ArrayList heroes) {
        this.numberItems = NumberOfItems;
        this.mens_for_recycle = heroes;
    }

    @NonNull
    public com.example.parsevk.parse_VK_NumbersAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = 2131361828;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        com.example.parsevk.parse_VK_NumbersAdapter.NumberViewHolder viewHolder = new com.example.parsevk.parse_VK_NumbersAdapter.NumberViewHolder(this, view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull com.example.parsevk.parse_VK_NumbersAdapter.NumberViewHolder holder, int position) {
        holder.bind(position);
        TextView textViewName = holder.ViewHolderIndex;
        holder.ViewHolderIndex.setText((CharSequence)this.mens_for_recycle.get(position));
    }

    public int getItemCount() {
        return this.numberItems;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public class NumberViewHolder {
    }
}
*/