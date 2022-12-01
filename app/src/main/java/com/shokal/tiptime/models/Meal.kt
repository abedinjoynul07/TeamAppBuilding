package com.shokal.tiptime.models

open class Meal():Food() {
    val mealList= mutableListOf<Food>()

    fun addItem(name:String, price:Double){
        val newItem= Food()
        newItem.foodName=name
        newItem.foodPrice=price
        mealList.add(newItem)
    }
    fun increaseQty()
    {
        foodQuantity++
    }
    fun decreseQty()
    {
        if (foodQuantity>1)
        {
            foodQuantity--
        }
    }

}
