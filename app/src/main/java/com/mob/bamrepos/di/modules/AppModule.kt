package com.mob.bamrepos.di.modules

import android.content.Context
import com.mob.bamrepos.BamReposApp
import com.mob.bamrepos.network.ApiService
import com.mob.bamrepos.repositories.MainRepo
import com.mob.bamrepos.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, ViewModelFactoryModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideContext(application: BamReposApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    @Inject
    fun provideMainRepo(apiService: ApiService): MainRepo =
        MainRepo(apiService)

}