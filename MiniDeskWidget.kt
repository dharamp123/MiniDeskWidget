package com.example.minidesk

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.updateAll
import androidx.glance.background
import androidx.glance.clickable
import androidx.glance.layout.*
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider
import androidx.glance.unit.dp
import androidx.glance.unit.sp
import java.text.SimpleDateFormat
import java.util.*

class MiniDeskWidget : GlanceAppWidget() {

    companion object {
        var batteryLevel: Int = 84
    }

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val currentDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val season = getIndianSeason(currentMonth)

        val calendarIntent = Intent(Intent.ACTION_VIEW).apply {
            data = CalendarContract.CONTENT_URI
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(12.dp)
                .cornerRadius(16.dp)
        ) {
            Column(
                verticalAlignment = Alignment.Vertical.CenterVertically,
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
                modifier = GlanceModifier.clickable { context.startActivity(calendarIntent) }
            ) {
                Text("📅 $currentDate", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                Text("🔋 Battery: $batteryLevel%", style = TextStyle(fontSize = 14.sp))
                Text("☁️ Season: $season", style = TextStyle(fontSize = 14.sp))
                Spacer(modifier = GlanceModifier.height(8.dp))
                Text("🙏 Donate: yourupi@bank", style = TextStyle(fontSize = 12.sp, color = ColorProvider(Color.Gray)))
                Text("✨ Pro Mode Unlocked", style = TextStyle(fontSize = 10.sp, color = ColorProvider(Color.Blue)))
            }
        }
    }

    private fun getIndianSeason(month: Int): String {
        return when (month) {
            3, 4 -> "Vasanta (Spring)"
            5, 6 -> "Grishma (Summer)"
            7, 8 -> "Varsha (Monsoon)"
            9, 10 -> "Sharad (Autumn)"
            11, 12 -> "Hemant (Pre-Winter)"
            else -> "Shishir (Winter)"
        }
    }
}
