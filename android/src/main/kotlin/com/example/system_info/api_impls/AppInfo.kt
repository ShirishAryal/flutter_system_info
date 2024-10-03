package com.example.system_info

import ApplicationInfoModel
import FlutterError
import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import android.util.Log

class AppInfo(private val context: Context) {
    fun getAppInfo(): ApplicationInfoModel {
        val packageManager = context.packageManager
        val packageName = context.packageName

        try {
            val packageInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
            val applicationInfo = packageInfo.applicationInfo
            val permissions: MutableList<String> = mutableListOf()

            packageInfo.requestedPermissions?.forEach { permission ->
                permissions.add(permission)
                Log.d("AppInfo", "Requested Permission: $permission")
            }

            return ApplicationInfoModel(
                appName = packageManager.getApplicationLabel(applicationInfo).toString(),
                packageName = packageName,
                versionName = packageInfo.versionName,
                versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    packageInfo.longVersionCode
                } else {
                    packageInfo.versionCode.toLong()
                },
                installTime = packageInfo.firstInstallTime,
                lastUpdateTime = packageInfo.lastUpdateTime,
                targetSdkVersion = applicationInfo.targetSdkVersion.toLong(),
                minSdkVersion = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    applicationInfo.minSdkVersion
                } else {
                    1
                }.toLong(),
                dataDirectory = applicationInfo.dataDir,
                sourceDirectory = applicationInfo.sourceDir,
                permissions = permissions
            )

        } catch (e: Exception) {
            Log.e("AppInfo", "Failed to get package info", e)
            throw FlutterError("1001", e.message, e.cause)
        }
    }
}
