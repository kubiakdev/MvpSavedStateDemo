package com.kubiakdev.mvpapp.main.usecase

import com.kubiakdev.mvpapp.data.DummyRepository
import com.kubiakdev.mvpapp.util.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class LoadNamesUseCase @Inject constructor(
    private val repository: DummyRepository,
    private val schedulerProvider: SchedulerProvider
) {

    fun loadNames(): Single<List<String>> {
        return repository.getNames()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }
}