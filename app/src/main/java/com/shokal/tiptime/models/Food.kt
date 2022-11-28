package com.shokal.tiptime.models

import android.app.Person

abstract class Food() {
    abstract val foodName: String
    abstract val foodPrice: Double
    abstract fun totalCost(): Double
}
