package com.shokal.tiptime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shokal.tiptime.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.payMessage.visibility = View.INVISIBLE
        binding.totalAmount.visibility = View.INVISIBLE
        binding.accountNumberEditTextButton.visibility = View.INVISIBLE
        binding.payNowButton.visibility = View.INVISIBLE
        binding.thankYou.visibility = View.INVISIBLE
        binding.visaPay.setOnClickListener {
            paymentOptions()
            binding.visaPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
        }
        binding.masterPay.setOnClickListener {
            paymentOptions()
            binding.masterPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
        }
        binding.bkashPay.setOnClickListener {
            paymentOptions()
            binding.bkashPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }
        binding.rocketPay.setOnClickListener {
            paymentOptions()
            binding.rocketPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }
        binding.nagadPay.setOnClickListener {
            paymentOptions()
            binding.nagadPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }

        binding.payNowButton.setOnClickListener{
            binding.payMessage.visibility = View.INVISIBLE
            binding.thankYou.visibility = View.VISIBLE
            binding.totalAmount.text = ""
            binding.accountNumberEditTextButton.text.clear()
            binding.accountNumberEditTextButton.visibility = View.INVISIBLE
            binding.payNowButton.visibility = View.INVISIBLE
            binding.thankYou.visibility = View.VISIBLE
        }
    }

    //payment method visibility on function
    private fun paymentOptions(){
        val amountStr = intent.getDoubleExtra("totalAmount", 0.00)
        Log.d("Main", amountStr.toString())
        binding.totalAmount.text = amountStr.toString()
        binding.payMessage.visibility = View.VISIBLE
        binding.totalAmount.visibility = View.VISIBLE
        binding.accountNumberEditTextButton.visibility = View.VISIBLE
        binding.payNowButton.visibility = View.VISIBLE
    }
}