package com.shokal.tiptime

import android.app.Activity
import android.app.AlertDialog

class LoadingAnimation(myActivity: Activity ) {
    private var activity: Activity
    private lateinit var dialog: AlertDialog
    init {
        activity = myActivity
    }
    fun startLoading() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater

        builder.setView(inflater.inflate(R.layout.activity_loading, null))
        builder.setCancelable(true)

        dialog = builder.create()
        dialog.show()
    }
    fun dismissLoading(){
        dialog.dismiss()
    }
}