package com.example.modelviewapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
//aplicando el miewModel
//    int contador = 0;
    //Aplicando el livedata

    private MutableLiveData<Integer> counter =new MutableLiveData<>();

    public void increaseCounter(View view){
//        contador++;
        //Retrieve the current value from LiveData

        int currenValue = counter.getValue() !=null ? counter.getValue():0;

        //increase  value in 1

        counter.setValue(currenValue+1);
    }

    public LiveData<Integer> getContador(){
        return counter;
    }

//    public int getContador(){
//        return contador;
//    }
}
