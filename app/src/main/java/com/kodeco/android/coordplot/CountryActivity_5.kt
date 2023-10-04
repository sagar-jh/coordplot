package com.kodeco.android.coordplot

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.kodeco.android.coordplot.CountryApp.UI.CountryInfoScreen
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

class CountryActivity_5 : AppCompatActivity() {
    var hasNetwork:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO build out the retrofit service and reference it here.
        //  Pass the service in to the CountryInfoScreen composable below.

        setContent {
            MyApplicationTheme {
                // TODO complete the composable content and provide
                //  models for Country, CountryName, and CountryFlags.
                hasNetwork=checkNetwork()

                CountryInfoScreen(hasNetwork)
            }
        }
    }
    fun checkNetwork():Boolean{
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        val network=connectivityManager?.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        connectivityManager.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network : Network) {
                //Log.e(TAG, "The default network is now: " + network)

            }

            override fun onLost(network : Network) {
                //Log.e(TAG, "The application no longer has a default network. The last default network was " + network)

            }

            override fun onCapabilitiesChanged(network : Network, networkCapabilities : NetworkCapabilities) {
                //Log.e(TAG, "The default network changed capabilities: " + networkCapabilities)
            }

            override fun onLinkPropertiesChanged(network : Network, linkProperties : LinkProperties) {
                //Log.e(TAG, "The default network changed link properties: " + linkProperties)
            }
        })

        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)




    }
}
