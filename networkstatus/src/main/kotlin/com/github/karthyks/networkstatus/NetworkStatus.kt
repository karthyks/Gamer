package com.github.karthyks.networkstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

const val CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"

class NetworkStatus private constructor(
    private val context: Context,
    val callback: (Boolean) -> Unit
) : LifecycleObserver {


    constructor(
        activity: AppCompatActivity,
        callback: (Boolean) -> Unit = {}
    ) : this(activity.baseContext, callback) {
        activity.lifecycle.addObserver(this)
    }

    constructor(
        fragment: Fragment,
        callback: (Boolean) -> Unit = {}
    ) : this(fragment.context!!, callback) {
        fragment.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun registerNetworkObserver() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        }
        context.registerReceiver(networkReceiver, IntentFilter(CONNECTIVITY_CHANGE_ACTION))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun unregisterNetworkObserver() {
        context.unregisterReceiver(networkReceiver)
    }

    private val networkReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val connectionManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE)
            (connectionManager as? ConnectivityManager)?.run {
                val isConnected: Boolean =
                    activeNetworkInfo != null && activeNetworkInfo.isConnected
                callback(isConnected)
            }
        }
    }
}