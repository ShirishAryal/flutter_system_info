// Autogenerated from Pigeon (v22.4.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon
@file:Suppress("UNCHECKED_CAST", "ArrayInDataClass")


import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  return if (exception is FlutterError) {
    listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

enum class ConnectionType(val raw: Int) {
  WIFI(0),
  MOBILE_DATA(1),
  BLUETOOTH(2);

  companion object {
    fun ofRaw(raw: Int): ConnectionType? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class DeviceInfoModel (
  /** The user-visible version string of the Android/iOS (e.g., "13") */
  val osVersion: String? = null,
  /** The SDK version of the software running on this hardware device (e.g., 33 for Android 13) */
  val sdkVersion: Long? = null,
  /** The manufacturer of the product/hardware (e.g., "Samsung") */
  val manufacturer: String? = null,
  /** The consumer-visible brand with which the product/hardware will be associated (e.g., "Google") */
  val brand: String? = null,
  /** The end-user-visible name for the end product (e.g., "Pixel 6") */
  val model: String? = null,
  /** The name of the overall product (e.g., "sailfish") */
  val product: String? = null,
  /** The name of the industrial design (e.g., "sailfish") */
  val device: String? = null,
  /** The name of the hardware (from the kernel command line or /proc) (e.g., "qcom") */
  val hardware: String? = null,
  /** The name of the underlying board (e.g., "goldfish") */
  val board: String? = null,
  /** A build ID string meant for displaying to the user (e.g., "NMF26Q") */
  val buildId: String? = null,
  /** The type of build, like "user" or "eng" */
  val buildType: String? = null,
  /** The time at which the build was produced, given in milliseconds since the epoch */
  val buildTime: Long? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): DeviceInfoModel {
      val osVersion = pigeonVar_list[0] as String?
      val sdkVersion = pigeonVar_list[1] as Long?
      val manufacturer = pigeonVar_list[2] as String?
      val brand = pigeonVar_list[3] as String?
      val model = pigeonVar_list[4] as String?
      val product = pigeonVar_list[5] as String?
      val device = pigeonVar_list[6] as String?
      val hardware = pigeonVar_list[7] as String?
      val board = pigeonVar_list[8] as String?
      val buildId = pigeonVar_list[9] as String?
      val buildType = pigeonVar_list[10] as String?
      val buildTime = pigeonVar_list[11] as Long?
      return DeviceInfoModel(osVersion, sdkVersion, manufacturer, brand, model, product, device, hardware, board, buildId, buildType, buildTime)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      osVersion,
      sdkVersion,
      manufacturer,
      brand,
      model,
      product,
      device,
      hardware,
      board,
      buildId,
      buildType,
      buildTime,
    )
  }
}

/**
 * A class representing detailed information about an Android application.
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class ApplicationInfoModel (
  /** The name of the application. */
  val appName: String? = null,
  /** The package name of the application. */
  val packageName: String? = null,
  /** The version name of the application. */
  val versionName: String? = null,
  /** The version code of the application. */
  val versionCode: Long? = null,
  /** The timestamp when the application was first installed (in milliseconds since epoch). */
  val installTime: Long? = null,
  /** The timestamp when the application was last updated (in milliseconds since epoch). */
  val lastUpdateTime: Long? = null,
  /** The target SDK version of the application. */
  val targetSdkVersion: Long? = null,
  /** The minimum SDK version required by the application. */
  val minSdkVersion: Long? = null,
  /** The path to the application's data directory. */
  val dataDirectory: String? = null,
  /** The path to the application's APK file. */
  val sourceDirectory: String? = null,
  /** The list of permissions requested by the application. */
  val permissions: List<String>? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): ApplicationInfoModel {
      val appName = pigeonVar_list[0] as String?
      val packageName = pigeonVar_list[1] as String?
      val versionName = pigeonVar_list[2] as String?
      val versionCode = pigeonVar_list[3] as Long?
      val installTime = pigeonVar_list[4] as Long?
      val lastUpdateTime = pigeonVar_list[5] as Long?
      val targetSdkVersion = pigeonVar_list[6] as Long?
      val minSdkVersion = pigeonVar_list[7] as Long?
      val dataDirectory = pigeonVar_list[8] as String?
      val sourceDirectory = pigeonVar_list[9] as String?
      val permissions = pigeonVar_list[10] as List<String>?
      return ApplicationInfoModel(appName, packageName, versionName, versionCode, installTime, lastUpdateTime, targetSdkVersion, minSdkVersion, dataDirectory, sourceDirectory, permissions)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      appName,
      packageName,
      versionName,
      versionCode,
      installTime,
      lastUpdateTime,
      targetSdkVersion,
      minSdkVersion,
      dataDirectory,
      sourceDirectory,
      permissions,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class ScreenInfoModel (
  /** The width of the screen in physical pixels. */
  val widthPixels: Long? = null,
  /** The height of the screen in physical pixels. */
  val heightPixels: Long? = null,
  /** The screen density expressed as dots-per-inch. */
  val densityDpi: Long? = null,
  /** A scaling factor for fonts displayed on the screen. */
  val density: Double? = null,
  /** A scaling factor for the Scalable Pixel (sp) unit. */
  val scaledDensity: Double? = null,
  /** The absolute width of the display in density-independent pixels (dp). */
  val widthDp: Double? = null,
  /** The absolute height of the display in density-independent pixels (dp). */
  val heightDp: Double? = null,
  /** The current brightness of the screen, from 0 (lowest) to 1 (highest). */
  val brightnessLevel: Double? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): ScreenInfoModel {
      val widthPixels = pigeonVar_list[0] as Long?
      val heightPixels = pigeonVar_list[1] as Long?
      val densityDpi = pigeonVar_list[2] as Long?
      val density = pigeonVar_list[3] as Double?
      val scaledDensity = pigeonVar_list[4] as Double?
      val widthDp = pigeonVar_list[5] as Double?
      val heightDp = pigeonVar_list[6] as Double?
      val brightnessLevel = pigeonVar_list[7] as Double?
      return ScreenInfoModel(widthPixels, heightPixels, densityDpi, density, scaledDensity, widthDp, heightDp, brightnessLevel)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      widthPixels,
      heightPixels,
      densityDpi,
      density,
      scaledDensity,
      widthDp,
      heightDp,
      brightnessLevel,
    )
  }
}
private open class SystemInfoApiPigeonCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      129.toByte() -> {
        return (readValue(buffer) as Long?)?.let {
          ConnectionType.ofRaw(it.toInt())
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          DeviceInfoModel.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ApplicationInfoModel.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ScreenInfoModel.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is ConnectionType -> {
        stream.write(129)
        writeValue(stream, value.raw)
      }
      is DeviceInfoModel -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is ApplicationInfoModel -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is ScreenInfoModel -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface SystemInfoPigeon {
  fun getDeviceInfo(): DeviceInfoModel
  fun getAppInfo(): ApplicationInfoModel
  fun isNetworkAvailable(): Boolean
  fun networkConnections(): List<ConnectionType>
  fun isNotificationEnableForChannel(channelId: String): Boolean
  fun openNotificationSetting(): Boolean
  fun getScreenInfo(): ScreenInfoModel

  companion object {
    /** The codec used by SystemInfoPigeon. */
    val codec: MessageCodec<Any?> by lazy {
      SystemInfoApiPigeonCodec()
    }
    /** Sets up an instance of `SystemInfoPigeon` to handle messages through the `binaryMessenger`. */
    @JvmOverloads
    fun setUp(binaryMessenger: BinaryMessenger, api: SystemInfoPigeon?, messageChannelSuffix: String = "") {
      val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.getDeviceInfo$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.getDeviceInfo())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.getAppInfo$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.getAppInfo())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.isNetworkAvailable$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.isNetworkAvailable())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.networkConnections$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.networkConnections())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.isNotificationEnableForChannel$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val channelIdArg = args[0] as String
            val wrapped: List<Any?> = try {
              listOf(api.isNotificationEnableForChannel(channelIdArg))
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.openNotificationSetting$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.openNotificationSetting())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.system_info.SystemInfoPigeon.getScreenInfo$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              listOf(api.getScreenInfo())
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
