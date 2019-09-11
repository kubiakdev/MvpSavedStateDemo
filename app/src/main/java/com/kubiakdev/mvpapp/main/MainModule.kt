package com.kubiakdev.mvpapp.main

import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun providePresenter(presenter: MainPresenter): MainContract.Presenter
}