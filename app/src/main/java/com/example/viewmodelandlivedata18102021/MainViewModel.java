package com.example.viewmodelandlivedata18102021;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    public LiveData<String> getString(){
        return stringMutableLiveData;
    }

    public void setString(String text){
        stringMutableLiveData.setValue(text);
    }
}
