package com.example.system_info

import SystemInfoPigeon
import io.flutter.embedding.engine.plugins.FlutterPlugin
import android.content.Context


/** SystemInfoPlugin */
class SystemInfoPlugin: FlutterPlugin, SystemInfoPigeon {
  private lateinit var context: Context
  private var deviceInfo: DeviceInfo? = null
  private var appInfo: AppInfo? = null
  private var networkInfo: NetworkInfo? = null
  private var notificationInfo: NotificationInfo? = null
  private var screenInfo: ScreenInfo? = null

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    context = flutterPluginBinding.applicationContext
    SystemInfoPigeon.setUp(flutterPluginBinding.binaryMessenger, this)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    SystemInfoPigeon.setUp(binding.binaryMessenger, null)
  }

  private fun getDeviceInfoInstance() = deviceInfo ?: DeviceInfo(context).also { deviceInfo = it }
  private fun getAppInfoInstance() = appInfo ?: AppInfo(context).also { appInfo = it }
  private fun getNetworkInfoInstance() = networkInfo ?: NetworkInfo(context).also { networkInfo = it }
  private fun getNotificationInfoInstance() = notificationInfo ?: NotificationInfo(context).also { notificationInfo = it }
  private fun getScreenInfoInstance() = screenInfo ?: ScreenInfo(context).also { screenInfo = it }

  override fun getDeviceInfo() = getDeviceInfoInstance().getDeviceInfo()
  override fun getAppInfo() = getAppInfoInstance().getAppInfo()
  override fun isNetworkAvailable() = getNetworkInfoInstance().isNetworkAvailable()
  override fun networkConnections() = getNetworkInfoInstance().networkConnections()
  override fun isNotificationEnableForChannel(channelId: String) = getNotificationInfoInstance().isNotificationEnableForChannel(channelId)
  override fun openNotificationSetting() = getNotificationInfoInstance().openNotificationSetting()
  override fun getScreenInfo() = getScreenInfoInstance().getScreenInfo()
}
