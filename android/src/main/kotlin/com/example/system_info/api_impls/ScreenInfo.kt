package com.example.system_info

import ScreenInfoModel
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class ScreenInfo(private val context: Context) {
    fun getScreenInfo(): ScreenInfoModel {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val widthPixels = displayMetrics.widthPixels
        val heightPixels = displayMetrics.heightPixels
        val densityDpi = displayMetrics.densityDpi
        val density = displayMetrics.density
        val scaledDensity = displayMetrics.scaledDensity

        val widthDp = widthPixels / density
        val heightDp = heightPixels / density

        val brightnessLevel = try {
            android.provider.Settings.System.getInt(
                context.contentResolver,
                android.provider.Settings.System.SCREEN_BRIGHTNESS
            ) / 255f
        } catch (e: Exception) {
            -1f // Return -1 if unable to get brightness
        }

        return ScreenInfoModel(
            widthPixels = widthPixels.toLong(),
            heightPixels = heightPixels.toLong(),
            densityDpi = densityDpi.toLong(),
            density = density.toDouble(),
            scaledDensity = scaledDensity.toDouble(),
            widthDp = widthDp.toDouble(),
            heightDp = heightDp.toDouble(),
            brightnessLevel = brightnessLevel.toDouble()
        )
    }
}
