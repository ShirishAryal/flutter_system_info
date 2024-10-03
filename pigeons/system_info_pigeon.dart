import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(
  PigeonOptions(
    dartOut: 'lib/src/system_info.g.dart',
    dartOptions: DartOptions(),
    kotlinOut: 'android/src/main/kotlin/com/example/system_info/SystemInfoApi.g.kt',
    kotlinOptions: KotlinOptions(),
    swiftOut: 'ios/Classes/SystemInfoApi.g.swift',
    swiftOptions: SwiftOptions(),
  ),
)
@HostApi()
abstract class SystemInfoPigeon {
  DeviceInfoModel getDeviceInfo();
  ApplicationInfoModel getAppInfo();
  bool isNetworkAvailable();
  List<ConnectionType> networkConnections();
  bool isNotificationEnableForChannel({required String channelId});
  bool openNotificationSetting();
  ScreenInfoModel getScreenInfo();
}

// A class representing the details about current device
class DeviceInfoModel {
  /// The user-visible version string of the Android/iOS (e.g., "13")
  final String? osVersion;

  /// The SDK version of the software running on this hardware device (e.g., 33 for Android 13)
  final int? sdkVersion;

  /// The manufacturer of the product/hardware (e.g., "Samsung")
  final String? manufacturer;

  /// The consumer-visible brand with which the product/hardware will be associated (e.g., "Google")
  final String? brand;

  /// The end-user-visible name for the end product (e.g., "Pixel 6")
  final String? model;

  /// The name of the overall product (e.g., "sailfish")
  final String? product;

  /// The name of the industrial design (e.g., "sailfish")
  final String? device;

  /// The name of the hardware (from the kernel command line or /proc) (e.g., "qcom")
  final String? hardware;

  /// The name of the underlying board (e.g., "goldfish")
  final String? board;

  /// A build ID string meant for displaying to the user (e.g., "NMF26Q")
  final String? buildId;

  /// The type of build, like "user" or "eng"
  final String? buildType;

  /// The time at which the build was produced, given in milliseconds since the epoch
  final int? buildTime;

  DeviceInfoModel({
    this.osVersion,
    this.sdkVersion,
    this.manufacturer,
    this.brand,
    this.model,
    this.product,
    this.device,
    this.hardware,
    this.board,
    this.buildId,
    this.buildType,
    this.buildTime,
  });
}

/// A class representing detailed information about an Android application.
class ApplicationInfoModel {
  /// The name of the application.
  final String? appName;

  /// The package name of the application.
  final String? packageName;

  /// The version name of the application.
  final String? versionName;

  /// The version code of the application.
  final int? versionCode;

  /// The timestamp when the application was first installed (in milliseconds since epoch).
  final int? installTime;

  /// The timestamp when the application was last updated (in milliseconds since epoch).
  final int? lastUpdateTime;

  /// The target SDK version of the application.
  final int? targetSdkVersion;

  /// The minimum SDK version required by the application.
  final int? minSdkVersion;

  /// The path to the application's data directory.
  final String? dataDirectory;

  /// The path to the application's APK file.
  final String? sourceDirectory;

  /// The list of permissions requested by the application.
  final List<String>? permissions;

  /// Constructs an [ApplicationInfoModel] instance.
  ApplicationInfoModel({
    this.appName,
    this.packageName,
    this.versionName,
    this.versionCode,
    this.installTime,
    this.lastUpdateTime,
    this.targetSdkVersion,
    this.minSdkVersion,
    this.dataDirectory,
    this.sourceDirectory,
    this.permissions,
  });
}

class ScreenInfoModel {
  /// The width of the screen in physical pixels.
  final int? widthPixels;

  /// The height of the screen in physical pixels.
  final int? heightPixels;

  /// The screen density expressed as dots-per-inch.
  final int? densityDpi;

  /// A scaling factor for fonts displayed on the screen.
  final double? density;

  /// A scaling factor for the Scalable Pixel (sp) unit.
  final double? scaledDensity;

  /// The absolute width of the display in density-independent pixels (dp).
  final double? widthDp;

  /// The absolute height of the display in density-independent pixels (dp).
  final double? heightDp;

  /// The current brightness of the screen, from 0 (lowest) to 1 (highest).
  final double? brightnessLevel;

  ScreenInfoModel({
    this.widthPixels,
    this.heightPixels,
    this.densityDpi,
    this.density,
    this.scaledDensity,
    this.widthDp,
    this.heightDp,
    this.brightnessLevel,
  });
}

enum ConnectionType { wifi, mobileData, bluetooth }
