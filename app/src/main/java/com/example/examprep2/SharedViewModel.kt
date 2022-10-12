package com.example.examprep2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private var _data= MutableLiveData("Default Value")
    val data: LiveData<String> = _data
    fun savedata(newdata:String){
        _data.value = newdata
    }
}