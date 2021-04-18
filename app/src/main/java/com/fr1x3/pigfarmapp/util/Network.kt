package com.fr1x3.pigfarmapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.Network
import android.net.NetworkCapabilities.*
import android.net.NetworkInfo
import android.os.Build
import androidx.core.net.ConnectivityManagerCompat
import com.fr1x3.pigfarmapp.PigFarmApp

class Network  {

    companion object{
        val connectivityManager: ConnectivityManager =  PigFarmApp().getSystemService(Context.CONNECTIVITY_SERVICE)  as ConnectivityManager

        val isInternetConnected =
                        if( Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
                            connectivityManager.activeNetwork != null
                        }else{
                            (connectivityManager.activeNetworkInfo != null
                                    && connectivityManager.activeNetworkInfo?.isConnected == true)
                        }
    }

    // check if internet is connected
    fun isInternetConnected( ) : Boolean {

        return if( Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
                        connectivityManager.activeNetwork != null
                    }else{
                        (connectivityManager.activeNetworkInfo != null
                                && connectivityManager.activeNetworkInfo?.isConnected == true)
                    }

    }
}