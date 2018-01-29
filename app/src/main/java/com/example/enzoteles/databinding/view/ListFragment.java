package com.example.enzoteles.databinding.view;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enzoteles.databinding.R;
import com.example.enzoteles.databinding.adapter.ListEnzoAdapter;
import com.example.enzoteles.databinding.database.repository.MyRepository;
import com.example.enzoteles.databinding.model.po.EnzoPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enzoteles on 28/01/18.
 */

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MyRepository myRepository;
    private List<EnzoPO> listEnzoPO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager =  new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        myRepository = new MyRepository();
        listEnzoPO = new ArrayList<EnzoPO>();
        myRepository.getListEnzo().observe((LifecycleOwner) getActivity(), new Observer<List<EnzoPO>>() {
            @Override
            public void onChanged(@Nullable List<EnzoPO> enzoPOS) {
                for (EnzoPO po : enzoPOS){
                    listEnzoPO.add(po);
                }
            }
        });

        adapter = new ListEnzoAdapter(listEnzoPO);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
