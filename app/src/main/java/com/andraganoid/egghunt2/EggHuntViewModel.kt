package com.andraganoid.egghunt2

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EggHuntViewModel : ViewModel() {

    var isSearchMode = ObservableBoolean(false)
    private val _eggBox = MutableLiveData<ArrayList<Egg>>()
    //    val eggBox: LiveData<ArrayList<Egg>>
//        get() = _eggBox
    var eggsCounter = ObservableField<Int>(0)


    fun hideEgg(eggPos: EggPosition) {
        eggsCounter.set(eggsCounter.get()!! + 1)
        _eggBox.value?.add(
            Egg(eggsCounter.get(), eggPos)
        )
    }
}

