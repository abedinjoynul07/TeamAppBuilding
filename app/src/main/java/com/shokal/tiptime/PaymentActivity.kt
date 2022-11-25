package com.shokal.tiptime

import android.os.Bundle
import android.util.Log
import android.view.View
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
        binding.visaPayment.setOnClickListener {
            paymentOptions()
            binding.visaPayment.isClickable = false
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