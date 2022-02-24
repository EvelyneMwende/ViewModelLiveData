package com.example.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    var number =0

    //create live data
    val currentNumber: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    val currentBoolean: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>()
    }
}