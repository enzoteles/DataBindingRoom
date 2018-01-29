package com.example.enzoteles.databinding.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.enzoteles.databinding.MainActivity;
import com.example.enzoteles.databinding.R;
import com.example.enzoteles.databinding.view.ContentFragment;

/**
 * Created by enzoteles on 28/01/18.
 */

public class ManagerFragment {

    FragmentManager manager;
    FragmentTransaction transaction;

    public ManagerFragment() {
        manager = MainActivity.activity.getFragmentManager();
    }

    public void addFragment(Fragment fragment, String tag){

        transaction = manager.beginTransaction();
        transaction.add(R.id.content, fragment, tag);
        transaction.commit();
    }

    public void replaceFragment(Fragment fragment, String tag, boolean backStack){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, fragment, tag);
        if(backStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

}








