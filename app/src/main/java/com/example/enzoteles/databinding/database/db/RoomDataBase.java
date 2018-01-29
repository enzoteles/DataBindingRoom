package com.example.enzoteles.databinding.database.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.enzoteles.databinding.database.dao.EnzoDAO;
import com.example.enzoteles.databinding.model.po.EnzoPO;


/**
 * Created by enzoteles on 28/01/18.
 */

@Database(entities = {EnzoPO.class}, version = 1)
public abstract class RoomDataBase extends RoomDatabase {

    private static RoomDataBase INSTANCE;

    public static RoomDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), RoomDataBase.class, "enzo_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract EnzoDAO enzoDAO();
}
