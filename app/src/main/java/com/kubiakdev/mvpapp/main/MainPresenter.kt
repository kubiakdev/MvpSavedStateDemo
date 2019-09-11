package com.kubiakdev.mvpapp.main

import com.kubiakdev.mvpapp.main.usecase.LoadNamesUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val useCase: LoadNamesUseCase
) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: MainContract.View? = null
    private var names: List<String>? = null

    override fun subscribe(view: MainContract.View, state: MainContract.State?) {
        this.view = view
        state?.let {
            names = it.names
        }
    }

    override fun onCreate() {
        if (names == null) {
            loadNames()
        }
    }

    private fun loadNames() {
        compositeDisposable.add(
            useCase.loadNames()
                .subscribe(
                    Consumer {
                        names = it
                        view?.displayNames(it)
                    },
                    Functions.emptyConsumer()
                )
        )
    }

    override fun getState(): MainContract.State {
        return MainState(names)
    }

    override fun unSubscribe() {
        view = null
        compositeDisposable.dispose()
    }
}