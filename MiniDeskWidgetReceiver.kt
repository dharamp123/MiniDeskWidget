package com.example.minidesk

import androidx.glance.appwidget.GlanceAppWidgetReceiver

class MiniDeskWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget = MiniDeskWidget()
}
