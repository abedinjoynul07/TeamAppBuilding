package com.shokal.tiptime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.shokal.tiptime.databinding.ActivityMainBinding
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tipAmount: Double = 0.00
    private var amount: Double = 0.00

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val amountStr = intent.getDoubleExtra("totalAmount", 0.00).toString()
        binding.tipAmount.setText(amountStr)
        binding.percentageSeekBar.progress = 20
        var progressValue = 20.0

        binding.percentValue.text = binding.percentageSeekBar.progress.toString()
        binding.tipCalculator.setOnClickListener {
            tipCalculate(progressValue)
        }
        binding.percentageSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.percentValue.text = seekBar.progress.toString()
                progressValue = seekBar.progress.toString().toDouble()
                Log.d("Main", progressValue.toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })//end of progress bar
        binding.roundUp.setOnClickListener {
            val roundUpTipAmount = ceil(tipAmount)
            tipMessageShow(roundUpTipAmount)
        }
        binding.roundDown.setOnClickListener {
            val roundUpTipAmount = floor(tipAmount)
            tipMessageShow(roundUpTipAmount)
        }
        binding.buttonPayment.setOnClickListener {
            if(tipAmount > 0.00) {
                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("totalAmount", (amount + tipAmount))
                startActivity(intent)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun tipMessageShow(tipMoney: Double) {
        val formattedTip = "৳${tipMoney}"
        binding.calculatedAmountText.text = getString(R.string.tip_amount, formattedTip)
    }
    @SuppressLint("SetTextI18n")
    private fun tipCalculate(progressValue: Double) {
        val amountText = binding.tipAmount.text.toString()
        if (amountText == "") {
            binding.tipAmount.error = getString(R.string.amountWarning)
            binding.calculatedAmountText.text = getString(R.string.noTipAmount)
        } else {
            amount = amountText.toDouble()
            tipAmount = ((amount * (progressValue / 100)) * 100.0).roundToInt() / 100.0
            tipMessageShow(tipAmount)
        }
    }
}