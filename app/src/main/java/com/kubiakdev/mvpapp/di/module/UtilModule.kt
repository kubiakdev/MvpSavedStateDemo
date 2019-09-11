package com.kubiakdev.mvpapp.di.module

import com.kubiakdev.mvpapp.util.SchedulerProvider
import com.kubiakdev.mvpapp.util.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProviderImpl()
    }
}