package com.shokal.tiptime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.shokal.tiptime.databinding.ActivityMainBinding
import com.shokal.tiptime.databinding.ActivityMenuBinding
import com.shokal.tiptime.databinding.ActivityPaymentBinding
import com.shokal.tiptime.models.OrderInfo
import kotlin.properties.Delegates

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var unitPriceStr : String
    public lateinit var foodName : String
    private lateinit var orderInfo: OrderInfo
    private var totalAmount: Double = 0.0
    var unitPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.breakfast1.setOnClickListener{
            unitPriceStr = binding.breakfastPrice1.text.toString()
            foodName = binding.breakfastInfo1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.breakfast2.setOnClickListener {
            unitPriceStr = binding.breakfastPrice2.text.toString()
            foodName = binding.breakfastInfo2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.breakfast3.setOnClickListener {
            unitPriceStr = binding.breakfastPrice3.text.toString()
            foodName = binding.breakfastInfo3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.lunch1.setOnClickListener{
            unitPriceStr = binding.lunchPrice1.text.toString()
            foodName = binding.lunchinfo1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.lunch2.setOnClickListener {
            unitPriceStr = binding.lunchPrice2.text.toString()
            foodName = binding.lunchInfo2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.lunch3.setOnClickListener {
            unitPriceStr = binding.lunchPrice3.text.toString()
            foodName = binding.lunchInfo3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.dinner1.setOnClickListener{
            unitPriceStr = binding.dinnerPrice1.text.toString()
            foodName = binding.dinnerinfo1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.dinner2.setOnClickListener {
            unitPriceStr = binding.dinnerPrice2.text.toString()
            foodName = binding.dinnerInfo2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.dinner3.setOnClickListener {
            unitPriceStr = binding.dinnerPrice3.text.toString()
            foodName = binding.dinnerInfo3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            orderInfo=OrderInfo(foodName,unitPrice)
            setAmount()
        }
        binding.personUp.setOnClickListener{
            var numberPerson = binding.numberPerson.text.toString().toIntOrNull()
            Log.d("Main", numberPerson.toString())
            if(numberPerson==null){
                Toast.makeText(this, "Please Select an Item", Toast.LENGTH_SHORT).show()

            }
            else{
                orderInfo.personUp()
                setAmount()
            }
        }
        binding.personDown.setOnClickListener{
            var numberPerson = (binding.numberPerson.text.toString()).toIntOrNull()
            if(numberPerson==null){
                Toast.makeText(this, "Please Select an Item", Toast.LENGTH_SHORT).show()

            }
            else if(orderInfo.personDown()){
                setAmount()
            }
            else{
                Toast.makeText(this, "Order Can not be placed for less than one Person", Toast.LENGTH_SHORT).show()

            }
        }
        
        binding.paybtn.setOnClickListener { 
            if (totalAmount>1){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("totalAmount", (totalAmount))
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "You can not continue without puchase", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun setAmount(): Double{
        totalAmount = orderInfo.totalCost()
        binding.numberPerson.text = orderInfo.persons.toString()
        binding.menuTotalAmount.text =  "Total Cost: \n"+ orderInfo.totalCost().toString()
        return totalAmount
    }
}