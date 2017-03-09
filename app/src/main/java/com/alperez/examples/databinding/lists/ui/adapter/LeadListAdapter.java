package com.alperez.examples.databinding.lists.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alperez.examples.databinding.lists.R;
import com.alperez.examples.databinding.lists.databinding.ItemLeadListBinding;
import com.alperez.examples.databinding.lists.model.LeadModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeadListAdapter extends BaseAdapter {

    List<LeadModel> data;
    private LayoutInflater mInflater;
    private Context mContext;
    private OnLeadItemClickListener mExtListener;

    public LeadListAdapter(Context context, List<LeadModel> objects) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        data = objects;
    }


    public void setOnLeadItemClickListener(OnLeadItemClickListener listener) {
        this.mExtListener = listener;
    }

    public boolean replaceLeadIfInAdapter(LeadModel lead) {
        if (data != null) {
            for (int i=0; i<data.size(); i++) {
                if (data.get(i).id() == lead.id()) {
                    LeadModel[] array = data.toArray(new LeadModel[data.size()]);
                    array[i] = lead;
                    data = Arrays.asList(array);
                    notifyDataSetChanged();
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        if (data != null && data.size() > 0) {
            data.clear();
            notifyDataSetChanged();
        }
    }

    public void addAll(List<LeadModel> objects) {
        if (data == null) {
            data = new ArrayList<>(objects.size());
        }
        data.addAll(objects);
    }

    public void addAll(LeadModel[] objects) {
        addAll(Arrays.asList(objects));
    }


    @Override
    public int getCount() {
        return (data == null) ? 0 : data.size();
    }

    @Override
    public LeadModel getItem(int position) {
        return (data == null) ? null : data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (data == null) ? -1 : data.get(position).id();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemLeadListBinding binding;
        if (row == null) {
            binding = DataBindingUtil.inflate(mInflater, R.layout.item_lead_list, parent, false);
            binding.setCallClicker(view -> onCallItem(view));
            binding.setMessageClicker(view -> onMessageItem(view));
            row = binding.getRoot();
            row.setTag(binding);
            row.setOnClickListener(view -> onItemClicked(view));
        } else {
            binding = (ItemLeadListBinding) row. getTag();

        }

        binding.setLead(getItem(position));
        return row;
    }


    private void onCallItem(View v) {
        ItemLeadListBinding binding = traverseUpForBindingTag(v);
        if (binding != null) {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + binding.getLead().phone()));
            mContext.startActivity(i);
        }
    }

    private void onMessageItem(View v) {
        ItemLeadListBinding binding = traverseUpForBindingTag(v);
        if (binding != null) {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + binding.getLead().phone()));
            v.getContext().startActivity(smsIntent);
        }
    }

    private void onItemClicked(View v) {
        if (mExtListener != null) {
            LeadModel lead = ((ItemLeadListBinding) v.getTag()).getLead();
            mExtListener.onLeadItemClick(lead.clone());
        }
    }

    private ItemLeadListBinding traverseUpForBindingTag(View v) {
        View parent;
        while((parent = (View) v.getParent()) != null) {
            Object tag = parent.getTag();
            if (tag != null && (tag instanceof ItemLeadListBinding)) {
                return (ItemLeadListBinding) tag;
            }
            v = parent;
        }
        return null;
    }


    public interface OnLeadItemClickListener {
        void onLeadItemClick(LeadModel lead);
    }
}
