package com.mob.bamrepos

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class CheckConnectionTest {
    @Test
    fun checkInternetConnection() {
        var assertConnectionCheck: Boolean = false
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val manager: ConnectivityManager =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = manager.activeNetworkInfo
        assertConnectionCheck = networkInfo != null && networkInfo.isConnectedOrConnecting
        assertEquals(assertConnectionCheck, true)
    }

}