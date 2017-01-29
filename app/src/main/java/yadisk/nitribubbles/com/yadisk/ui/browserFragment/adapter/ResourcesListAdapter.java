package yadisk.nitribubbles.com.yadisk.ui.browserFragment.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yadisk.nitribubbles.com.yadisk.databinding.ResourceItemLayoutBinding;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ResourcesListAdapter extends RecyclerView.Adapter<ResourcesListAdapter.ViewHolder>{
    private List<Resource> resources;

    public ResourcesListAdapter(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ResourceItemLayoutBinding binding = ResourceItemLayoutBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setResource(resources.get(position));
    }

    @Override
    public int getItemCount() {
        return resources.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ResourceItemLayoutBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
