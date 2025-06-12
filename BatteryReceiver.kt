package com.example.minidesk

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import androidx.glance.appwidget.updateAll

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        MiniDeskWidget.batteryLevel = level
        MiniDeskWidget().updateAll(context)
    }
}
