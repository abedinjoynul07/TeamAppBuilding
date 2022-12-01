package com.shokal.tiptime.models

class OrderInfo( foodName: String, foodPrice: Double): Meal(){

    var persons: Int =1
    val newItem=Meal()
    fun personUp(): Boolean{
        if (persons>0){
            persons++
            return true
        }
        else {
            return false
        }
    }

    fun personDown(): Boolean{
        if (persons>1){
            persons--
            return true
        }
        else {
            return false
        }
    }

    fun setItem()
    {

    }

    fun totalCost(): Double {
        return persons.toDouble()*foodPrice
    }
}