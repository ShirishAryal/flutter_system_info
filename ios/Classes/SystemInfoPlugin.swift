import Flutter
import Foundation
import UIKit

public class SystemInfoPlugin: NSObject, FlutterPlugin, SystemInfoPigeon {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let messenger: FlutterBinaryMessenger = registrar.messenger()
    let api: SystemInfoPigeon = SystemInfoPlugin()
    SystemInfoPigeonSetup.setUp(binaryMessenger: messenger, api: api)
  }

  func getDeviceInfo() -> DeviceInfoModel {
    var deviceInfo = DeviceInfoModel()
    let device = UIDevice.current
    deviceInfo.osVersion = device.systemVersion
    deviceInfo.sdkVersion = nil
    deviceInfo.manufacturer = "Apple"
    deviceInfo.brand = "Apple"
    deviceInfo.model = modelIdentifier()
    deviceInfo.product = "iPhone"
    deviceInfo.device = "iPhone"
    deviceInfo.hardware = "iPhone"
    // For build information, we can use Bundle info
    let bundle = Bundle.main
    deviceInfo.buildId = bundle.object(forInfoDictionaryKey: "CFBundleVersion") as? String
    deviceInfo.buildType = "Release"
    // Set fingerprint to nil as iOS doesn't have a direct equivalent to Android's fingerprint
    deviceInfo.fingerprint = nil
    // Estimate device creation time
    deviceInfo.buildTime = estimateDeviceCreationTime()
    deviceInfo.board = getCPU()
    return deviceInfo
  }

  private func estimateDeviceCreationTime() -> Int64? {
    let fileManager = FileManager.default
    guard
      let appDirs = try? fileManager.contentsOfDirectory(
        at: fileManager.urls(for: .applicationDirectory, in: .systemDomainMask)[0],
        includingPropertiesForKeys: [.creationDateKey],
        options: [.skipsHiddenFiles, .skipsSubdirectoryDescendants])
    else {
      return nil
    }

    let oldestDate = appDirs.compactMap { url -> Date? in
      guard let attributes = try? fileManager.attributesOfItem(atPath: url.path),
        let creationDate = attributes[.creationDate] as? Date
      else {
        return nil
      }
      return creationDate
    }.min()

    return oldestDate.map { Int64($0.timeIntervalSince1970 * 1000) }
  }

  private func getCPU() -> String {
    var systemInfo = utsname()
    uname(&systemInfo)

    let machine = withUnsafePointer(to: &systemInfo) {
      $0.withMemoryRebound(to: CChar.self, capacity: 1) {
        String(cString: $0)
      }
    }

    return machine
  }
  func modelIdentifier() -> String {
    if let simulatorModelIdentifier = ProcessInfo().environment["SIMULATOR_MODEL_IDENTIFIER"] {
      return simulatorModelIdentifier
    }
    var sysinfo = utsname()
    uname(&sysinfo)  // ignore return value
    return String(bytes: Data(bytes: &sysinfo.machine, count: Int(_SYS_NAMELEN)), encoding: .ascii)!
      .trimmingCharacters(in: .controlCharacters)
  }

  // Method to gather app information
  func getAppInfo() -> ApplicationInfoModel {
    // Getting application info using Bundle
    guard
      let appName: String? = Bundle.main.object(forInfoDictionaryKey: "CFBundleName") as? String,
      let packageName = Bundle.main.bundleIdentifier,
      let versionName: String? = String(
        Bundle.main.object(
          forInfoDictionaryKey: "CFBundleShortVersionString")),
      let versionCode: String? = Bundle.main.object(forInfoDictionaryKey: "CFBundleVersion")
        as? String,
      let installTime: String? = Bundle.main.object(
        forInfoDictionaryKey: "CFBundleInfoDictionaryVersion")
        as? String,
      let lastUpdateTime: Int64? = Date().timeIntervalSince1970 as? Int64,
      let dataDirectory: String? = NSSearchPathForDirectoriesInDomains(
        .documentDirectory, .userDomainMask, true
      ).first,
      let sourceDirectory: String? = Bundle.main.bundlePath
    else {
      return ApplicationInfoModel()
    }

    // Note: Permissions in iOS are handled differently; you may need to check the Info.plist for specific permissions.

    return ApplicationInfoModel(
      appName: appName,
      packageName: packageName,
      versionName: versionName!,
      versionCode: Int64(versionCode) ?? 0,
      installTime: Int64(Date().timeIntervalSince1970 * 1000),  // current time in ms
      lastUpdateTime: Int64(Date().timeIntervalSince1970 * 1000),  // current time in ms
      dataDirectory: dataDirectory,
      sourceDirectory: sourceDirectory,
      permissions: []  // You may need to populate this with the app's required permissions if applicable.
    )
  }

  func getMinimumDeploymentTarget() -> String? {
    if let minimumOSVersion = Bundle.main.object(forInfoDictionaryKey: "MinimumOSVersion")
      as? String
    {
      return minimumOSVersion
    }
    return nil
  }

}
