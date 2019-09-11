package com.kubiakdev.mvpapp.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}