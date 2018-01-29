package com.example.enzoteles.databinding.view;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.enzoteles.databinding.R;
import com.example.enzoteles.databinding.databinding.ContentBinding;
import com.example.enzoteles.databinding.model.po.EnzoPO;
import com.example.enzoteles.databinding.util.ManagerFragment;
import com.example.enzoteles.databinding.viewmodel.ContentViewModel;

import java.util.List;

/**
 * Created by enzoteles on 28/01/18.
 */

public class ContentFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final ContentBinding binding = DataBindingUtil.inflate(inflater, R.layout.content, container, false);
        final View view = binding.getRoot();
        final ManagerFragment managerFragment = new ManagerFragment();
        final ListFragment listFragment = new ListFragment();
        final ContentViewModel viewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(ContentViewModel.class);
        binding.setEnzo(viewModel.getEnzo());
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "onClick " + binding.getEnzo().getName(), Toast.LENGTH_SHORT).show();
                //insert university
                EnzoPO enzoPO = new EnzoPO(binding.getEnzo().getName(), binding.getEnzo().getEmail());
                viewModel.insertEnzo(enzoPO);
                managerFragment.replaceFragment(listFragment, "list", true);
            }
        });

        return view;
    }


}
