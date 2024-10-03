package com.example.system_info

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.util.Log

class NotificationInfo(private val context: Context) {
    fun isNotificationEnableForChannel(channelId: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel: NotificationChannel? = notificationManager.getNotificationChannel(channelId)
            return channel != null && channel.importance != NotificationManager.IMPORTANCE_NONE
        }
        return true
    }

    fun openNotificationSetting(): Boolean {
        try {
            val intent = Intent()
            intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            Log.d("NotificationSettings", "Opening notification settings")
            return true
        } catch (e: Exception) {
            Log.e("NotificationSettings", "Failed to open notification settings: ${e.message}")
            return false
        }
    }
}
