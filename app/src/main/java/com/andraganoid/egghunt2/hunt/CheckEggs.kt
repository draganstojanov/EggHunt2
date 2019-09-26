package com.andraganoid.egghunt2.hunt

import com.andraganoid.egghunt2.model.Egg
import com.andraganoid.egghunt2.model.EggPosition

fun checkEgg(currentPosition: EggPosition, egg: Egg): Egg? {
    return if (isBetweenAzi(
            currentPosition.azimuth,
            egg.position!!.azimuth
        ) &&
        isBetweenLoc(
            currentPosition.latitude,
            egg.position.latitude
        ) &&
        isBetweenLoc(
            currentPosition.longitude,
            egg.position.longitude
        )
    ) egg
    else
        null
}

const val LOC_OFFSET = .001
fun isBetweenLoc(loc: Double, eggLoc: Double): Boolean {
    return eggLoc > loc - LOC_OFFSET && eggLoc < loc + LOC_OFFSET
}

const val AZI_OFFSET = 18
fun isBetweenAzi(azi: Int, eggAzi: Int): Boolean {
    var min = azi - AZI_OFFSET
    if (min < 0) {
        min += 360
    }
    var max = azi + AZI_OFFSET
    if (max > 359) {
        max -= 360
    }
    return eggAzi > min && eggAzi < max
}