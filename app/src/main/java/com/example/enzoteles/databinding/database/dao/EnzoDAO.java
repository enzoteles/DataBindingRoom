package com.example.enzoteles.databinding.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.enzoteles.databinding.model.po.EnzoPO;

import java.util.List;

/**
 * Created by enzoteles on 28/01/18.
 */
@Dao
public interface EnzoDAO {

    @Query("Select * From enzopo")
    LiveData<List<EnzoPO>> getEnzoAll();

    @Insert
    void addEnzo(EnzoPO enzo);
}
