import 'dart:developer';

import 'package:flutter/material.dart';
import 'dart:async';
import 'package:system_info/system_info.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: _SystemInfo(),
      ),
    );
  }
}

class _SystemInfo extends StatefulWidget {
  @override
  State<_SystemInfo> createState() => _SystemInfoState();
}

class _SystemInfoState extends State<_SystemInfo> {
  DeviceInfoModel? _deviceInfo;

  @override
  void initState() {
    getInfo();
    super.initState();
  }

  final systemInfo = SystemInfoPigeon();

  Future<void> getInfo() async {
    _deviceInfo = await systemInfo.getDeviceInfo();
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('Android Version: ${_deviceInfo?.osVersion ?? "Unknown"}'),
        TextButton(
          onPressed: () async {
            final result = await systemInfo.openNotificationSetting();
            log(result.toString());
          },
          child: const Text('Notification Settings'),
        )
      ],
    );
  }
}
