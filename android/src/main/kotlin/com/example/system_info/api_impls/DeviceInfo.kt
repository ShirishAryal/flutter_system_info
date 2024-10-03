package com.example.system_info

import DeviceInfoModel
import android.content.Context
import android.os.Build

class DeviceInfo(private val context: Context) {
    fun getDeviceInfo(): DeviceInfoModel {
        return DeviceInfoModel(
            sdkVersion = Build.VERSION.SDK_INT.toLong(),
            osVersion = Build.VERSION.RELEASE,
            manufacturer = Build.MANUFACTURER,
            brand = Build.BRAND,
            model = Build.MODEL,
            product = Build.PRODUCT,
            device = Build.DEVICE,
            hardware = Build.HARDWARE,
            board = Build.BOARD,
            buildId = Build.ID,
            buildType = Build.TYPE,
            buildTime = Build.TIME
        )
    }
}
