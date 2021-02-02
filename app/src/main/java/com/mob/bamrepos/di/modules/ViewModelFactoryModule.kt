package com.mob.bamrepos.di.modules

import androidx.lifecycle.ViewModelProvider
import com.mob.bamrepos.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}