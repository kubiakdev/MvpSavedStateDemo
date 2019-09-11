package com.kubiakdev.mvpapp.di.module

import com.kubiakdev.mvpapp.data.DummyRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun repository(): DummyRepository = DummyRepository()
}