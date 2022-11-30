package com.shokal.tiptime.models

class OrderInfo(override val foodName: String, override val foodPrice: Double): Meal(){

    var persons: Int =1
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
        val newItem=Food()

    }


    override fun totalCost(): Double {
        return persons.toDouble()*foodPrice
    }
}