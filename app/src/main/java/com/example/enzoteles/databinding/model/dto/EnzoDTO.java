package com.example.enzoteles.databinding.model.dto;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by enzoteles on 28/01/18.
 */


public class EnzoDTO extends BaseObservable {

    private String name;
    private String email;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.example.enzoteles.databinding.BR.name);
    }
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(com.example.enzoteles.databinding.BR.email);
    }
}
