package com.example.enzoteles.databinding.model.po;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by enzoteles on 28/01/18.
 */

@Entity
public class EnzoPO{

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String email;

    public EnzoPO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
