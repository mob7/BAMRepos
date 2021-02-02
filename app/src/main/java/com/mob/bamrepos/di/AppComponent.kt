package com.mob.bamrepos.di

import com.mob.bamrepos.BamReposApp
import com.mob.bamrepos.di.modules.ActivityBuilderModule
import com.mob.bamrepos.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent : AndroidInjector<BamReposApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BamReposApp): Builder
        fun build(): AppComponent
    }

}