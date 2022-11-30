package com.shokal.tiptime.models

open class Meal():Food() {
    val mealList= mutableListOf<Food>()
    abstract fun addMealItem(newItem:Food)

    override fun addMealItem(newItem:Food) {
        mealList.add(newItem)
    }

}
