package com.shokal.tiptime

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shokal.tiptime.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding


    @Suppress("DEPRECATION")
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
            binding.masterPay.isClickable = false
            binding.bkashPay.isClickable = false
            binding.rocketPay.isClickable = false
            binding.nagadPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
        }
        binding.masterPay.setOnClickListener {
            paymentOptions()
            binding.masterPay.isClickable = false
            binding.visaPay.isClickable = false
            binding.bkashPay.isClickable = false
            binding.rocketPay.isClickable = false
            binding.nagadPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
        }
        binding.bkashPay.setOnClickListener {
            paymentOptions()
            binding.bkashPay.isClickable = false
            binding.masterPay.isClickable = false
            binding.visaPay.isClickable = false
            binding.rocketPay.isClickable = false
            binding.nagadPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }
        binding.rocketPay.setOnClickListener {
            paymentOptions()
            binding.rocketPay.isClickable = false
            binding.masterPay.isClickable = false
            binding.visaPay.isClickable = false
            binding.bkashPay.isClickable = false
            binding.nagadPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }
        binding.nagadPay.setOnClickListener {
            paymentOptions()
            binding.nagadPay.isClickable = false
            binding.masterPay.isClickable = false
            binding.visaPay.isClickable = false
            binding.bkashPay.isClickable = false
            binding.rocketPay.isClickable = false
            binding.horizontalScrollView.stopNestedScroll()
            binding.nestedScrollView.stopNestedScroll()
        }

        binding.payNowButton.setOnClickListener{
            if(binding.accountNumberEditTextButton.text.toString() != ""){

                val sharedPreferences: SharedPreferences = getSharedPreferences("history", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("totalValue", intent.getDoubleExtra("totalAmount", 0.00).toString())
                editor.apply()

                val dialog = LoadingAnimation(this)
                dialog.startLoading()
                val handler = Handler()
                handler.postDelayed(kotlinx.coroutines.Runnable {
                    dialog.dismissLoading()
                    binding.payMessage.visibility = View.INVISIBLE
                    binding.thankYou.visibility = View.VISIBLE
                    binding.totalAmount.text = ""
                    binding.accountNumberEditTextButton.text.clear()
                    binding.accountNumberEditTextButton.visibility = View.INVISIBLE
                    binding.payNowButton.visibility = View.INVISIBLE
                    binding.thankYou.visibility = View.VISIBLE
                    binding.nagadPay.isClickable = false
                    binding.masterPay.isClickable = false
                    binding.visaPay.isClickable = false
                    binding.bkashPay.isClickable = false
                    binding.rocketPay.isClickable = false

                },
                    5000)
            }else{
                Toast.makeText(this, "Enter Account Number", Toast.LENGTH_SHORT).show()
            }
        }

        binding.homeButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }



    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        return
//        finish()
//        val intent = Intent(this, MenuActivity::class.java)
//        startActivity(intent)
//        finish()
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