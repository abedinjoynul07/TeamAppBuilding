package com.shokal.tiptime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.shokal.tiptime.databinding.ActivityMainBinding
import com.shokal.tiptime.databinding.ActivityMenuBinding
import com.shokal.tiptime.databinding.ActivityPaymentBinding
import kotlin.properties.Delegates

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var unitPriceStr : String
    private var totalAmount: Double = 0.0
    var unitPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.breakfast1.setOnClickListener{
            unitPriceStr = binding.breakfastPrice1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.breakfast2.setOnClickListener {
            unitPriceStr = binding.breakfastPrice2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.breakfast3.setOnClickListener {
            unitPriceStr = binding.breakfastPrice3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.lunch1.setOnClickListener{
            unitPriceStr = binding.lunchPrice1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.lunch2.setOnClickListener {
            unitPriceStr = binding.lunchPrice2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.lunch3.setOnClickListener {
            unitPriceStr = binding.lunchPrice3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.dinner1.setOnClickListener{
            unitPriceStr = binding.dinnerPrice1.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.dinner2.setOnClickListener {
            unitPriceStr = binding.dinnerPrice2.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.dinner3.setOnClickListener {
            unitPriceStr = binding.dinnerPrice3.text.toString()
            unitPrice = unitPriceStr.toDouble()
            setAmount(unitPrice,1)
        }
        binding.personUp.setOnClickListener{
            var numberPerson = (binding.numberPerson.text.toString()).toIntOrNull()

            if(numberPerson !=null){
                if( (binding.numberPerson.text.toString()).toInt()>=1) {

                    binding.numberPerson.text =
                        ((binding.numberPerson.text.toString()).toInt() + 1).toString()
                    setAmount(unitPrice, (binding.numberPerson.text.toString()).toInt())
                }
            }
            else{
                Toast.makeText(this, "Please Select an Item", Toast.LENGTH_SHORT).show()
            }
        }
        binding.personDown.setOnClickListener{
            var numberPerson = (binding.numberPerson.text.toString()).toIntOrNull()
            if (numberPerson!=null){
                if( (binding.numberPerson.text.toString()).toInt()>1) {
                    binding.numberPerson.text = ((binding.numberPerson.text.toString()).toInt() - 1).toString()
                    setAmount(unitPrice, (binding.numberPerson.text.toString()).toInt())
                }
                else{
                    Toast.makeText(this, "Order Can not be placed for less than one Person", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Please Select an Item", Toast.LENGTH_SHORT).show()
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
    fun setAmount(unit: Double, person: Int): Double{
        totalAmount = unit*person.toDouble()
        binding.numberPerson.text = person.toString()
        binding.menuTotalAmount.text =  "Total Cost: \n"+ totalAmount.toString()
        return totalAmount
    }
}