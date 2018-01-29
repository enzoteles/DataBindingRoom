package com.example.enzoteles.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.enzoteles.databinding.BR;
import com.example.enzoteles.databinding.R;
import com.example.enzoteles.databinding.databinding.EnzoItemBinding;
import com.example.enzoteles.databinding.model.po.EnzoPO;

import java.util.List;

/**
 * Created by enzoteles on 28/01/18.
 */

public class ListEnzoAdapter extends RecyclerView.Adapter<ListEnzoAdapter.MyViewHolder>{

    List<EnzoPO> lisEnzoPO;

    public ListEnzoAdapter(List<EnzoPO> lisEnzoPO) {
        this.lisEnzoPO = lisEnzoPO;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        EnzoItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.enzo_item, parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final EnzoPO enzoPO = lisEnzoPO.get(position);
        holder.bind(enzoPO);
    }

    @Override
    public int getItemCount() {
        return lisEnzoPO.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final EnzoItemBinding binding;

        public MyViewHolder(EnzoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Object enzo){
            binding.setVariable(BR.enzo, enzo);
            binding.executePendingBindings();
        }
    }
}
