package com.example.enzoteles.databinding;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.enzoteles.databinding.util.ManagerFragment;
import com.example.enzoteles.databinding.view.ContentFragment;

public class MainActivity extends AppCompatActivity {

    public static Context context;
    public static  MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        context = getBaseContext();
        ContentFragment fragment = new ContentFragment();
        ManagerFragment fragmentManager = new ManagerFragment();
        fragmentManager.addFragment(fragment, "content");


    }
}
