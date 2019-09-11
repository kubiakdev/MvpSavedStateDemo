package com.kubiakdev.mvpapp.di.module

import com.kubiakdev.mvpapp.util.SchedulerProvider
import com.kubiakdev.mvpapp.util.SchedulerProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProviderImpl()
    }
}