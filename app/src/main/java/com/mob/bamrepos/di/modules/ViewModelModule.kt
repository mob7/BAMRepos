package com.mob.bamrepos.di.modules

import androidx.lifecycle.ViewModel
import com.mob.bamrepos.di.ViewModelKey
import com.mob.bamrepos.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

}