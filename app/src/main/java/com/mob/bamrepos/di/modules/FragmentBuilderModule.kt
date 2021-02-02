package com.mob.bamrepos.di.modules

import com.mob.bamrepos.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

}