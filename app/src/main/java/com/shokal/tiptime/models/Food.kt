package com.shokal.tiptime.models
abstract class Food() {
    abstract val foodName: String
    abstract val foodPrice: Double
    abstract fun totalCost(): Double
}
