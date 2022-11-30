package com.shokal.tiptime.models
class Food()
{
    val foodName: String=""
    val foodPrice: Double=0.00
    var foodQuantity:Int=1

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
