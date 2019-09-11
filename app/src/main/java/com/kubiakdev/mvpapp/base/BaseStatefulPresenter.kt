package com.kubiakdev.mvpapp.base

interface BaseStatefulPresenter<in V: BaseView, S: BaseState> {

    fun subscribe(view: V, state: S?)

    fun getState(): S

    fun unSubscribe()
}
