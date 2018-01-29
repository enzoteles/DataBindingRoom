package com.example.enzoteles.databinding.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.enzoteles.databinding.database.repository.MyRepository;
import com.example.enzoteles.databinding.model.dto.EnzoDTO;
import com.example.enzoteles.databinding.model.po.EnzoPO;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by enzoteles on 28/01/18.
 */

public class ContentViewModel extends ViewModel {

    private EnzoDTO enzo;
    private MyRepository myRepository;
    private LiveData<List<EnzoPO>> listEnzoAll;

    public ContentViewModel() {
        myRepository = new MyRepository();
        listEnzoAll = myRepository.getListEnzo();

    }

    public EnzoDTO getEnzo() {
        enzo = new EnzoDTO();
        return enzo;
    }

    public LiveData<List<EnzoPO>> getListEnzoAll() {
        return listEnzoAll;
    }

    public void insertEnzo(final EnzoPO enzoPO){
        Single.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {

                myRepository.insertEnzo(enzoPO);
                return "sucess";
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe();
    }


}
