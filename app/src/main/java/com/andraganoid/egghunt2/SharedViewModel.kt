package com.andraganoid.egghunt2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val _currentPosition = MutableLiveData<EggPosition>()
    val currentPosition: LiveData<EggPosition>
        get() = _currentPosition
}
