package com.andraganoid.egghunt2.hunt

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andraganoid.egghunt2.model.Egg
import com.andraganoid.egghunt2.model.EggPosition

class EggHuntViewModel() : ViewModel() {

    var eggToRemove: Egg? = null
    val eggVisibility = ObservableBoolean()
    val isSearchMode = ObservableBoolean()
    val gameOver = ObservableBoolean()
    val eggBox = MutableLiveData<ArrayList<Egg>>()
    val eggsCounter = ObservableField<Int>(0)

    fun hideEgg(eggPos: EggPosition) {
        eggsCounter.set(eggsCounter.get()!! + 1)
        eggBox.value?.add(
            Egg(eggsCounter.get(), eggPos)
        )
    }

    fun doneHiding() {
        isSearchMode.set(true)
    }

    fun eggClicked() {
        eggBox.value?.remove(eggToRemove)
        eggVisibility.set(false)
        eggsCounter.set(eggBox.value?.size)
        if (eggsCounter.get() == 0) {
            gameOver.set(true)
        }
    }

    fun huntInit() {
        eggBox.value = arrayListOf()
        isSearchMode.set(false)
        eggVisibility.set(false)
        eggsCounter.set(0)
        gameOver.set(false)
    }

}

