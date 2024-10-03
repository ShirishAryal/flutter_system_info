package com.example.system_info

import ConnectionType
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkInfo(private val context: Context) {
    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork?.let {
                connectivityManager.getNetworkCapabilities(it)
            }
            networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            activeNetworkInfo?.isConnected == true
        }
    }

    fun networkConnections(): List<ConnectionType> {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val connectionType = mutableListOf<ConnectionType>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val connections = connectivityManager.allNetworks
            for (connection in connections) {
                val capabilities = connectivityManager.getNetworkCapabilities(connection)
                when {
                    capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true -> {
                        connectionType.add(ConnectionType.WIFI)
                    }
                    capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true -> {
                        connectionType.add(ConnectionType.MOBILE_DATA)
                    }
                    capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) == true -> {
                        connectionType.add(ConnectionType.BLUETOOTH)
                    }
                }
            }
        } else {
            val networkInfo = connectivityManager.allNetworkInfo
            for (info in networkInfo) {
                when (info.type) {
                    ConnectivityManager.TYPE_WIFI -> connectionType.add(ConnectionType.WIFI)
                    ConnectivityManager.TYPE_MOBILE -> connectionType.add(ConnectionType.MOBILE_DATA)
                    ConnectivityManager.TYPE_BLUETOOTH -> connectionType.add(ConnectionType.BLUETOOTH)
                }
            }
        }
        return connectionType
    }
}
