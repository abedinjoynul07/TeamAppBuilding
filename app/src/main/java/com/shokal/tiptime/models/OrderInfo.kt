package com.shokal.tiptime.models

class OrderInfo( foodName: String, foodPrice: Double): Food(){

    override val foodName: String=foodName
    override val foodPrice: Double = foodPrice
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