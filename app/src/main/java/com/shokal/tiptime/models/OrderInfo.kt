package com.shokal.tiptime.models

class OrderInfo(override val foodName: String, override val foodPrice: Double): Food(){

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
        }    }
    override fun totalCost(): Double {
        return persons.toDouble()*foodPrice
    }
}