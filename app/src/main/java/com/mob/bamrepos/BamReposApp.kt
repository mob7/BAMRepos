package com.mob.bamrepos

import android.content.Context
import com.mob.bamrepos.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BamReposApp : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)

        return appComponent
    }

    fun getAppContext(): Context {
        return applicationContext;
    }

}