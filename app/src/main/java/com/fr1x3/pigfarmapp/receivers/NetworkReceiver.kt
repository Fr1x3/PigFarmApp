package com.fr1x3.pigfarmapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.fr1x3.pigfarmapp.util.Network
import com.google.android.material.snackbar.Snackbar

class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
            var message: String
            //check internet status and inform user on availability
            if(Network.isInternetConnected)
                message = "Back online"
            else
                message =" Gone Offline"

        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}