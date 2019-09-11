package com.kubiakdev.mvpapp.di.module

import com.kubiakdev.mvpapp.di.scope.ActivityScope
import com.kubiakdev.mvpapp.main.MainActivity
import com.kubiakdev.mvpapp.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun bindMainActivity(): MainActivity
}