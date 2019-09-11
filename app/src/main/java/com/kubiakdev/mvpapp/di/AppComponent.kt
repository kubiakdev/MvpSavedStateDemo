package com.kubiakdev.mvpapp.di

import android.app.Application
import com.kubiakdev.mvpapp.App
import com.kubiakdev.mvpapp.di.module.ActivityBuilderModule
import com.kubiakdev.mvpapp.di.module.DataModule
import com.kubiakdev.mvpapp.di.module.UtilModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        DataModule::class,
        UtilModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}