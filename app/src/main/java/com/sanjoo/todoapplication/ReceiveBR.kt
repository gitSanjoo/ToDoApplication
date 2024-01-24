package com.sanjoo.todoapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReceiveBR:BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
        if (intent?.action=="test_br"){
            println("received br")
        }
    }
}