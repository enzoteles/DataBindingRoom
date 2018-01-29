package com.example.enzoteles.databinding.database.repository;

import android.arch.lifecycle.LiveData;

import com.example.enzoteles.databinding.MainActivity;
import com.example.enzoteles.databinding.database.dao.EnzoDAO;
import com.example.enzoteles.databinding.database.db.RoomDataBase;
import com.example.enzoteles.databinding.model.po.EnzoPO;

import java.util.List;

/**
 * Created by enzoteles on 28/01/18.
 */

public class MyRepository {

    private RoomDataBase dataBase;
    private LiveData<List<EnzoPO>> listEnzo;

    public MyRepository() {
        dataBase = RoomDataBase.getDatabase(MainActivity.context);
        listEnzo = dataBase.enzoDAO().getEnzoAll();
    }

    public LiveData<List<EnzoPO>> getListEnzo() {
        return listEnzo;
    }

    public void insertEnzo(EnzoPO enzo){
        dataBase.enzoDAO().addEnzo(enzo);
    }

}
