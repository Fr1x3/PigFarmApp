package com.fr1x3.pigfarmapp

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fr1x3.pigfarmapp.receivers.NetworkReceiver

class MainActivity : AppCompatActivity() {

    //variables
    lateinit var  networkReceiver :NetworkReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize network receiver
        registerNetworkReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()

        // unregister receiver
        this.unregisterReceiver(networkReceiver)
    }

    private fun registerNetworkReceiver() {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        networkReceiver  = NetworkReceiver()
        this.registerReceiver(networkReceiver, filter)
    }
}